package br.com.fiap3espa.auto_escola_3espa.controller;

import br.com.fiap3espa.auto_escola_3espa.domain.usuario.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // ─── Apenas ADMIN ────────────────────────────────────────────────────────

    @PostMapping
    @Transactional
    public ResponseEntity<DadosListagemUsuario> cadastrar(
            @RequestBody @Valid DadosCadastroUsuario dados,
            UriComponentsBuilder uriBuilder) {

        String senhaCriptografada = passwordEncoder.encode(dados.senha());
        var usuario = new Usuario(dados, senhaCriptografada);
        repository.save(usuario);

        var uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosListagemUsuario(usuario));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemUsuario>> listar(
            @PageableDefault(size = 10, sort = "login") Pageable pageable) {

        var page = repository.findAll(pageable).map(DadosListagemUsuario::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemUsuario> detalhar(@PathVariable Long id) {
        var usuario = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosListagemUsuario(usuario));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosListagemUsuario> atualizar(
            @PathVariable Long id,
            @RequestBody DadosAtualizacaoUsuario dados) {

        var usuario = repository.getReferenceById(id);
        usuario.atualizarDados(dados);
        return ResponseEntity.ok(new DadosListagemUsuario(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // ─── Usuário autenticado altera a própria senha ───────────────────────────

    @PatchMapping("/senha")
    @Transactional
    public ResponseEntity<Void> alterarSenha(
            @RequestBody @Valid DadosAlteracaoSenha dados,
            @AuthenticationPrincipal Usuario usuarioLogado) {

        if (!passwordEncoder.matches(dados.senhaAtual(), usuarioLogado.getSenha())) {
            return ResponseEntity.badRequest().build();
        }

        String novaSenhaCriptografada = passwordEncoder.encode(dados.novaSenha());
        usuarioLogado.alterarSenha(novaSenhaCriptografada);
        return ResponseEntity.noContent().build();
    }
}

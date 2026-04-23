package br.com.fiap3espa.auto_escola_3espa.adapter.in.controller;

import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.mapper.InstrutorMapper;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.instrutor.DadosAtualizacaoInstutor;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.instrutor.DadosCadastroInstrutor;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.response.instrutor.DadosDetalhamentoInstrutor;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.response.instrutor.DadosListagemInstrutor;
import br.com.fiap3espa.auto_escola_3espa.adapter.out.repository.persistence.InstrutorRepository;
import br.com.fiap3espa.auto_escola_3espa.application.core.domain.model.Instrutor;
import br.com.fiap3espa.auto_escola_3espa.application.core.domain.vo.Endereco;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @Autowired
    private InstrutorMapper mapper;

    @PostMapping
    @Transactional
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<DadosDetalhamentoInstrutor> cadastrarInstrutor(
            @RequestBody @Valid DadosCadastroInstrutor dados,
            UriComponentsBuilder uriBuilder) {
        Instrutor instrutor = mapper.toDomain(dados);
        repository.save(instrutor);
        URI uri = uriBuilder.path("/instrutores/{id}").buildAndExpand(instrutor.getId()).toUri();
        return ResponseEntity.created(uri).body(mapper.toDetailsDTO(instrutor));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemInstrutor>> listarInstrutores(
            @PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        Page<DadosListagemInstrutor> page = repository.findAllByAtivoTrue(paginacao)
                .map(mapper::toListDTO);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoInstrutor> atualizarInstrutor(
            @RequestBody @Valid DadosAtualizacaoInstutor dados) {
        Instrutor instrutor = repository.getReferenceById(dados.id());

        // Converte DadosEndereco → Endereco VO antes de passar para o domain
        Endereco enderecoVO = dados.endereco() != null ? new Endereco(dados.endereco()) : null;

        instrutor.atualizarInformacoes(dados.nome(), dados.telefone(), enderecoVO);
        return ResponseEntity.ok(mapper.toDetailsDTO(instrutor));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluirInstrutor(@PathVariable Long id) {
        Instrutor instrutor = repository.getReferenceById(id);
        instrutor.excluir();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoInstrutor> detalharInstrutor(@PathVariable Long id) {
        Instrutor instrutor = repository.getReferenceById(id);
        return ResponseEntity.ok(mapper.toDetailsDTO(instrutor));
    }
}
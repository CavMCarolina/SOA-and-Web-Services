package br.com.fiap3espa.AutoEscola_3ESPA.controller;

import br.com.fiap3espa.AutoEscola_3ESPA.instrutor.DadosCadastroInstrutor;
import br.com.fiap3espa.AutoEscola_3ESPA.instrutor.DadosListagemInstrutor;
import br.com.fiap3espa.AutoEscola_3ESPA.instrutor.Instrutor;
import br.com.fiap3espa.AutoEscola_3ESPA.instrutor.InstrutorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {
    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarInstrutor(@RequestBody DadosCadastroInstrutor dados) {
    // System.out.println("Nome: " + dados.nome() + "\nEmail: " + dados.email() + "\nCNH: " + dados.cnh() + "\nEspecialidade: " + dados.especialidade());
    // System.out.println("Endereço: " + dados.endereco().bairro() + ", " + dados.endereco().cidade() + " - " + dados.endereco().uf());

        repository.save(new Instrutor(dados));
    }

    @GetMapping
    public Page<DadosListagemInstrutor> listarIntrutores(@PageableDefault(size = 2, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemInstrutor::new);
    }

    @PutMapping
    public void atualizarInstrutor() {

    }

    @DeleteMapping
    public void excluirInstrutor() {

    }
}

// JSON
// {
//     "nome": "Ágatha Magalhães",
//     "email": "AM.contato@gmail.com",
//     "cnh": "01234567890",
//     "especialidade": "MOTOS",
//     "endereco": {
//         "logradouro": "Rua Calçada Florida",
//         "numero": "450",
//         "complemento": "Apto. 83C",
//         "bairro": "Jardim Orquídeas",
//         "cidade": "São Paulo",
//         "uf": "SP",
//         "cep": "53681000"
//     }
// }

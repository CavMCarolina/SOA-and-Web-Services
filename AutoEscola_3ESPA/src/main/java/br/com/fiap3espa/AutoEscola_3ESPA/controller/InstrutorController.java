package br.com.fiap3espa.AutoEscola_3ESPA.controller;

import br.com.fiap3espa.AutoEscola_3ESPA.instrutor.DadosCadastroInstrutor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/instrutores")
public class InstrutorController {
    // Identificar o metodo
    @PostMapping
    public void cadastrarInstrutor(@RequestBody DadosCadastroInstrutor dados) {
        System.out.println("Nome: " + dados.nome() + "\nEmail: " + dados.email() + "\nCNH: " + dados.cnh() + "\nEspecialidade: " + dados.especialidade());
        System.out.println("Endereço: " + dados.endereco().bairro() + ", " + dados.endereco().cidade() + " - " + dados.endereco().uf());

    }
}

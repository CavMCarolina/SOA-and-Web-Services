package br.com.fiap3espa.AutoEscola_3ESPA.instrutor;

import br.com.fiap3espa.AutoEscola_3ESPA.endereco.DadosEndereco;

public record DadosCadastroInstrutor(
        String nome,
        String email,
        String cnh,
        Especialidade especialidade,
        DadosEndereco endereco) {
}

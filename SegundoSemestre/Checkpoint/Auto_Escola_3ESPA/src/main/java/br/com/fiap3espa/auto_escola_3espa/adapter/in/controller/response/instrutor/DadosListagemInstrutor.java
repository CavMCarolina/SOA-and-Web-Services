package br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.response.instrutor;

import br.com.fiap3espa.auto_escola_3espa.application.core.domain.enums.Especialidade;

public record DadosListagemInstrutor(
        Long id,
        String nome,
        String email,
        String cnh,
        Especialidade especialidade) {
}
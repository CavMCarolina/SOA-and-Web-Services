package br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.instrutor;

import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoInstutor(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
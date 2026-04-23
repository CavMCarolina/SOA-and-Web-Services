package br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.instrucao;

import br.com.fiap3espa.auto_escola_3espa.application.core.domain.enums.MotivoCancelamento;
import jakarta.validation.constraints.NotNull;

public record DadosCancelamentoInstrucao(
        @NotNull Long idInstrucao,
        @NotNull MotivoCancelamento motivo) {
}

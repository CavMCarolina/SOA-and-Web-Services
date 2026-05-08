package br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.instrucao;

import br.com.fiap3espa.auto_escola_3espa.application.core.domain.enums.Especialidade;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DadosAgendamentoInstrucao(
        @NotNull
        Long idAluno,
        Long idInstrutor,
        Especialidade especialidade,

        @NotNull
        @Future
        @JsonFormat(pattern = "dd/MM/yyyy - HH:mm") // yyyy-MM-ddTHH:mm:ss
        LocalDateTime data) {
}
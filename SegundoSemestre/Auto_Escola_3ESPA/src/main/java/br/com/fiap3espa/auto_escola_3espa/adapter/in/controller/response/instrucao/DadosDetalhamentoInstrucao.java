package br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.response.instrucao;

import br.com.fiap3espa.auto_escola_3espa.application.core.domain.model.Instrucao;
import br.com.fiap3espa.auto_escola_3espa.application.core.domain.enums.Especialidade;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public record DadosDetalhamentoInstrucao(
        Long id,
        String nomeAluno,
        String nomeInstrutor,
        Especialidade especialidade,

        @JsonFormat(pattern = "dd/MM/yyyy - HH:mm")
        LocalDateTime data) {
    public DadosDetalhamentoInstrucao(Instrucao instrucao) {
        this(
                instrucao.getId(),
                instrucao.getAluno().getNome(),
                instrucao.getInstrutor().getNome(),
                instrucao.getInstrutor().getEspecialidade(),
                instrucao.getData());
    }
}
package br.com.fiap3espa.auto_escola_3espa.application.core.validation.interfaces;

import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.instrucao.DadosAgendamentoInstrucao;

public interface ValidacoesDeAgendamento {
    void validar(DadosAgendamentoInstrucao dados);
}

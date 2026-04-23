package br.com.fiap3espa.auto_escola_3espa.application.core.validation.agendamento;

import br.com.fiap3espa.auto_escola_3espa.application.core.validation.interfaces.ValidacoesDeAgendamento;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import br.com.fiap3espa.auto_escola_3espa.adapter.out.repository.persistence.InstrucaoRepository;
import br.com.fiap3espa.auto_escola_3espa.exception.type.instrucao.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorConflitoHorarioInstrutor implements ValidacoesDeAgendamento {

    @Autowired
    private InstrucaoRepository repository;

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        if (dados.idInstrutor() == null) return;

        Boolean conflito = repository.existeConflitoPorInstrutorNaData(dados.idInstrutor(), dados.data());

        if (Boolean.TRUE.equals(conflito)) {
            throw new ValidacaoException("O instrutor informado já possui uma instrução agendada neste horário!");
        }
    }
}

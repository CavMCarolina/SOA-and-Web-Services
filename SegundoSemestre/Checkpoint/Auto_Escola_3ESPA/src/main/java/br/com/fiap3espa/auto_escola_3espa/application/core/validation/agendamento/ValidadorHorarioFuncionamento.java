package br.com.fiap3espa.auto_escola_3espa.application.core.validation.agendamento;

import br.com.fiap3espa.auto_escola_3espa.application.core.validation.interfaces.ValidacoesDeAgendamento;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import br.com.fiap3espa.auto_escola_3espa.exception.type.instrucao.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

@Component
public class ValidadorHorarioFuncionamento implements ValidacoesDeAgendamento {
    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        LocalDateTime agendamento = dados.data();

        Boolean domingo = agendamento.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        Boolean preAbertura = agendamento.getHour() < 6;
        Boolean posFechamento = agendamento.getHour() > (21 - 1);

        if(domingo || preAbertura || posFechamento) {
            throw new ValidacaoException("Tentativa de agendamento fora do horário de funcionamento da Auto Escola!");
        }
    }
}
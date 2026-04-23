package br.com.fiap3espa.auto_escola_3espa.application.core.validation.agendamento;

import br.com.fiap3espa.auto_escola_3espa.application.core.validation.interfaces.ValidacoesDeAgendamento;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import br.com.fiap3espa.auto_escola_3espa.adapter.out.repository.persistence.InstrucaoRepository;
import br.com.fiap3espa.auto_escola_3espa.exception.type.instrucao.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorLimiteDiarioAluno implements ValidacoesDeAgendamento {

    @Autowired
    private InstrucaoRepository repository;

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        Integer total = repository.countInstrucoesAtivasPorAlunoNoDia(dados.idAluno(), dados.data());

        if (total >= 2) {
            throw new ValidacaoException("Não é permitido agendar mais de 2 instruções no mesmo dia para o mesmo aluno!");
        }
    }
}

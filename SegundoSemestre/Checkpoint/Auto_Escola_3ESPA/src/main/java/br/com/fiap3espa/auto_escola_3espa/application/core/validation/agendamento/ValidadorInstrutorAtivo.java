package br.com.fiap3espa.auto_escola_3espa.application.core.validation.agendamento;

import br.com.fiap3espa.auto_escola_3espa.application.core.domain.model.Instrutor;
import br.com.fiap3espa.auto_escola_3espa.application.core.validation.interfaces.ValidacoesDeAgendamento;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import br.com.fiap3espa.auto_escola_3espa.adapter.out.repository.persistence.InstrutorRepository;
import br.com.fiap3espa.auto_escola_3espa.exception.type.instrucao.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorInstrutorAtivo implements ValidacoesDeAgendamento {

    @Autowired
    private InstrutorRepository repository;

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        if (dados.idInstrutor() == null) return;
        if (!repository.existsById(dados.idInstrutor())) return;

        Instrutor instrutor = repository.getReferenceById(dados.idInstrutor());
        if (!instrutor.getAtivo()) {
            throw new ValidacaoException("Instrução não pode ser agendada com instrutor inativo!");
        }
    }
}

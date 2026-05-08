package br.com.fiap3espa.auto_escola_3espa.application.core.validation.agendamento;

import br.com.fiap3espa.auto_escola_3espa.application.core.validation.interfaces.ValidacoesDeAgendamento;
import br.com.fiap3espa.auto_escola_3espa.application.port.out.AlunoRepository;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import br.com.fiap3espa.auto_escola_3espa.exception.type.instrucao.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorAlunoAtivo implements ValidacoesDeAgendamento {
    @Autowired
    private AlunoRepository repository;

    @Override
    public void validar(DadosAgendamentoInstrucao dados) {
        Boolean alunoAtivo = repository.findAtivoById(dados.idAluno());

        if(!alunoAtivo) {
            throw new ValidacaoException("Instrução não pode ser agendada por aluno inativo!");
        }
    }
}
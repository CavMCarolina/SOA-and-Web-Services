package br.com.fiap3espa.auto_escola_3espa.application.core.usecase;

import br.com.fiap3espa.auto_escola_3espa.application.core.domain.model.Aluno;
import br.com.fiap3espa.auto_escola_3espa.application.core.domain.model.Instrucao;
import br.com.fiap3espa.auto_escola_3espa.exception.type.aluno.AlunoNotFoundException;
import br.com.fiap3espa.auto_escola_3espa.adapter.out.repository.persistence.AlunoRepository;
import br.com.fiap3espa.auto_escola_3espa.application.core.validation.interfaces.ValidacoesDeAgendamento;
import br.com.fiap3espa.auto_escola_3espa.application.core.domain.model.Instrutor;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.response.instrucao.DadosDetalhamentoInstrucao;
import br.com.fiap3espa.auto_escola_3espa.adapter.out.repository.persistence.InstrucaoRepository;
import br.com.fiap3espa.auto_escola_3espa.exception.type.instrucao.ValidacaoException;
import br.com.fiap3espa.auto_escola_3espa.exception.type.instrutor.InstrutorNotFoundException;
import br.com.fiap3espa.auto_escola_3espa.adapter.out.repository.persistence.InstrutorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendaDeInstrucoes {

    @Autowired
    private InstrucaoRepository instrucaoRepository;

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Autowired
    private List<ValidacoesDeAgendamento> validadoresAgendamento;

    @Transactional
    public DadosDetalhamentoInstrucao agendar(@Valid DadosAgendamentoInstrucao dados) {
        //Validações
        if(!alunoRepository.existsById(dados.idAluno())) {
            throw new AlunoNotFoundException("ID do aluno informado não existe!");
        }
        if(dados.idInstrutor() != null && !instrutorRepository.existsById(dados.idInstrutor())) {
            throw new InstrutorNotFoundException("ID do instrutor informado não existe!");
        }

        //Regras de negócio
        validadoresAgendamento.forEach(v -> v.validar(dados));

        Aluno aluno = alunoRepository.getReferenceById(dados.idAluno());
        Instrutor instrutor = escolherInstrutor(dados);
        if(instrutor == null) {
            throw new ValidacaoException("Não existe instrutor disponível na data / hora informada!");
        }

        Instrucao instrucao = new Instrucao(null, aluno, instrutor, dados.data());
        instrucaoRepository.save(instrucao);
        return new DadosDetalhamentoInstrucao(instrucao);
    }

    private Instrutor escolherInstrutor(DadosAgendamentoInstrucao dados) {
        if(dados.idInstrutor() != null) {
            return instrutorRepository.getReferenceById(dados.idInstrutor());
        }
        if(dados.especialidade() == null) {
            throw new ValidacaoException("Especialidade é obrigatória, quando o instrutor não for informado!");
        }
        return instrutorRepository.escolherInstrutorAleatorioDisponivel(dados.especialidade(), dados.data());
    }
}
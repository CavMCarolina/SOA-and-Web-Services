package br.com.fiap3espa.auto_escola_3espa.adapter.out.repository.persistence;

import br.com.fiap3espa.auto_escola_3espa.application.core.domain.model.Instrucao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface InstrucaoRepository extends JpaRepository<Instrucao, Long> {

    // CP5: limite de 2 instruções por aluno no mesmo dia
    @Query("""
            select count(i) from Instrucao i
            where
            i.cancelada = false
            and
            i.aluno.id = :idAluno
            and
            cast(i.data as date) = cast(:data as date)
            """)
    Integer countInstrucoesAtivasPorAlunoNoDia(Long idAluno, LocalDateTime data);

    // CP5: conflito de horário do instrutor
    @Query("""
            select count(i) > 0 from Instrucao i
            where
            i.cancelada = false
            and
            i.instrutor.id = :idInstrutor
            and
            i.data = :data
            """)
    Boolean existeConflitoPorInstrutorNaData(Long idInstrutor, LocalDateTime data);
}

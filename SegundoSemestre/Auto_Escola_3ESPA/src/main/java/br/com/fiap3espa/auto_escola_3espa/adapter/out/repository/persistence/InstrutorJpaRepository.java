package br.com.fiap3espa.auto_escola_3espa.adapter.out.repository.persistence;

import br.com.fiap3espa.auto_escola_3espa.adapter.out.repository.entity.InstrutorEntity;
import br.com.fiap3espa.auto_escola_3espa.application.core.domain.enums.Especialidade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface InstrutorJpaRepository extends JpaRepository<InstrutorEntity, Long> {
    Page<InstrutorEntity> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select i from Instrutor i
            where
            i.ativo = true
            and
            i.especialidade = :especialidade
            and
            i.id not in(
                select a.instrutor.id from Instrucao a
                where
                a.data = :data
                )
            order by rand()
            limit 1
            """)
    InstrutorEntity escolherInstrutorAleatorioDisponivel(Especialidade especialidade, LocalDateTime data);
}
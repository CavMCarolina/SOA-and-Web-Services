package br.com.fiap3espa.auto_escola_3espa.adapter.out.repository.persistence;

import br.com.fiap3espa.auto_escola_3espa.application.core.domain.model.Aluno;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    Page<Aluno> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
            select e.ativo
            from Aluno e
            where
            e.id = :id
            """)
    Boolean findAtivoById(Long id);
}
package br.com.fiap3espa.auto_escola_3espa.adapter.out.repository.persistence;

import br.com.fiap3espa.auto_escola_3espa.application.core.domain.model.Instrucao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrucaoRepository extends JpaRepository<Instrucao, Long> {
}
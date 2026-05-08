package br.com.fiap3espa.auto_escola_3espa.application.port.out;

import br.com.fiap3espa.auto_escola_3espa.application.core.domain.enums.Especialidade;
import br.com.fiap3espa.auto_escola_3espa.application.core.domain.model.Instrutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;

public interface InstrutorRepository {
    Page<Instrutor> findAllByAtivoTrue(Pageable paginacao);

    Instrutor escolherInstrutorAleatorioDisponivel(Especialidade especialidade, LocalDateTime data);
}
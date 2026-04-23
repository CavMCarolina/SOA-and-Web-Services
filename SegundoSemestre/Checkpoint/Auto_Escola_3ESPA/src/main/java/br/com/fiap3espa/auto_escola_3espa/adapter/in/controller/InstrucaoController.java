package br.com.fiap3espa.auto_escola_3espa.adapter.in.controller;

import br.com.fiap3espa.auto_escola_3espa.application.core.usecase.AgendaDeInstrucoes;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.instrucao.DadosAgendamentoInstrucao;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.instrucao.DadosCancelamentoInstrucao;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.response.instrucao.DadosDetalhamentoInstrucao;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/instrucoes")
public class InstrucaoController {

    @Autowired
    private AgendaDeInstrucoes agenda;

    @PostMapping
    public ResponseEntity<DadosDetalhamentoInstrucao> agendarInstrucoes(
            @RequestBody @Valid DadosAgendamentoInstrucao dados) {
        DadosDetalhamentoInstrucao dto = agenda.agendar(dados);
        return ResponseEntity.ok(dto);
    }

    // CP5: cancelamento
    @DeleteMapping
    public ResponseEntity<Void> cancelarInstrucao(
            @RequestBody @Valid DadosCancelamentoInstrucao dados) {
        agenda.cancelar(dados);
        return ResponseEntity.noContent().build();
    }
}

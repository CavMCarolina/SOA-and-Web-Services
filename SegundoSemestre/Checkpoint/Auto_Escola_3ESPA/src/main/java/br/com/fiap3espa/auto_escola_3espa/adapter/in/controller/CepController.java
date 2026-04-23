package br.com.fiap3espa.auto_escola_3espa.adapter.in.controller;

import br.com.fiap3espa.auto_escola_3espa.infra.viacep.DadosViaCep;
import br.com.fiap3espa.auto_escola_3espa.infra.viacep.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Consome a API pública ViaCEP (https://viacep.com.br).
 * GET /cep/{cep} → retorna logradouro, bairro, cidade, UF etc.
 */
@RestController
@RequestMapping("/cep")
public class CepController {

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping("/{cep}")
    public ResponseEntity<DadosViaCep> buscarEndereco(@PathVariable String cep) {
        return ResponseEntity.ok(viaCepService.buscarEnderecoPorCep(cep));
    }
}

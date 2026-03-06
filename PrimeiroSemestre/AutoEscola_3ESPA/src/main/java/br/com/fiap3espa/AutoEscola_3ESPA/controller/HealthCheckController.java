package br.com.fiap3espa.AutoEscola_3ESPA.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Identificação Spring Boot
@RestController

// Mapeamento de requisição. Endereço para requisição
@RequestMapping("/health-check")
public class HealthCheckController {
    // Pegar o metodo de requisição
    @GetMapping
    public String healthCheck() {
        return "Verificação de integridade Auto Escola 3ESPA!";
    }
}

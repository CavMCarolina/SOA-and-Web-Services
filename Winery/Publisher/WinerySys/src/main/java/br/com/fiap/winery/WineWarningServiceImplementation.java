package br.com.fiap.winery;

import jakarta.jws.WebService;

// Serviço conectado com a interface
@WebService(endpointInterface = "br.com.fiap.winery.WineWarningService")

public class WineWarningServiceImplementation implements WineWarningService {
    // Mensagem de aviso
    @Override
    public String sendWarn() {
        return "\n~~~ Estoque Insuficiente! ~~~";
    }
}
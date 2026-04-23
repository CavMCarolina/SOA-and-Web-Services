package br.com.fiap3espa.auto_escola_3espa.infra.viacep;

import br.com.fiap3espa.auto_escola_3espa.exception.type.instrucao.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@Service
public class ViaCepService {

    @Autowired
    private WebClient viaCepWebClient;

    public DadosViaCep buscarEnderecoPorCep(String cep) {
        String cepLimpo = cep.replaceAll("\\D", "");

        if (cepLimpo.length() != 8) {
            throw new ValidacaoException("CEP inválido: deve conter 8 dígitos.");
        }

        try {
            DadosViaCep dados = viaCepWebClient
                    .get()
                    .uri("/{cep}/json", cepLimpo)
                    .retrieve()
                    .bodyToMono(DadosViaCep.class)
                    .block();

            if (dados == null || dados.invalido()) {
                throw new ValidacaoException("CEP não encontrado: " + cep);
            }

            return dados;

        } catch (WebClientResponseException e) {
            throw new ValidacaoException("Erro ao consultar ViaCEP: " + e.getMessage());
        }
    }
}

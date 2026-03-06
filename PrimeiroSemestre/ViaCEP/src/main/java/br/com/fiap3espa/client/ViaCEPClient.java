package br.com.fiap3espa.client;

import br.com.fiap3espa.exception.CEPInvalido;
import br.com.fiap3espa.model.EnderecoDTO;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.client.fluent.Request;

import java.io.IOException;

public class ViaCEPClient {
    public static EnderecoDTO getEndereco(String cep) throws IOException {
        // url
        String url = "https://viacep.com.br/ws/" + cep + "/json/";

        // Requisição da url -- Timeout -- Executar o conteúdo -- Transformar tudo em String
        String jsonResponse = Request.Get(url)
                .connectTimeout(10000)
                .socketTimeout(10000)
                .execute()
                .returnContent()
                .asString();

        JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
        if(jsonObject.has("erro") && jsonObject.get("erro").getAsBoolean()) {
            throw new CEPInvalido("CEP inválido!");
        }

        // Instanciar o Gson
        Gson gson = new Gson();

        // Traz o conteúdo do json e converte para o EnderecoDTO
        return gson.fromJson(jsonResponse, EnderecoDTO.class);
    }
}

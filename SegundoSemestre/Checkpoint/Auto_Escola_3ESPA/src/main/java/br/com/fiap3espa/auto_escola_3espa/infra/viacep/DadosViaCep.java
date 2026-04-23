package br.com.fiap3espa.auto_escola_3espa.infra.viacep;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DadosViaCep(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        String localidade,
        String uf,
        @JsonAlias("ibge")  String codigoIbge,
        @JsonAlias("ddd")   String ddd,
        @JsonAlias("erro")  Boolean erro) {

    public boolean invalido() {
        return Boolean.TRUE.equals(erro);
    }
}

package br.com.fiap3espa.auto_escola_3espa.application.core.domain.vo;

import jakarta.persistence.Embeddable;

// Entidade do bando de dados não precisa tirar, pois está dentro do nosso código
@Embeddable
public class Endereco {
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;

    public Endereco() {
    }

    public Endereco(
            String logradouro,
            String numero,
            String complemento,
            String bairro,
            String cidade,
            String uf,
            String cep
    ) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.cep = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getUf() {
        return uf;
    }

    public String getCep() {
        return cep;
    }

    public void atualizarInformacoes(
            String logradouro,
            String numero,
            String complemento,
            String bairro,
            String cidade,
            String uf,
            String cep
    ) {
        if(logradouro != null) {
            this.logradouro = logradouro;
        }
        if(numero != null) {
            this.numero = numero;
        }
        if(complemento != null) {
            this.complemento = complemento;
        }
        if(bairro != null) {
            this.bairro = bairro;
        }
        if(cidade != null) {
            this.cidade = cidade;
        }
        if(uf != null) {
            this.uf = uf;
        }
        if(cep != null) {
            this.cep = cep;
        }
    }
}
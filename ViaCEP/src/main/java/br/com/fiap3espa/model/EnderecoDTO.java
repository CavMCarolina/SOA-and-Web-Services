package br.com.fiap3espa.model;

// Classe imutável --> Sem alterações no conteúdo json
public record EnderecoDTO(
        String cep,
        String logradouro,
        String complemento,
        String unidade,
        String bairro,
        String localidade,
        String uf,
        String estado,
        String regiao,
        String ibge,
        String gia,
        String ddd,
        String siafi
) {}
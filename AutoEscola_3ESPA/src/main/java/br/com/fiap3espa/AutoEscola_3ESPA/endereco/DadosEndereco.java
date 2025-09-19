package br.com.fiap3espa.AutoEscola_3ESPA.endereco;

public record DadosEndereco(
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String uf,
        String cep) {
}

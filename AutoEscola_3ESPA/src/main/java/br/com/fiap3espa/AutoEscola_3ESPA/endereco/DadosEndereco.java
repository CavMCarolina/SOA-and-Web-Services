package br.com.fiap3espa.AutoEscola_3ESPA.endereco;

// Value Object --> VO. Transporta informações para outra entidade
public record DadosEndereco(
        String logradouro,
        String numero,
        String complemento,
        String bairro,
        String cidade,
        String uf,
        String cep) {
}

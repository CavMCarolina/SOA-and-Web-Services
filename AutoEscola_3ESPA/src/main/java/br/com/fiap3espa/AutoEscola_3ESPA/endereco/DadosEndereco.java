package br.com.fiap3espa.AutoEscola_3ESPA.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

// Value Object --> VO. Transporta informações para outra entidade
public record DadosEndereco(
        @NotBlank
        String logradouro,
        String numero,
        String complemento,

        @NotBlank
        String bairro,

        @NotBlank
        String cidade,

        @NotBlank
        @Pattern(regexp = "[A-Z]{2}")
        String uf,

        @NotBlank
        @Pattern(regexp = "[0-9]{8}")
        String cep) {
}

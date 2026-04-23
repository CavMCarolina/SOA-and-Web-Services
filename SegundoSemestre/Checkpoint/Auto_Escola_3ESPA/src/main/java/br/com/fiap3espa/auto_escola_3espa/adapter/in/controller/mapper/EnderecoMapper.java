package br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.mapper;

import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.endereco.DadosEndereco;
import br.com.fiap3espa.auto_escola_3espa.application.core.domain.vo.Endereco;
import org.springframework.stereotype.Component;

@Component
public class EnderecoMapper {
    public Endereco toDomain(DadosEndereco dados) {
        return new Endereco(
                dados.logradouro(),
                dados.numero(),
                dados.complemento(),
                dados.bairro(),
                dados.cidade(),
                dados.uf(),
                dados.cep()
        );
    }

    public DadosEndereco toDTO(Endereco endereco) {
        return new DadosEndereco(
                endereco.getLogradouro(),
                endereco.getNumero(),
                endereco.getComplemento(),
                endereco.getBairro(),
                endereco.getCidade(),
                endereco.getUf(),
                endereco.getCep()
        );
    }
}
package br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.mapper;

import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.request.instrutor.DadosCadastroInstrutor;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.response.instrutor.DadosDetalhamentoInstrutor;
import br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.response.instrutor.DadosListagemInstrutor;
import br.com.fiap3espa.auto_escola_3espa.application.core.domain.model.Instrutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InstrutorMapper {
    @Autowired
    private EnderecoMapper enderecoMapper;

    public Instrutor toDomain(DadosCadastroInstrutor dados) {
        return new Instrutor(
                null,
                true,
                dados.nome(),
                dados.email(),
                dados.telefone(),
                dados.cnh(),
                dados.especialidade(),
                enderecoMapper.toDomain(dados.endereco())
        );
    }

    public DadosListagemInstrutor toListDTO(Instrutor instrutor) {
        return new DadosListagemInstrutor(
                instrutor.getId(),
                instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getCnh(),
                instrutor.getEspecialidade()
        );
    }

    public DadosDetalhamentoInstrutor toDetailsDTO(Instrutor instrutor) {
        return new DadosDetalhamentoInstrutor(
                instrutor.getId(),
                instrutor.getAtivo(),
                instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getTelefone(),
                instrutor.getCnh(),
                instrutor.getEspecialidade(),
                enderecoMapper.toDTO(instrutor.getEndereco())
        );
    }
}
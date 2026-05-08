package br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.response.aluno;

import br.com.fiap3espa.auto_escola_3espa.application.core.domain.model.Aluno;
import br.com.fiap3espa.auto_escola_3espa.application.core.domain.vo.Endereco;

public record DadosDetalhamentoAluno(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        Endereco endereco) {
    public DadosDetalhamentoAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getTelefone(), aluno.getCpf(), aluno.getEndereco());
    }
}

package br.com.fiap3espa.auto_escola_3espa.adapter.in.controller.response.aluno;

import br.com.fiap3espa.auto_escola_3espa.application.core.domain.model.Aluno;

public record DadosListagemAluno(
        Long id,
        String nome,
        String email,
        String cpf) {
    public DadosListagemAluno(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getCpf());
    }
}
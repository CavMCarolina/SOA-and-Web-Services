package br.com.fiap3espa.auto_escola_3espa.application.core.domain.model;

import br.com.fiap3espa.auto_escola_3espa.application.core.domain.vo.Endereco;
import br.com.fiap3espa.auto_escola_3espa.application.core.domain.enums.Especialidade;
import jakarta.persistence.*;

@Entity(name = "Instrutor")
@Table(name = "instrutores")
public class Instrutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean ativo;
    private String nome;
    private String email;
    private String telefone;
    private String cnh;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Instrutor() {}

    public Instrutor(Long id, Boolean ativo, String nome, String email, String telefone,
                     String cnh, Especialidade especialidade, Endereco endereco) {
        this.id = id; this.ativo = ativo; this.nome = nome; this.email = email;
        this.telefone = telefone; this.cnh = cnh;
        this.especialidade = especialidade; this.endereco = endereco;
    }

    public Long getId()                     { return id; }
    public Boolean getAtivo()               { return ativo; }
    public String getNome()                 { return nome; }
    public String getEmail()                { return email; }
    public String getTelefone()             { return telefone; }
    public String getCnh()                  { return cnh; }
    public Especialidade getEspecialidade() { return especialidade; }
    public Endereco getEndereco()           { return endereco; }

    public void atualizarInformacoes(String nome, String telefone, Endereco endereco) {
        if (nome != null)     this.nome = nome;
        if (telefone != null) this.telefone = telefone;
        if (endereco != null) this.endereco.atualizarInformacoes(endereco);
    }

    public void excluir() { this.ativo = false; }
}
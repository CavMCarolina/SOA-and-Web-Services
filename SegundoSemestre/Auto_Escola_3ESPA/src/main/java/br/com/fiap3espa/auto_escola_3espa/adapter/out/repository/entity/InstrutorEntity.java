package br.com.fiap3espa.auto_escola_3espa.adapter.out.repository.entity;

import br.com.fiap3espa.auto_escola_3espa.application.core.domain.enums.Especialidade;
import br.com.fiap3espa.auto_escola_3espa.application.core.domain.vo.Endereco;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "instrutores")
@Entity(name = "Instrutor")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class InstrutorEntity {
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
}
package br.com.fiap.checkpoint2.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Table(name = "pedidos")
@Entity(name = "Pedido")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {
    // chave primária gerada automaticament
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @NotBlank
    @NotNull
    String clienteNome;

    // preenchido automaticamente com a data atual
    LocalDate dataPedido;

    // não pode ser negativo
    double valor;
}

//
//    private String nome;
//    private String email;
//    private String cnh;
//
//    @Enumerated(EnumType.STRING)
//    private Especialidade especialidade;
//
//    @Embedded // busca informação na outra classe
//    private Endereco endereco;
//
//    public Instrutor(DadosCadastroInstrutor dados) {
//        this.nome = dados.nome();
//        this.email = dados.email();
//        this.cnh = dados.cnh();
//        this.especialidade = dados.especialidade();
//        this.endereco = new Endereco(dados.endereco());
//    }
//}

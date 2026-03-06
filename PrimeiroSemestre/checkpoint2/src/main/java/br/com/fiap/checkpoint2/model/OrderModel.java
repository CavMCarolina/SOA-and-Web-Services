package br.com.fiap.checkpoint2.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "Pedidos")
@Entity(name = "Order")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderModel {
    // chave primária gerada automaticamente
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty(message = "O preenchimento do nome é obrigatório!")
    private String clientName;

    // preenchido automaticamente com a data atual
    private LocalDate orderDate;

   @DecimalMin(value = "0.0", message = "O valor não pode ser negativo!")
   @Positive
   private BigDecimal totalValue;

   @PrePersist
   public void prePresist() {
       // caso a data do pedido seja nula, adicionar a data atual automaticamente
       if (orderDate == null) {
           orderDate = LocalDate.now();
       }
   }
}
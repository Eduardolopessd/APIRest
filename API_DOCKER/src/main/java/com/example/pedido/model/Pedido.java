package com.example.pedido.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Pedido {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false, unique = true)
    private String numeroPedido;

    private String nf;
    private String lista;
    private String etiqueta;

    private Integer quantidadePedidos;
    private Integer quantidadeFaturados;

    private Integer saldo;

    private LocalDateTime horarioColeta;

    private String etiquetasEnviadas;
    private String descricaoErro;

    @PrePersist @PreUpdate
    private void calcularSaldo() {
        if (quantidadePedidos != null && quantidadeFaturados != null) {
            this.saldo = quantidadePedidos - quantidadeFaturados;
        }
    }
}
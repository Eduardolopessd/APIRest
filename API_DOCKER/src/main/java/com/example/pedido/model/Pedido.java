package com.example.pedido.model;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
public class Pedido {

    @Id
    @GeneratedValue
    private UUID id;

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

    @SuppressWarnings("unused")
    @PrePersist @PreUpdate
    private void calcularSaldo() {
        if (quantidadePedidos != null && quantidadeFaturados != null) {
            this.saldo = quantidadePedidos - quantidadeFaturados;
        }
    }

    public UUID getId() {
        return id;
    }
}
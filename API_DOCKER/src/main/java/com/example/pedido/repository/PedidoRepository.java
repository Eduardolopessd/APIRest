package com.example.pedido.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.pedido.model.Pedido;
import java.util.UUID;

public interface PedidoRepository extends JpaRepository<Pedido, UUID> {
    boolean existsByNumeroPedido(String numeroPedido);
}
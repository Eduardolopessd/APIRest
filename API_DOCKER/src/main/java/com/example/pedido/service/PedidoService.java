package com.example.pedido.service;

import com.example.pedido.model.Pedido;
import com.example.pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PedidoService {

    private final PedidoRepository repo;

    public PedidoService(PedidoRepository repo) {
        this.repo = repo;
    }

    public Pedido salvar(Pedido pedido) {
        if (repo.existsByNumeroPedido(pedido.getNumeroPedido())) {
            throw new IllegalArgumentException("Pedido já cadastrado");
        }
        return repo.save(pedido);
    }

    public List<Pedido> listar() {
        return repo.findAll();
    }

    public Pedido obter(UUID id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
}
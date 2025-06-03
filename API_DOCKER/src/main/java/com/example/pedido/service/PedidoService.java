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
    // Validar campos obrigatórios
    if (pedido.getNumeroPedido() == null || pedido.getNumeroPedido().isBlank()) {
        throw new IllegalArgumentException("Número do pedido é obrigatório");
    }
    if (repo.existsByNumeroPedido(pedido.getNumeroPedido())) {
        throw new IllegalArgumentException("Pedido já cadastrado");
    }
    
    // Garantir valores padrão para campos numéricos
    if (pedido.getQuantidadePedidos() == null) pedido.setQuantidadePedidos(0);
    if (pedido.getQuantidadeFaturados() == null) pedido.setQuantidadeFaturados(0);
    
    return repo.save(pedido);
}

    public List<Pedido> listar() {
        return repo.findAll();
    }

    public Pedido obter(UUID id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
}


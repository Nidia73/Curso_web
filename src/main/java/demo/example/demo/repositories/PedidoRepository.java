package demo.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.example.demo.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
    
}

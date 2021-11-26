package demo.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.example.demo.models.DetallePedido;

public interface DetallePedidoRepository  extends JpaRepository<DetallePedido, Long>{ 
    
}

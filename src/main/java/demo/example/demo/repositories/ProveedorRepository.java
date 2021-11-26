package demo.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.example.demo.models.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{
    
}

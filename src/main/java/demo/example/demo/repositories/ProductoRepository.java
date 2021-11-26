package demo.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import demo.example.demo.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
        List<Producto> findByDescripcionContains(String descripcion);
}
         


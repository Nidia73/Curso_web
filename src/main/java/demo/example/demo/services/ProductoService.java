package demo.example.demo.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.example.demo.models.Producto;
import demo.example.demo.repositories.ProductoRepository;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    public Producto guardar(Producto producto){
        return productoRepository.save(producto);
       }

    public Producto actualizar(Producto producto , Producto producto_actualiza){
           producto.setDescripcion(producto_actualiza.getDescripcion());
           producto.setPrecio(producto_actualiza.getPrecio());
           producto.setProveedor(producto_actualiza.getProveedor());
           return productoRepository.save(producto);
   
    }
   
    public void eliminar(Producto producto){
           productoRepository.delete(producto);
    }
   
    public Optional<Producto> getById(long idProducto){
           return productoRepository.findById(idProducto);
          
   }
} 

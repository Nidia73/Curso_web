package demo.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.example.demo.models.Producto;
import demo.example.demo.services.ProductoService;

@RestController
@RequestMapping("/api")

public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
               
    @PostMapping("/v1/productos")

    public ResponseEntity<?> post(@ RequestBody Producto producto){
           Producto productoAlmacenado = productoService.guardar(producto);
           return ResponseEntity.ok(productoAlmacenado);
       }
       @DeleteMapping("/v1/productos/{idProducto}")
       public ResponseEntity<?> delete(@PathVariable long idProducto){
        Optional<Producto> productoOptional = productoService.getById(idProducto) ;
        if (productoOptional.isPresent())
        {
          productoService.eliminar(productoOptional.get());
          return ResponseEntity.ok("Producto borrado");
        }
        else{
            return ResponseEntity.badRequest().body("no existe producto");
        }
        
    
    }
    
}
    

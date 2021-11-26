package demo.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import demo.example.demo.models.Proveedor;
import demo.example.demo.services.ProveedorService;

@RestController

public class ProveedorController {
   @Autowired
   private ProveedorService proveedorService;
   @PostMapping("/v1/proveedores")

   public ResponseEntity<?> post(@RequestBody Proveedor proveedor){
    Proveedor proveedorAlmacenado = proveedorService.guardar(proveedor);
       return ResponseEntity.ok(proveedorAlmacenado);
   }
   @DeleteMapping("/v1/proveedores/{idProveedor}")
   public ResponseEntity<?> delete(@PathVariable long idProveedor){
   
    Optional<Proveedor> proveedorOptional = proveedorService.getById(idProveedor) ;
    if (proveedorOptional.isPresent()){
        proveedorService.eliminar(proveedorOptional.get());
        return ResponseEntity.ok("proveedor borrado");
    }
    else{
        return ResponseEntity.badRequest().body("no existe proveedor");
    }
    

}

}


package demo.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.example.demo.models.Proveedor;
import demo.example.demo.repositories.ProveedorRepository;

@Service

public class ProveedorService {
    @Autowired
    private ProveedorRepository proveedorRepository;
    
    public Proveedor guardar(Proveedor proveedor) { 
        return proveedorRepository.save(proveedor);
    }
    
    public Proveedor actualizar(Proveedor proveedor, Proveedor proveedorNuevo) { 
        proveedor.setNombre(proveedorNuevo.getNombre());
        proveedor.setRuc(proveedorNuevo.getRuc());
        proveedor.setTelefono(proveedorNuevo.getTelefono());
        return proveedorRepository.save(proveedor);
    }
    public void eliminar(Proveedor proveedor){
        proveedorRepository.delete(proveedor);
    }
    
    public Optional<Proveedor> getById(long idProveedor){
        return proveedorRepository.findById(idProveedor);
       }
}

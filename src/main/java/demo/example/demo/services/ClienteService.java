package demo.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.example.demo.models.Cliente;
import demo.example.demo.repositories.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente guardar(Cliente cliente){
       return clienteRepository.save(cliente) ;
    }

    public Cliente actualizar(Cliente cliente, Cliente clienteActualizado){
        cliente.setNombre(clienteActualizado.getNombre());
        cliente.setTelefono(clienteActualizado.getTelefono());
        cliente.setCedula(clienteActualizado.getCedula());
        cliente.setDireccion(clienteActualizado.getDireccion());
        return clienteRepository.save(cliente);
    }

    public void eliminar(Cliente cliente){
        clienteRepository.delete(cliente);        
    }

    public Optional<Cliente> getById(long idCliente){
        return clienteRepository.findById(idCliente);
    }

    public List<Cliente> getAll(){
        return clienteRepository.findAll();
    }
}



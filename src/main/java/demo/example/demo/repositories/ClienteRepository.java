package demo.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import demo.example.demo.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente,Long>{
    Cliente findByCedula(String cedula) ;
    List<Cliente> findByNombre(String nombre);
  
 }
 
 



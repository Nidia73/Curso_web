package demo.example.demo.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import demo.example.demo.models.Cliente;

public class ClienteMapper implements RowMapper<Cliente> {
  @Override
  public Cliente mapRow(ResultSet arg0, int arg1) throws SQLException {
      Cliente cliente = new Cliente();
      cliente.setId(arg0.getLong("id"));
      cliente.setNombre(arg0.getString("nombre"));
      return cliente;
  }
 
  
}




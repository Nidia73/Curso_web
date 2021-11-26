package demo.example.demo.services;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.example.demo.dtos.DetallePedidoDto;
import demo.example.demo.dtos.PedidoDto;
import demo.example.demo.models.Cliente;
import demo.example.demo.models.DetallePedido;
import demo.example.demo.models.Pedido;
import demo.example.demo.models.Producto;
import demo.example.demo.repositories.DetallePedidoRepository;
import demo.example.demo.repositories.PedidoRepository;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private DetallePedidoRepository detallePedidoRepository;

    @Transactional
    public Pedido guardar(Pedido pedido, List<DetallePedido> detalles) {
         Pedido pedidoAlmacenado = pedidoRepository.save(pedido); 
         
         for(DetallePedido tmp : detalles){
             tmp.setPedido(pedidoAlmacenado);
             detallePedidoRepository.save(tmp);
         }  
         return pedidoAlmacenado;
    }
    
    @Transactional
    public Pedido guardarDto(PedidoDto pedidoDto){

        Pedido pedido = new Pedido();
        pedido.setFechaPedido(new Date());
        pedido.setSubtotal(pedidoDto.getSubtotal());
        Cliente cliente = new Cliente();
        cliente.setId(pedidoDto.getCliente());
        pedido.setCliente(cliente);
 
        List<DetallePedido> detallesEntidades = new ArrayList<>();
        for(DetallePedidoDto tmp: pedidoDto.getDetalles()){
            DetallePedido  detallePedido= new DetallePedido();
            detallePedido.setPrecio(tmp.getPrecio());
            detallePedido.setCantidad(tmp.getCantidad());
            Producto producto = new Producto();
            producto.setId(tmp.getProducto());
            detallePedido.setProducto(producto);
            detallesEntidades.add(detallePedido);
        }
         return guardar(pedido, detallesEntidades);
    }   
}

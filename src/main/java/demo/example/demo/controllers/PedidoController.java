package demo.example.demo.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.example.demo.dtos.DetallePedidoDto;
import demo.example.demo.dtos.PedidoDto;
import demo.example.demo.models.Cliente;
import demo.example.demo.models.DetallePedido;
import demo.example.demo.models.Pedido;
import demo.example.demo.models.Producto;
import demo.example.demo.services.PedidoService;

@RestController
@RequestMapping("/api")
public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/v1/pedidos")
    public ResponseEntity<?> post(@RequestBody PedidoDto pedidoDto){
        Pedido pedido = new Pedido();
        pedido.setFechaPedido( new Date());
        pedido.setSubtotal(pedidoDto.getSubtotal());
        Cliente cliente = new Cliente();
        cliente.setId(pedidoDto.getCliente());
        pedido.setCliente(cliente);

        List<DetallePedido> detallesEntidades = new ArrayList<>();
        for(DetallePedidoDto tmp : pedidoDto.getDetalles()){
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setPrecio(tmp.getPrecio());
            detallePedido.setCantidad(tmp.getCantidad());
            Producto producto = new Producto();
            producto.setId(tmp.getProducto());
            detallePedido.setProducto(producto);
            detallesEntidades.add(detallePedido);
        }
        Pedido pedidoAlmacenado = pedidoService.guardar(pedido, detallesEntidades);
        return ResponseEntity.ok(pedidoAlmacenado);

    }

}


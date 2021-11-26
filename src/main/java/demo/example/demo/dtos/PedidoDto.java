package demo.example.demo.dtos;

import java.util.List;

import lombok.Data;

@Data

public class PedidoDto {
    private List<DetallePedidoDto> detalles;

    public double getSubtotal(){
        double subtotal = 0;
        for(DetallePedidoDto tmp : detalles){
            subtotal = subtotal +(tmp.getPrecio()*tmp.getCantidad());
        }
        return subtotal;
    }

	public long getCliente() {
		return 0;
	}

}

    
   
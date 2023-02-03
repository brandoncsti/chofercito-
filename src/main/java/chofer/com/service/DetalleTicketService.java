package chofer.com.service;

import chofer.com.model.DetalleTicket;
import chofer.com.model.TicketPesaje;

import java.util.List;

public interface DetalleTicketService {

   public List<DetalleTicket> getDetalleTicket();

   //DetalleTicket getDetalleTicketByCodBalanza(String cod_balanza);
   DetalleTicket save(DetalleTicket detalleTicket);
}

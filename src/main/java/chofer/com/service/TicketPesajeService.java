package chofer.com.service;




import chofer.com.model.DetalleTicket;
import chofer.com.model.TicketPesaje;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TicketPesajeService {

    List<TicketPesaje> getAllTicketPesaje();
   TicketPesaje getTicketPesajeById(Integer idTicketPesaje);


    TicketPesaje save(TicketPesaje ticketPesaje);

    /*ResponseEntity <Map> update (TicketPesaje ticketPesaje);*/
   List<TicketPesaje>getTicketPesajeListPorFechas(Date fechaInicio, Date fechaFin);

  // ResponseEntity<Map>save(TicketPesaje ticketPesaje);

}

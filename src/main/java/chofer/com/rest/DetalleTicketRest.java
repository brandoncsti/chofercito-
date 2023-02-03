package chofer.com.rest;


import chofer.com.model.DetalleTicket;
import chofer.com.model.TicketPesaje;
import chofer.com.service.DetalleTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/DetalleTicket")
public class DetalleTicketRest {

    @Autowired
    private DetalleTicketService detalleTicketService;

    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<DetalleTicket>> getallDetalleTickets() {
        return Optional.ofNullable(detalleTicketService.getDetalleTicket())
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
/*
    @RequestMapping(value = "/listar/{cod_balanza}", method = RequestMethod.GET, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DetalleTicket> getallDetalleTickets(@PathVariable("cod_balanza") String cod_balanza) {
        DetalleTicket detalleTicket = this.detalleTicketService.getDetalleTicketByCodBalanza(cod_balanza);
        //validamos si existe
        if(detalleTicket == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"No se encontro detalleticket con ese id");
        }
        return new ResponseEntity<>(detalleTicket, HttpStatus.OK);
    }
*/

    @RequestMapping(value = "Save-Update", method = RequestMethod.POST, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public DetalleTicket save(@RequestBody DetalleTicket detalleTicket) {
        return detalleTicketService.save(detalleTicket);
    }

}

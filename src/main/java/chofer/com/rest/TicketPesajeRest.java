package chofer.com.rest;



import chofer.com.model.Chofer;
import chofer.com.model.TicketPesaje;
import chofer.com.service.TicketPesajeService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.Date;
import java.util.List;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/ticketPesaje")
public class TicketPesajeRest {



    @Autowired
    private TicketPesajeService ticketPesajeService;

  /*  @Autowired
    private DetalleTicketRepository detalleTicketRepository;

    @Autowired
    private TicketPesajeRepository ticketPesajeRepository;*/
    @RequestMapping(value = "/id/{idTicketPesaje}",
                    method = RequestMethod.GET, produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getTicketPesajeById(@PathVariable("idTicketPesaje") Integer idTicketPesaje) {
        TicketPesaje ticketPesaje = this.ticketPesajeService.getTicketPesajeById(idTicketPesaje);
        if (ticketPesaje == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro TicketPesaje con ese id");
        }
        return new ResponseEntity<>(ticketPesaje, HttpStatus.OK);
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<TicketPesaje>> gelAllTicketPesaje() {
        return Optional.ofNullable(ticketPesajeService.getAllTicketPesaje())
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    /*@RequestMapping(value = "SaveorUpdate", method = RequestMethod.POST, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public TicketPesaje save(@RequestBody TicketPesaje ticketPesaje) {

      return this.ticketPesajeService.save(ticketPesaje);

    }
     */

    /*@RequestMapping(value = "SaveorUpdate", method = RequestMethod.POST, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public TicketPesaje save(@RequestBody TicketPesaje ticketPesaje) {
    //TicketPesaje ticketPesajes = ticketPesajeService.save(ticketPesaje,detalleTicket);
        return ticketPesajeService.save(ticketPesaje);
    }
*/
    @RequestMapping(value = "SaveorUpdate", method = RequestMethod.POST, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public TicketPesaje save(@RequestBody TicketPesaje ticketPesaje) {
        return ticketPesajeService.save(ticketPesaje);
    }


    @GetMapping(value = "/getTicketPesajeList/{FechaInicio}/{FechaFin}")
    public ResponseEntity<List<TicketPesaje>> getTicketPesajeList(
            @PathVariable("FechaInicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaInicio,
            @PathVariable("FechaFin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fechaFin) {
        try {
            List<TicketPesaje> ticketPesajeList = ticketPesajeService.getTicketPesajeListPorFechas(fechaInicio, fechaFin);

            if (ticketPesajeList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(ticketPesajeList, HttpStatus.OK);
        } catch (Exception e) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    /*@RequestMapping(value = "/actualizar", method = RequestMethod.POST, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public TicketPesaje update(@RequestBody TicketPesaje ticketPesaje) {
        Optional<TicketPesaje> ticketPesajes =  ticketPesajeRepository.findById(ticketPesaje.getId());
        if(ticketPesajes.isPresent()) {
            List<DetalleTicket> detallesactual = ticketPesaje.getDetalleTicketList();
            ticketPesaje.setDetalleTicketList(null);
            ticketPesajeService.update(ticketPesaje);
            for(DetalleTicket det:detallesactual){
                det.setId(ticketPesaje.getId());

                det.setTipo_peso(det.getTipo_peso());
                det.setProducto(det.getProducto());
                det.setPosicion(det.getPosicion());
                det.setPeso_neto(det.getPeso_neto());
                det.setPeso_bruto(det.getPeso_bruto());
                LocalDateTime fechaActual = LocalDateTime.now();
                det.setFechaModificacion(fechaActual);
                det.setEstado(det.getEstado());
            }

            detalleTicketRepository.saveAll(detallesactual);
            ticketPesaje.setDetalleTicketList(detallesactual);
            }
        return ticketPesaje;
    }*/

}

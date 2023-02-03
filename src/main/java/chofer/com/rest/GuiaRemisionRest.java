package chofer.com.rest;


import chofer.com.model.GuiaRemision;
import chofer.com.service.GuiaRemisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/api/guiaRemision")
public class GuiaRemisionRest {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private GuiaRemisionService guiaRemisionService;



    @RequestMapping(value = "/id/{idGuiaRemision}", method = RequestMethod.GET, produces = {
                                                        MediaType.APPLICATION_JSON_VALUE,
                                                        MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getGuiaRemisionById(@PathVariable("idGuiaRemision") Integer idGuiaRemision){
        GuiaRemision guiaRemision = this.guiaRemisionService.getGuiaRemisionById(idGuiaRemision);
        if (guiaRemision == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro TicketPesaje con ese id");
        }
        return new ResponseEntity<>(guiaRemision, HttpStatus.OK);
    }

    @RequestMapping(value = "Listar", method = RequestMethod.GET, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<GuiaRemision>> gelAllGuiaRemision() {
        return Optional.ofNullable(guiaRemisionService.getAllGuiaRemision())
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "guardar", method = RequestMethod.POST, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public GuiaRemision save(@RequestBody GuiaRemision guiaRemision) {
        return this.guiaRemisionService.save(guiaRemision);
    }


   /* @GetMapping(value = "/getBuscarProveedor/{idProveedor}/{ruc}/{razonSocial}")
    public ResponseEntity<Proveedor> getTicketPesajeList(
            @PathVariable("idProveedor")Integer idProveedor,
            @PathVariable("ruc") String ruc,
            @PathVariable("razonSocial") String razonSocial) {
        try {

            Proveedor proveedor = guiaRemisionService.getProveedorByProveedorandRucandSocial(idProveedor, ruc, razonSocial);

            if (proveedor!=null) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No se encontro Proveedores con su Ruc y Razon Social");
            }
            return new ResponseEntity<>(proveedor, HttpStatus.OK);
        } catch (Exception e) {
            String error = Utils.obtieneMensajeErrorException(e);
            throw new RuntimeException(error);
        }
    }*/
}

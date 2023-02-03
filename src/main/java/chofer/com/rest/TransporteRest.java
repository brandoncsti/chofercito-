package chofer.com.rest;


import chofer.com.model.Transporte;
import chofer.com.service.TransporteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/transporte")
public class TransporteRest {


    @Autowired
    private TransporteService transporteService;

    @RequestMapping(value = "/id/{idTransporte}",
            method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Optional<Transporte>> getTransporteById(@PathVariable("idTransporte") Integer idTransporte) {
        Optional<Transporte> transporte = this.transporteService.getTransporteById(idTransporte);
        return ResponseEntity.ok().body(transporte);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<java.util.List<Transporte>> gelAllTransporte() {
        return Optional.ofNullable(transporteService.getAllTransporte())
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Map> save(@RequestBody Transporte transporte) {
        return transporteService.save(transporte);
    }

}

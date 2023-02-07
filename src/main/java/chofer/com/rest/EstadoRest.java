package chofer.com.rest;

import chofer.com.model.DetalleTicket;
import chofer.com.model.DireccionAlternativa;
import chofer.com.model.Estado;
import chofer.com.service.EstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/estado")
public class EstadoRest {

    @Autowired
    private EstadoService estadoService;

    @RequestMapping(value = "save-update", method = RequestMethod.POST, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public Estado save(@RequestBody Estado estado) {

        return estadoService.save(estado);
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Estado>> getAllEstado() {
        return Optional.ofNullable(estadoService.getAllEstado())
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

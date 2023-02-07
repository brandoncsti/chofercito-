package chofer.com.rest;

import chofer.com.model.DireccionAlternativa;
import chofer.com.model.TicketPesaje;
import chofer.com.service.DireccionAlternativaService;
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
@RequestMapping(value = "/api/DireccionAlternativa")
public class DireccionAlternativaRest {

    @Autowired
    private DireccionAlternativaService direccionAlternativaService;

    @RequestMapping(value = "Save-update", method = RequestMethod.POST, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public DireccionAlternativa save(@RequestBody DireccionAlternativa direccionAlternativa) {
        return direccionAlternativaService.save(direccionAlternativa);
    }

    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<DireccionAlternativa>> getAllDireccionAlternativa() {
        return Optional.ofNullable(direccionAlternativaService.getAllDireccionAlternat())
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

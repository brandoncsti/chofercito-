package chofer.com.rest;



import chofer.com.model.Chofer;
import chofer.com.service.ChoferService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/chofer")
public class ChoferRest {



    @Autowired
    private ChoferService choferService;

    @RequestMapping(value = "/dni/{dni}",
            method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Chofer>getChoferByDni(@PathVariable("dni") String dni) {
        Chofer chofer = this.choferService.getChoferByDni(dni);
        return ResponseEntity.ok().body(chofer);
    }

    @RequestMapping(value = "/licencia/{licencia}",
            method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Chofer>getCarretaByCodigo(@PathVariable("licencia") String licencia) {
        Chofer chofer = this.choferService.getChoferByLicencia(licencia);
        return ResponseEntity.ok().body(chofer);
    }


    @RequestMapping(value = "/listar", method = RequestMethod.GET, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Chofer>> getAllChofer(){
        return Optional.ofNullable(choferService.getAllChofer())
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "/grabar", method = RequestMethod.POST, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Map> save(@RequestBody Chofer chofer) {
        return choferService.save(chofer);
    }
}

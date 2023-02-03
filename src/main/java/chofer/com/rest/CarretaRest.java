package chofer.com.rest;


import chofer.com.model.Carreta;
import chofer.com.service.CarretaService;
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
@RequestMapping(value = "/api/carreta")
public class CarretaRest {



    @Autowired
    private CarretaService carretaService;

    @RequestMapping(value = "/id/{idCarreta}",
            method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Optional<Carreta>> getCarretaById(@PathVariable("idCarreta") Integer idCarreta) {
        Optional<Carreta> carreta = this.carretaService.getCarretaById(idCarreta);
        return ResponseEntity.ok().body(carreta);
    }

    @RequestMapping(value = "/descripcion/{descripcion}",
            method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Carreta>getCarretaByDescripcion(@PathVariable("descripcion") String descripcion){
        Carreta carreta = this.carretaService.getCarretaByDescripcion(descripcion);
        return ResponseEntity.ok().body(carreta);
    }

    @RequestMapping(value = "/codigo/{codigo}",
            method = RequestMethod.GET, produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Carreta>getCarretaByCodigo(@PathVariable("codigo") String codigo) {
        Carreta carreta = this.carretaService.getCarretaByCodigo(codigo);
        return ResponseEntity.ok().body(carreta);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<java.util.List<Carreta>> gelAllCarreta() {
        return Optional.ofNullable(carretaService.getAllCarreta())
                .map(l -> new ResponseEntity<>(l, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces =
            {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Map> save(@RequestBody Carreta carreta) {
        return carretaService.save(carreta);
    }


}

package chofer.com.rest;


import chofer.com.Impresion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/impresion")
public class ImprimirRest {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    Impresion impresions = new Impresion();

/**
    //@RequestMapping(value = "/impresion-doc", method = RequestMethod.POST)
    public ResponseEntity<//String> Imprimir(){

        try {
            impresions.imprimirDirecto("C:\\Users\\Usuario\\Downloads\\cr7.png",0);
            return ResponseEntity.status(HttpStatus.OK).body("Imprimio");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error al imprimir");
        }

    }

    **/
}
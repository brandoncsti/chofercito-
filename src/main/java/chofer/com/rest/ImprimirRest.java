package chofer.com.rest;


import chofer.com.helpers.Impresionsftp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/impresion")
public class ImprimirRest {


    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    Impresionsftp impresionsftp = new Impresionsftp();


    @RequestMapping(value = "/impresion-doc", method = RequestMethod.POST)
    public String Imprimir(){
        return impresionsftp.LecuraSFTP();
    }

}
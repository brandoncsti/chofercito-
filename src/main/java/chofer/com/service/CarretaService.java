package chofer.com.service;

import chofer.com.model.Carreta;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public interface CarretaService {


    List<Carreta> getAllCarreta();
    Optional<Carreta> getCarretaById(Integer idCarreta);

   Carreta getCarretaByDescripcion(String descripcion);
    Carreta getCarretaByCodigo(String codigo);
    ResponseEntity<Map> save(Carreta carreta);



}

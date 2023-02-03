package chofer.com.service;


import chofer.com.model.Transporte;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface TransporteService {

    List<Transporte> getAllTransporte();
    Optional<Transporte> getTransporteById(Integer idTransporte);

    /*Optional<Transporte> getTransporteByPlaca(String placa);

    Optional<Transporte>getTransporteByModelo(String modelo);*/
    public ResponseEntity<Map>save(Transporte transporte);

}

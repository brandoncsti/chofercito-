package chofer.com.service;


import chofer.com.model.Chofer;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ChoferService {

    public List<Chofer>getAllChofer();
    Chofer getChoferByDni(String dni);
    Chofer getChoferByLicencia(String licencia);
    public ResponseEntity<Map>save(Chofer chofer);


}

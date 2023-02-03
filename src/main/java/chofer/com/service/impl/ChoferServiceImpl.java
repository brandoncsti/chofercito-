package chofer.com.service.impl;



import chofer.com.model.Chofer;
import chofer.com.repository.ChoferRepository;
import chofer.com.service.ChoferService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class ChoferServiceImpl implements ChoferService {



    @Autowired
    ChoferRepository choferRepository;

    @Override
    public List<Chofer> getAllChofer() {
        return choferRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    @Override
    public Chofer getChoferByDni(String dni) {

        return choferRepository.findByDni(dni);
    }

    @Override
    public Chofer getChoferByLicencia(String licencia) {
        return choferRepository.findByLicencia(licencia);
    }

    @Override
    public ResponseEntity<Map> save(Chofer chofer) {
        ResponseEntity response = null;
        Map map = new HashMap<>();
        try{
            if(choferRepository.findByLicencia(chofer.getLicencia()) != null){
                map.put("message", "La Licencia " + chofer.getLicencia() + " sé encuentra asignado a otro chofer");
                response = new ResponseEntity<Map>(map, HttpStatus.OK);
            }else if(choferRepository.findByDni(chofer.getDni()) != null){
                map.put("message", "El DNI " + chofer.getDni() + " sé encuentra registrado a otro chofer");
                response = new ResponseEntity<Map>(map, HttpStatus.OK);
            }else{
                LocalDateTime fechaactual = LocalDateTime.now();
                chofer.setFechaCreacion(fechaactual);
                map.put("data", choferRepository.save(chofer));
                response = new ResponseEntity(map, HttpStatus.OK);
            }
        }catch (Exception e){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return response;
    }




}

package chofer.com.service.impl;


import chofer.com.model.Transporte;
import chofer.com.repository.TransporteRepository;
import chofer.com.service.TransporteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TransporteServiceImpl  implements TransporteService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TransporteRepository transporteRepository;
    @Override
    public List<Transporte> getAllTransporte() {
        return transporteRepository.findAll();
    }

    @Override
    public Optional<Transporte> getTransporteById(Integer idTransporte) {
        return transporteRepository.findById(idTransporte);
    }

    @Override
    public ResponseEntity<Map> save(Transporte transporte) {
        ResponseEntity response = null;
        Map map = new HashMap<>();
        try{
            if(transporteRepository.findByPlaca(transporte.getPlaca()) != null){
                map.put("message", "La Placa " + transporte.getPlaca() + " sé encuentra registrado");
                response = new ResponseEntity<Map>(map, HttpStatus.OK);
            }else if(transporteRepository.findByModelo(transporte.getModelo()) != null){
                map.put("message", "El DNI " + transporte.getModelo() + " sé encuentra registrado a otro chofer");
                response = new ResponseEntity<Map>(map, HttpStatus.OK);
            }else{
                LocalDateTime fechaactual = LocalDateTime.now();
                transporte.setFechaCreacion(fechaactual);

                map.put("data", transporteRepository.save(transporte));
                response = new ResponseEntity(map, HttpStatus.OK);
            }
        }catch (Exception e){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return response;

    }
}

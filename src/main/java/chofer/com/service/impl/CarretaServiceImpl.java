package chofer.com.service.impl;


import chofer.com.model.Carreta;
import chofer.com.repository.CarretaRepository;
import chofer.com.service.CarretaService;
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
public class CarretaServiceImpl implements CarretaService {



    @Autowired
    private CarretaRepository carretaRepository;
    @Override
    public List<Carreta> getAllCarreta() {
        return carretaRepository.findAll();
    }

   @Override
    public Optional<Carreta> getCarretaById(Integer idCarreta) {
        return carretaRepository.findById(idCarreta);
    }

    @Override
    public Carreta getCarretaByDescripcion(String descripcion) {
        return carretaRepository.findByDescripcion(descripcion);
    }

    @Override
    public Carreta getCarretaByCodigo(String codigo) {

        return carretaRepository.findByCodigo(codigo);
    }


    @Override
    public ResponseEntity<Map> save(Carreta carreta) {
        ResponseEntity response = null;
        Map map = new HashMap<>();
        try{
            if(carretaRepository.findByDescripcion(carreta.getDescripcion()) != null){
                map.put("message", "La Descripcion " + carreta.getDescripcion() + " ya se encuentra resgistrado");
                response = new ResponseEntity<Map>(map, HttpStatus.OK);
            }else if(carretaRepository.findByCodigo(carreta.getCodigo()) != null){
                map.put("message", "El codigo " + carreta.getCodigo() + " sé encuentra registrado");
                response = new ResponseEntity<Map>(map, HttpStatus.OK);
            }else{
                LocalDateTime fechaactual = LocalDateTime.now();
                carreta.setFechaCreacion(fechaactual);


                map.put("data", carretaRepository.save(carreta));
                response = new ResponseEntity(map, HttpStatus.OK);
            }
        }catch (Exception e){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return response;
    }
}

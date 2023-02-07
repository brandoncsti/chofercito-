package chofer.com.service.impl;

import chofer.com.model.Estado;
import chofer.com.repository.EstadoRespository;
import chofer.com.service.EstadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class EstadoServiceImpl implements EstadoService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private EstadoRespository estadoRespository;

    @Override
    public Estado save(Estado estado){
        return estadoRespository.save(estado);
    }

    @Override
    public List<Estado> getAllEstado(){
        return estadoRespository.findAll();
    }
}

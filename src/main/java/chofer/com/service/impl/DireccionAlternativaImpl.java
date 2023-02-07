package chofer.com.service.impl;

import chofer.com.model.DireccionAlternativa;
import chofer.com.repository.DireccionAlternativaRepository;
import chofer.com.service.DireccionAlternativaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DireccionAlternativaImpl  implements DireccionAlternativaService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
     @Autowired
     private DireccionAlternativaRepository direccionAlternativaRepository;

     @Override
     public DireccionAlternativa save(DireccionAlternativa direccionAlternativa){
         return direccionAlternativaRepository.save(direccionAlternativa);
     }

     @Override
    public List<DireccionAlternativa> getAllDireccionAlternat(){
         return direccionAlternativaRepository.findAll();
     }
}

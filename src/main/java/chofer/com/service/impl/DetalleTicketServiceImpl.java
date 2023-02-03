package chofer.com.service.impl;

import chofer.com.model.DetalleTicket;
import chofer.com.model.TicketPesaje;
import chofer.com.repository.DetalleTicketRepository;
import chofer.com.service.DetalleTicketService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class DetalleTicketServiceImpl implements DetalleTicketService {

    private   final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private DetalleTicketRepository detalleTicketRepository;

    @Override
    public List<DetalleTicket> getDetalleTicket(){
        return detalleTicketRepository.findAll();
    }


    @Override
    public DetalleTicket save(DetalleTicket detalleTicket) {
        LocalDateTime fechaActual = LocalDateTime.now();
        LocalDateTime fechaCreacion = detalleTicketRepository.findById(detalleTicket.getId()).get().getFechaCreacion();

        if(detalleTicket.getId()==null){
            detalleTicket.setFechaCreacion(fechaActual);
            detalleTicket.setFechaModificacion(null);

        }

        detalleTicket.setFechaModificacion(fechaActual);
        detalleTicket.setFechaCreacion(fechaCreacion);

        return detalleTicketRepository.save(detalleTicket);
    }

}

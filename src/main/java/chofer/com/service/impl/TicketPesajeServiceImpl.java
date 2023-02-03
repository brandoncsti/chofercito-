package chofer.com.service.impl;


//import chofer.com.helpers.ValidarEdit;
import chofer.com.model.DetalleTicket;
import chofer.com.model.TicketPesaje;
import chofer.com.repository.DetalleTicketRepository;
import chofer.com.repository.TicketPesajeRepository;
import chofer.com.service.TicketPesajeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class TicketPesajeServiceImpl implements TicketPesajeService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TicketPesajeRepository ticketPesajeRepository;


    @Override
    public List<TicketPesaje> getAllTicketPesaje() {

        return ticketPesajeRepository.findAll();
    }

    @Override
    public TicketPesaje getTicketPesajeById(Integer idTicketPesaje)  {
        return ticketPesajeRepository.findById(idTicketPesaje).orElse(null);
    }

   /* @Override
    public TicketPesaje save(TicketPesaje ticketPesaje) {
        List<DetalleTicket> detalles = new ArrayList<>();
        //ticketPesaje.setDetalleTicketList(null);
        //ticketPesajeRepository.save(ticketPesaje);
        TicketPesaje ticketPesajes =  ticketPesajeRepository.save(ticketPesaje);


            for (DetalleTicket det:ticketPesaje.getDetalleTicketList()){

                det.setTicketPesaje(ticketPesajes);
                detalles.add(det);
            }

        List<DetalleTicket> detallesf = detalleTicketRepository.saveAll(ticketPesaje.getDetalleTicketList());
        ticketPesaje.setDetalleTicketList(detallesf);
        return ticketPesaje;
    }*/

        /*if (ticketPesajeRepository.findById(ticketPesaje.getId()) != null) {
            LocalDateTime fechaActual = LocalDateTime.now();
            ticketPesaje.setFechaModificacion(fechaActual);
            ticketPesaje.getDetalleTicketList().forEach(det -> {
                det.setTicketPesaje(ticketPesaje);
            });
            ticketPesajeRepository.save(ticketPesaje);
        }else{
            LocalDateTime fechaActuales = LocalDateTime.now();
            ticketPesaje.setFechaCreacion(fechaActuales);
            ticketPesaje.getDetalleTicketList().forEach(det->{
                det.setTicketPesaje(ticketPesaje);
            });
            ticketPesajeRepository.save(ticketPesaje);

        }
        return ticketPesajeRepository.save(ticketPesaje);*/


   /* @Override
    public TicketPesaje save(TicketPesaje ticketPesaje) {

        List<DetalleTicket> detalles = new ArrayList<>();
        //ticketPesaje.setDetalleTicketList(null);
        //ticketPesajeRepository.save(ticketPesaje);
        TicketPesaje ticketPesajes =  ticketPesajeRepository.save(ticketPesaje);
      for(DetalleTicket det:ticketPesaje.getDetalleTicketList()){

            det.setTicketPesaje(ticketPesajes);

           detalles.add(det);
        }

        List<DetalleTicket> detallesf = detalleTicketRepository.saveAll(ticketPesaje.getDetalleTicketList());
        ticketPesaje.setDetalleTicketList(detallesf);

        return ticketPesaje;

       /* LocalDateTime fechaActual = LocalDateTime.now();
        ticketPesaje.setFechaCreacion(fechaActual);
        return ticketPesajeRepository.save(ticketPesaje);
    }*/

    @Override
    public List<TicketPesaje> getTicketPesajeListPorFechas(Date fechaInicio, Date fechaFin) {
        return ticketPesajeRepository.getTicketPesajeByFechaRegistroBetween(fechaInicio, fechaFin);
    }

    @Override
    public TicketPesaje save(TicketPesaje ticketPesaje) {
        LocalDateTime fechaActual = LocalDateTime.now();
        LocalDateTime fechaCreacion = ticketPesajeRepository.findById(ticketPesaje.getId()).get().getFechaCreacion();

        if(ticketPesaje.getId()==null){
            ticketPesaje.setFechaCreacion(fechaActual);
            ticketPesaje.setFechaModificacion(null);
            List<DetalleTicket> list = ticketPesaje.getDetalleTicketList();
            for(DetalleTicket dt:list){
                dt.setFechaModificacion(null);
                dt.setFechaCreacion(fechaActual);
            }
            ticketPesaje.setFechaModificacion(null);
        }

            ticketPesaje.setFechaModificacion(fechaActual);
            ticketPesaje.setFechaCreacion(fechaCreacion);
            List<DetalleTicket> list = ticketPesaje.getDetalleTicketList();
            for(DetalleTicket dt:list){
                dt.setFechaModificacion(fechaActual);
                dt.setFechaCreacion(fechaCreacion);
            }




        ticketPesaje.getDetalleTicketList().forEach(det->{
            det.setTicketPesaje(ticketPesaje);
        });
        return ticketPesajeRepository.save(ticketPesaje);
    }


}







   /* @Override
    public ResponseEntity <Map> update(TicketPesaje ticketPesaje) {
        ResponseEntity response = null;
        Map map = new HashMap<>();
        try{
            TicketPesaje ticketPesajeActual = ticketPesajeRepository.findById(ticketPesaje.getId()).orElse(null);
            if(ticketPesajeActual != null) {
                ticketPesajeActual.setChofer(ticketPesaje.getChofer());
                ticketPesajeActual.setTransporte(ticketPesaje.getTransporte());
                ticketPesajeActual.setCarreta(ticketPesaje.getCarreta());
                ticketPesajeActual.setTipoProceso(ticketPesaje.getTipoProceso());
                ticketPesajeActual.setUnidadMedida(ticketPesaje.getUnidadMedida());
                ticketPesajeActual.setPesoInicial(ticketPesaje.getPesoInicial());
                ticketPesajeActual.setFechaModificacion(ticketPesaje.getFechaModificacion());
                ticketPesajeActual = ticketPesajeRepository.save(ticketPesajeActual);
            }
            ticketPesaje = ticketPesajeActual;
            LocalDateTime fechaActualmodi = LocalDateTime.now();
            ticketPesaje.setFechaModificacion(fechaActualmodi);
            map.put("data", ticketPesajeRepository.save(ticketPesaje));
            response = new ResponseEntity(map, HttpStatus.OK);
        }catch (Exception e){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }


        return response;
    }
*/



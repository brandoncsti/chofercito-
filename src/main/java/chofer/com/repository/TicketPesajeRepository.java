package chofer.com.repository;


import chofer.com.model.TicketPesaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TicketPesajeRepository extends JpaRepository<TicketPesaje, Integer> {
    @Query("SELECT t FROM TicketPesaje t where t.fechaCreacion between ?1 and ?2 ")
    List<TicketPesaje> getTicketPesajeByFechaRegistroBetween(Date fechaInicio, Date fechaFin);

}

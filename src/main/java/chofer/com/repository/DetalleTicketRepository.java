package chofer.com.repository;


import chofer.com.model.DetalleTicket;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface DetalleTicketRepository extends JpaRepository<DetalleTicket, Integer> {
    //public DetalleTicket findByFechaCreacion(LocalDateTime licencia);

    //public DetalleTicket findByCod_balanza(String cod_balanza);
}

package chofer.com.repository;


import chofer.com.model.Chofer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ChoferRepository extends JpaRepository<Chofer, Integer> {

    public Chofer findByLicencia(String licencia);

    public Chofer findByDni(String dni);


}

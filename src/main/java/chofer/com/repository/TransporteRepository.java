package chofer.com.repository;



import chofer.com.model.Transporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  TransporteRepository extends JpaRepository<Transporte, Integer> {
    Transporte findByPlaca(String placa);
    Transporte findByModelo(String modelo);
}

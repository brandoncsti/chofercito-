package chofer.com.repository;


import chofer.com.model.Carreta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarretaRepository extends JpaRepository<Carreta, Integer> {
    public Carreta findByDescripcion(String descripcion);

    public Carreta findByCodigo(String codigo);
}

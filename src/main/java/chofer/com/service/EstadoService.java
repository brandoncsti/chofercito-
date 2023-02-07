package chofer.com.service;

import chofer.com.model.Estado;

import java.util.List;

public interface EstadoService {
    Estado save(Estado estado);
    List<Estado> getAllEstado();
}

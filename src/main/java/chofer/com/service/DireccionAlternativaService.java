package chofer.com.service;

import chofer.com.model.DireccionAlternativa;

import java.util.List;

public interface DireccionAlternativaService {

    DireccionAlternativa save(DireccionAlternativa direccionAlternativa);

    List<DireccionAlternativa> getAllDireccionAlternat();
}

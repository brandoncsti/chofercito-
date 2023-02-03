package chofer.com.service.impl;

import chofer.com.model.GuiaRemision;
import chofer.com.repository.GuiaRemisionRepository;
import chofer.com.service.GuiaRemisionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
public class GuiaRemisionServiceImpl implements GuiaRemisionService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private GuiaRemisionRepository guiaRemisionRepository;




    @Override
    public List<GuiaRemision> getAllGuiaRemision() {
            return guiaRemisionRepository.findAll().stream()
                .collect(Collectors.toList());
    }

    /**
     * @param idGuiaRemision
     * @return
     */
    @Override
    public GuiaRemision getGuiaRemisionById(Integer idGuiaRemision){
        return guiaRemisionRepository.findById(idGuiaRemision).orElse(null);
    }


    /**
     * @param guiaRemision
     * @return
     */
    @Override
    public GuiaRemision save(GuiaRemision guiaRemision) {
        return guiaRemisionRepository.save(guiaRemision);
    }





    /*@Override
    public List<Proveedor> getProveedorByProveedorandRucandSocial(FiltroProveedorDTO filtro) {
        return proveedorRepository.getProveedorByProveedorandRucandSocial(filtro.getIdProveedor(),filtro.getRuc(),filtro.getRazonSocial());
    }
*/
   /* @Override
    public List<Proveedor> getProveedorByProveedorandRucandSocial(Integer idProveedor, String ruc, String razonSocial) {
        return proveedorRepository.getProveedorByProveedorandRucandSocial(idProveedor, ruc, razonSocial);
    }*/

   /* @Override
    public List<Proveedor> getProveedorByProveedorandRucandSocial(Integer idProveedor, String ruc, String razonSocial) {
        return proveedorRepository.getProveedorByProveedorandRucandSocial(idProveedor,ruc,razonSocial);
    }

*/



    /*@Override
    public List<Proveedor> getProveedorByProveedorandRucandSocial(Integer idProveedor, String ruc, String razonSocial) {
        return proveedorRepository.getProveedorByProveedorandRucandSocial(idProveedor,ruc,razonSocial);;
    }*/
}

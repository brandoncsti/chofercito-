package chofer.com.service.impl;

import chofer.com.model.GuiaRemision;
import chofer.com.repository.GuiaRemisionRepository;
import chofer.com.service.GuiaRemisionService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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



    @Override
    public String getAllGuiaRemisionPDF(String formato) throws FileNotFoundException, JRException {

       List<GuiaRemision> guiaRemision =guiaRemisionRepository.findAll();

       File  file = ResourceUtils.getFile("classpath:GuiaRemision.jrxml");
       JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
       JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(guiaRemision);
        Map<String, Object> map = new HashMap<>();
        map.put("createdBy","TITLE");
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,map,dataSource);
        if(formato.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint,"C:\\Users\\Usuario\\Desktop\\sftp-testing"+"\\GuiaRemision.pdf");
            //JasperExportManager.exportReportToPdfStream(jasperPrint);
        }
        if(formato.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint,"C:\\Users\\Usuario\\Desktop\\sftp-testing"+"\\GuiaRemision.html");
        }

        return "reporte generado";
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

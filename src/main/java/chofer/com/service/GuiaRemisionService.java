package chofer.com.service;




import chofer.com.model.GuiaRemision;

import java.util.List;

public interface GuiaRemisionService {
    List<GuiaRemision> getAllGuiaRemision();
    GuiaRemision getGuiaRemisionById(Integer idGuiaRemision);
    GuiaRemision save(GuiaRemision guiaRemision);


    //Proveedor getProveedorByProveedorandRucandSocial(Integer idProveedor, String ruc, String razonSocial);
    //List<TicketPesaje>getTicketPesajeListPorFechas(Date fechaInicio, Date fechaFin);
   // List<Proveedor> getProveedorByProveedorandRucandSocial(FiltroProveedorDTO filtro);
}

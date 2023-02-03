package chofer.com.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Access(AccessType.FIELD)
@Table(name="BLZ_GUIA_REMISION")
public class GuiaRemision implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(generator = "GUIA_REMISION_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "GUIA_REMISION_ID_SEQ", sequenceName = "GUIA_REMISION_ID_SEQ", allocationSize = 1)
    @Column(name="ID_GUIA_REMISION", unique=true, nullable=false)
    private Integer id;
    @Column(name="SERIE_GUIA", nullable=false)
    private String serieGuia;
    @Column(name="NRO_GUIA", nullable=false)
    private Integer nroGuia;
    @Column(name="ID_TIPO_GUIA", nullable=false)
    private Integer idtipoGuia;
    @Column(name="ID_MOT_TRANSLADO", nullable=false)
    private Integer idmotTraslado;
    @Column(name="TEXTO_GUIA", nullable=false)
    private Integer textoGuia;
    @Column(name="ID_TICKET_PESAJE", nullable=false)
    private Integer idTicketPesaje;
    @Column(name="RAZON_SOCIAL", nullable=false)
    private Integer RazonSocial;
    @Column(name="RUC", nullable=false)
    private Integer ruc;
    @Column(name="ID_CENTRO_ALMACEN_ORIGEN", nullable=false)
    private Integer idCentroAlmacenOrigen;
    @Column(name="ID_CENTRO_ALMACEN_DESTINO", nullable=false)
    private Integer idCentroAlmacenDestino;
    @Column(name="PROOVEDOR_ORIGEN", nullable=false)
    private Integer proveedorOrigen;
    @Column(name="PROOVEDOR_DESTINO", nullable=false)
    private Integer proveedorDestino;
    @Column(name="CLIENTE_DESTINO", nullable=false)
    private Integer clienteDestino;
    @Column(name="DIRECCION_DESTINO", nullable=false)
    private Integer direccionDestino;
    @Column(name="DIRECCION_ORIGEN", nullable=false)
    private Integer direccionOrigen;
    @Column(name="PLACA", nullable=false)
    private Integer placa;
    @Column(name="MARCA", nullable=false)
    private Integer marca;
    @Column(name="CHOFER_DNI", nullable=false)
    private Integer choferdni;
    @Column(name="NRO_LICENCIA", nullable=false)
    private Integer nroLicencia;
    @Column(name="NOMBRES_CHOFER", nullable=false)
    private Integer nombreschofer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerieGuia() {
        return serieGuia;
    }

    public void setSerieGuia(String serieGuia) {
        this.serieGuia = serieGuia;
    }

    public Integer getNroGuia() {
        return nroGuia;
    }

    public void setNroGuia(Integer nroGuia) {
        this.nroGuia = nroGuia;
    }

    public Integer getIdtipoGuia() {
        return idtipoGuia;
    }

    public void setIdtipoGuia(Integer idtipoGuia) {
        this.idtipoGuia = idtipoGuia;
    }

    public Integer getIdmotTraslado() {
        return idmotTraslado;
    }

    public void setIdmotTraslado(Integer idmotTraslado) {
        this.idmotTraslado = idmotTraslado;
    }

    public Integer getTextoGuia() {
        return textoGuia;
    }

    public void setTextoGuia(Integer textoGuia) {
        this.textoGuia = textoGuia;
    }

    public Integer getIdTicketPesaje() {
        return idTicketPesaje;
    }

    public void setIdTicketPesaje(Integer idTicketPesaje) {
        this.idTicketPesaje = idTicketPesaje;
    }

    public Integer getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(Integer razonSocial) {
        RazonSocial = razonSocial;
    }

    public Integer getRuc() {
        return ruc;
    }

    public void setRuc(Integer ruc) {
        this.ruc = ruc;
    }

    public Integer getIdCentroAlmacenOrigen() {
        return idCentroAlmacenOrigen;
    }

    public void setIdCentroAlmacenOrigen(Integer idCentroAlmacenOrigen) {
        this.idCentroAlmacenOrigen = idCentroAlmacenOrigen;
    }

    public Integer getIdCentroAlmacenDestino() {
        return idCentroAlmacenDestino;
    }

    public void setIdCentroAlmacenDestino(Integer idCentroAlmacenDestino) {
        this.idCentroAlmacenDestino = idCentroAlmacenDestino;
    }

    public Integer getProveedorOrigen() {
        return proveedorOrigen;
    }

    public void setProveedorOrigen(Integer proveedorOrigen) {
        this.proveedorOrigen = proveedorOrigen;
    }

    public Integer getProveedorDestino() {
        return proveedorDestino;
    }

    public void setProveedorDestino(Integer proveedorDestino) {
        this.proveedorDestino = proveedorDestino;
    }

    public Integer getClienteDestino() {
        return clienteDestino;
    }

    public void setClienteDestino(Integer clienteDestino) {
        this.clienteDestino = clienteDestino;
    }

    public Integer getDireccionDestino() {
        return direccionDestino;
    }

    public void setDireccionDestino(Integer direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

    public Integer getDireccionOrigen() {
        return direccionOrigen;
    }

    public void setDireccionOrigen(Integer direccionOrigen) {
        this.direccionOrigen = direccionOrigen;
    }

    public Integer getPlaca() {
        return placa;
    }

    public void setPlaca(Integer placa) {
        this.placa = placa;
    }

    public Integer getMarca() {
        return marca;
    }

    public void setMarca(Integer marca) {
        this.marca = marca;
    }

    public Integer getChoferdni() {
        return choferdni;
    }

    public void setChoferdni(Integer choferdni) {
        this.choferdni = choferdni;
    }

    public Integer getNroLicencia() {
        return nroLicencia;
    }

    public void setNroLicencia(Integer nroLicencia) {
        this.nroLicencia = nroLicencia;
    }

    public Integer getNombreschofer() {
        return nombreschofer;
    }

    public void setNombreschofer(Integer nombreschofer) {
        this.nombreschofer = nombreschofer;
    }
    @Override
    public String toString() {
        return "TicketPesaje{" +
                "id=" + id +
                ", serieGuia=" + serieGuia +
                ", nroGuia=" + nroGuia +
                ", idtipoGuia=" + idtipoGuia +
                ", idmotTraslado=" + idmotTraslado +
                ", textoGuia=" + textoGuia +
                ", idTicketPesaje=" + idTicketPesaje +
                ", RazonSocial=" + RazonSocial +
                ", ruc=" + ruc +
                ", idCentroAlmacenOrigen=" + idCentroAlmacenOrigen +
                ", idCentroAlmacenDestino=" + idCentroAlmacenDestino +
                ", proveedorOrigen=" + proveedorOrigen +
                ", proveedorDestino=" + proveedorDestino +
                ", clienteDestino=" + clienteDestino +
                ", direccionDestino=" + direccionDestino +
                ", direccionOrigen=" + direccionOrigen +
                ", placa=" + placa +
                ", marca=" + marca +
                ", choferdni=" + choferdni +
                ", nroLicencia=" + nroLicencia +
                ", nombreschofer=" + nombreschofer +
                '}';
    }
}

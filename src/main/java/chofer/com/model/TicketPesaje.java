package chofer.com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
@Table(name="BLZ_TICKET_PESAJE")
public class TicketPesaje implements Serializable {

    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue(generator = "TICKET_PESAJE_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TICKET_PESAJE_ID_SEQ", sequenceName = "TICKET_PESAJE_ID_SEQ", allocationSize = 1)
    @Column(name="ID_TICKET_PESAJE", unique=true, nullable=false)
    private Integer id;


    //@JsonIgnoreProperties(value={"ticketPesaje", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @JsonIgnoreProperties(value={"choferticketPesajeList", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Chofer.class)
    @JoinColumn(name="ID_CHOFER", referencedColumnName = "ID_CHOFER")
    private Chofer chofer;


    /*@Column(name="ID_CHOFER", nullable=false)
    private Integer chofer;*/
    //@JsonIgnoreProperties(value={"ticketPesaje", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @JsonIgnoreProperties(value={"transporteticketPesajeList", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Transporte.class)
    @JoinColumn(name="ID_TRANSPORTE", referencedColumnName = "ID_TRANSPORTE")
    private Transporte transporte;
    /*@Column(name="ID_TRANSPORTE", nullable=false)
    private Integer transporte;*/
    //@JsonIgnoreProperties(value={"ticketPesaje", "hibernateLazyInitializer", "handler"}, allowSetters=true)


    @JsonIgnoreProperties(value={"carretaticketPesajeList", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Carreta.class)
    @JoinColumn(name="ID_CARRETA", referencedColumnName = "ID_CARRETA")
    private Carreta carreta;

    /* @Column(name="ID_CARRETA", nullable=false)
    private Integer carreta;*/



    @Column(name="UNIDAD_MEDIDA" )
    private String unidadMedida;

    @Column(name="PESO_INICIAL")
    private Integer pesoInicial;

    @Column(name="FECHA_REGISTRO" )
    private LocalDateTime fechaCreacion;

    @Column(name="FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    /*@ManyToOne(fetch = FetchType.LAZY, targetEntity = CentroAlmacen.class)
    @JoinColumn(name="id_centro_almacen", referencedColumnName = "id_centro_almacen", insertable = false, updatable = false)
    private CentroAlmacen centroAlmacen;*/



    //@JsonIgnoreProperties(value={"ticketPesaje", "hibernateLazyInitializer", "handler"}, allowSetters=true)

    @JsonIgnoreProperties(value={"ticketPesaje", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @OneToMany(mappedBy = "ticketPesaje", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<DetalleTicket> detalleTicketList;



    //@JsonIgnoreProperties(value={ "hibernateLazyInitializer", "handler"}, allowSetters=true)

    @NotNull
    @OneToOne
    @JoinColumn( name = "ID_ESTADO")
    private Estado estado;

    public TicketPesaje() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Chofer getChofer() {
        return chofer;
    }

    public void setChofer(Chofer chofer) {
        this.chofer = chofer;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public Carreta getCarreta() {
        return carreta;
    }

    public void setCarreta(Carreta carreta) {
        this.carreta = carreta;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public Integer getPesoInicial() {
        return pesoInicial;
    }

    public void setPesoInicial(Integer pesoInicial) {
        this.pesoInicial = pesoInicial;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDateTime getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDateTime fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public List<DetalleTicket> getDetalleTicketList() {
        return detalleTicketList;
    }

    public void setDetalleTicketList(List<DetalleTicket> detalleTicketList) {
        this.detalleTicketList = detalleTicketList;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }



    @Override
    public String toString() {
        return "TicketPesaje{" +
                "id=" + id +
                ", chofer=" + chofer +
                ", transporte=" + transporte +
                ", carreta=" + carreta +
                ", unidadMedida='" + unidadMedida + '\'' +
                ", pesoInicial=" + pesoInicial +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaModificacion=" + fechaModificacion +
                ", detalleTicketList=" + detalleTicketList +
                ", estado=" + estado +
                '}';
    }

}

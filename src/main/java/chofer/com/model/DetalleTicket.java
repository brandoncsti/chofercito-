package chofer.com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Entity
@Access(AccessType.FIELD)
@Table(name="BLZ_DETALLE_TICKET")
public class DetalleTicket implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "DETALLE_TICKET_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "DETALLE_TICKET_ID_SEQ", sequenceName = "DETALLE_TICKET_ID_SEQ", allocationSize = 1)
    @Column(name="ID_DETALLE_TICKET", unique=true, nullable=false)
    private Integer id;


    @Column(name="PESO_BRUTO")
    private Double peso_bruto;


    @Column(name="COD_BALANZA")
    private String cod_balanza;
    @Column(name="PESO_NETO")
    private Double peso_neto;

    @Column(name="POSICION")
    private Integer posicion;

    @Column(name="TIPO_PESO")
    private String tipo_peso;

    @Column(name="TIPO_PESAJE")
    private String tipoPesaje;

    @Column(name="FECHA_REGISTRO")
    private LocalDateTime fechaCreacion;

    @Column(name="FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;


    //@JsonIgnoreProperties(value={"detalleTicketList", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = TicketPesaje.class)
    @JoinColumn(name="ID_TICKET_PESAJE", referencedColumnName = "ID_TICKET_PESAJE")
    private TicketPesaje ticketPesaje;



    @NotNull
    @OneToOne
    @JoinColumn(name = "ID_ESTADO")
    private Estado estado;



    public DetalleTicket() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPeso_bruto() {
        return peso_bruto;
    }

    public void setPeso_bruto(Double peso_bruto) {
        this.peso_bruto = peso_bruto;
    }

    public String getCod_balanza() {
        return cod_balanza;
    }

    public void setCod_balanza(String cod_balanza) {
        this.cod_balanza = cod_balanza;
    }

    public Double getPeso_neto() {
        return peso_neto;
    }

    public void setPeso_neto(Double peso_neto) {
        this.peso_neto = peso_neto;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public String getTipo_peso() {
        return tipo_peso;
    }

    public void setTipo_peso(String tipo_peso) {
        this.tipo_peso = tipo_peso;
    }

    public String getTipoPesaje() {
        return tipoPesaje;
    }

    public void setTipoPesaje(String tipoPesaje) {
        this.tipoPesaje = tipoPesaje;
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

    public TicketPesaje getTicketPesaje() {
        return ticketPesaje;
    }

    public void setTicketPesaje(TicketPesaje ticketPesaje) {
        this.ticketPesaje = ticketPesaje;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "DetalleTicket{" +
                "id=" + id +
                ", peso_bruto=" + peso_bruto +
                ", cod_balanza='" + cod_balanza + '\'' +
                ", peso_neto=" + peso_neto +
                ", posicion=" + posicion +
                ", tipo_peso='" + tipo_peso + '\'' +
                ", tipoPesaje='" + tipoPesaje + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaModificacion=" + fechaModificacion +
                ", ticketPesaje=" + ticketPesaje +
                ", estado=" + estado +
                '}';
    }
}

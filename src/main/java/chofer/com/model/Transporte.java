package chofer.com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Access(AccessType.FIELD)

@Table(name="BLZ_TRANSPORTE")
public class Transporte implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "TRANSPORTE_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "TRANSPORTE_ID_SEQ", sequenceName = "TRANSPORTE_ID_SEQ", allocationSize = 1)
    @Column(name="ID_TRANSPORTE", unique=true, nullable=false)
    private Integer id;

    @Column(name="PLACA", unique=true, nullable=false, length=7)
    private String placa;

    @Column(name="REMOLQUE",  nullable=false, length=20)
    private String remolque;

    @Column(name="MARCA", nullable=false, length=50)
    private String marca;

    @Column(name="MODELO", length = 50,  nullable = false)
    private String modelo;

    @Column(name="FECHA_REGISTRO")
    private LocalDateTime fechaCreacion;

    @Column(name="FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;

    @JsonIgnoreProperties(value={"transporte", "hibernateLazyInitializer", "handler"}, allowSetters=true)

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "transporte", targetEntity = TicketPesaje.class, fetch = FetchType.LAZY)
    private List<TicketPesaje> transporteticketPesajeList;

    public Transporte() {}



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRemolque() {
        return remolque;
    }

    public void setRemolque(String remolque) {
        this.remolque = remolque;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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

    public List<TicketPesaje> getTransporteticketPesajeList() {
        return transporteticketPesajeList;
    }

    public void setTransporteticketPesajeList(List<TicketPesaje> transporteticketPesajeList) {
        this.transporteticketPesajeList = transporteticketPesajeList;
    }

    @Override
    public String toString() {
        return "Transporte{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", remolque='" + remolque + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaModificacion=" + fechaModificacion +
                ", transporteticketPesajeList=" + transporteticketPesajeList +
                '}';
    }
}

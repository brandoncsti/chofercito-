package chofer.com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
@Table(name="BLZ_CARRETA")
public class Carreta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "CARRETA_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CARRETA_ID_SEQ", sequenceName = "CARRETA_ID_SEQ", allocationSize = 1)
    @Column(name="ID_CARRETA", unique=true, nullable=false)
    private Integer id;
    @Column(name="PLACA")
    private String placa;
    @Column(name="MODELO")

    private String modelo;
    @Column(name="CODIGO")
    private String codigo;
    @Column(name="DESCRIPCION")
    private String descripcion;

    @Column(name="FECHA_REGISTRO")
    private LocalDateTime fechaCreacion;

    @Column(name="FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;


    @JsonIgnoreProperties(value={"carreta", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carreta", targetEntity = TicketPesaje.class, fetch = FetchType.LAZY)
    private List<TicketPesaje> carretaticketPesajeList;


    public Carreta() {}



    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public List<TicketPesaje> getCarretaticketPesajeList() {
        return carretaticketPesajeList;
    }

    public void setCarretaticketPesajeList(List<TicketPesaje> carretaticketPesajeList) {
        this.carretaticketPesajeList = carretaticketPesajeList;
    }

    @Override
    public String toString() {
        return "Carreta{" +
                "id=" + id +
                ", placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaModificacion=" + fechaModificacion +
                ", carretaticketPesajeList=" + carretaticketPesajeList +
                '}';
    }
}

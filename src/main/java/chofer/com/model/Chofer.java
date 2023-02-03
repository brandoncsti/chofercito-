package chofer.com.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Access(AccessType.FIELD)
@Table(name="BLZ_CHOFER")
public class Chofer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "CHOFER_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "CHOFER_ID_SEQ", sequenceName = "CHOFER_ID_SEQ", allocationSize = 1)
    @Column(name="ID_CHOFER", unique=true, nullable=false)
    private Integer id;

    @Column(name="LICENCIA", length = 9, unique = true, nullable = false)
    private String licencia;

    @Column(name="NOMBRE", length = 50,  nullable = false)
    private String nombre;

    @Column(name="DNI", length = 8, unique = true, nullable = false)
    private String dni;


    @Column(name="FECHA_REGISTRO")
    private LocalDateTime fechaCreacion;

    @Column(name="FECHA_MODIFICACION")
    private LocalDateTime fechaModificacion;


    @JsonIgnoreProperties(value={"chofer", "hibernateLazyInitializer", "handler"}, allowSetters=true)
    @OneToMany( cascade = CascadeType.ALL, mappedBy = "chofer", targetEntity = TicketPesaje.class, fetch = FetchType.LAZY)
    private List<TicketPesaje> choferticketPesajeList;


    public Chofer(){

    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public List<TicketPesaje> getChoferticketPesajeList() {
        return choferticketPesajeList;
    }

    public void setChoferticketPesajeList(List<TicketPesaje> choferticketPesajeList) {
        this.choferticketPesajeList = choferticketPesajeList;
    }

    @Override
    public String toString() {
        return "Chofer{" +
                "id=" + id +
                ", licencia='" + licencia + '\'' +
                ", nombre='" + nombre + '\'' +
                ", dni='" + dni + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", fechaModificacion=" + fechaModificacion +
                ", choferticketPesajeList=" + choferticketPesajeList +
                '}';
    }
}

package chofer.com.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Access(AccessType.FIELD)
@Table(name="BLZ_DIRECCION_ALTERNATIVA")
public class DireccionAlternativa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "DIRECCION_ALTERNATIVA_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "DIRECCION_ALTERNATIVA_ID_SEQ", sequenceName = "DIRECCION_ALTERNATIVA_ID_SEQ", allocationSize = 1)
    @Column(name = "ID_DIRECCION_ALTERNATIVA", unique = true, nullable = false)
    private Integer id;


    @Column(name = "ID_PROVEEDOR")
    private Integer idProveedor;

   /* @Column(name="ID_PROVEEDOR",  nullable=false, length=4)
    private String codigo;*/


    @Column(name = "DESCRIPCION",length = 250)
    private String descripcion;



    public DireccionAlternativa() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "DireccionAlternativa{" +
                "id=" + id +
                ", idProveedor=" + idProveedor +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

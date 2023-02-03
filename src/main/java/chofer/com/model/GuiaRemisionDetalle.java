package chofer.com.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Access(AccessType.FIELD)
@Table(name="BLZ_GUIA_REMISION_DETALLE")
public class GuiaRemisionDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "GUIA_REMISION_DETALLE_ID_SEQ", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "GUIA_REMISION_DETALLE_ID_SEQ", sequenceName = "GUIA_REMISION_DETALLE_ID_SEQ", allocationSize = 1)
    @Column(name="ID_GUIA_REMISION_DETALLE", unique=true, nullable=false)
    private Integer id;
    @Column(name="ID_GUIA", nullable=false)
    private Integer idGuia;
    @Column(name="DOC_MATERIAL", nullable=false)
    private Integer docMaterial;
    @Column(name="EJERCICIO", nullable=false)
    private String ejercicio;
    @Column(name="POSICION", nullable=false)
    private Integer posicion;
    @Column(name="MATERIAL", nullable=false)
    private Integer material;
    @Column(name="DESCRIPCION", nullable=false)
    private String descripcion;
    @Column(name="LOTE", nullable=false)
    private Integer lote;
    @Column(name="CANT_DISPONIBLE", nullable=false)
    private Integer cantDisponible;
    @Column(name="UM", nullable=false)
    private String unidadMedida;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getidGuia() {
        return idGuia;
    }

    public void setidGuia(Integer idGuia) {
        this.idGuia = idGuia;
    }

    public Integer getDocMaterial() {
        return docMaterial;
    }

    public void setDocMaterial(Integer docMaterial) {
        this.docMaterial = docMaterial;
    }

    public String getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(String ejercicio) {
        this.ejercicio = ejercicio;
    }

    public Integer getPosicion() {
        return posicion;
    }

    public void setPosicion(Integer posicion) {
        this.posicion = posicion;
    }

    public Integer getMaterial() {
        return material;
    }

    public void setMaterial(Integer material) {
        this.material = material;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getLote() {
        return lote;
    }

    public void setLote(Integer lote) {
        this.lote = lote;
    }

    public Integer getCantDisponible() {
        return cantDisponible;
    }

    public void setCantDisponible(Integer cantDisponible) {
        this.cantDisponible = cantDisponible;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    @Override
    public String toString() {
        return "TicketPesaje{" +
                "id=" + id +

                ", idGuia=" + idGuia +
                ", docMaterial=" + docMaterial +
                ", ejercicio=" + ejercicio +
                ", posicion=" + posicion +
                ", material=" + material +
                ", descripcion=" + descripcion +
                ", lote=" + lote +
                ", cantDisponible=" + cantDisponible +
                ", unidadMedida=" + unidadMedida +
                '}';
    }
}

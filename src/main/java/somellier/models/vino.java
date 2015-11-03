package somellier.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "vino")
public class Vino {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nombre;

    @Column(length=1000)
    private String descripcion;

    private String cosecha;

    private float graduacion;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="cod_bodega")
    private Bodega bodega;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="cod_uva")
    private Uva uva;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="cod_tipo")
    private TipoVino tipoVino;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="cod_edad")
    private Edad edad;

    public Vino() {
    }

    public Vino(int id) {
        this.id = id;
    }

    public Vino(String nombre, String descripcion, String cosecha, float graduacion, Bodega bodega, Uva uva, TipoVino tipoVino, Edad edad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cosecha = cosecha;
        this.graduacion = graduacion;
        this.bodega = bodega;
        this.uva = uva;
        this.tipoVino = tipoVino;
        this.edad = edad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCosecha() {
        return cosecha;
    }

    public void setCosecha(String cosecha) {
        this.cosecha = cosecha;
    }

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public Uva getUva() {
        return uva;
    }

    public void setUva(Uva uva) {
        this.uva = uva;
    }

    public Edad getEdad() {
        return edad;
    }

    public void setEdad(Edad edad) {
        this.edad = edad;
    }

    public float getGraduacion() {
        return graduacion;
    }

    public void setGraduacion(float graduacion) {
        this.graduacion = graduacion;
    }

    public TipoVino getTipoVino() {
        return tipoVino;
    }

    public void setTipoVino(TipoVino tipoVino) {
        this.tipoVino = tipoVino;
    }
}

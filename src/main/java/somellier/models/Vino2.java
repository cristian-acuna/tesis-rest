package somellier.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "vino")
public class Vino2 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String nombre;

    @NotNull
    @Column(length=1000)
    private String descripcion;

    @NotNull
    private String cosecha;

    @NotNull
    private String graduacion;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="cod_tipo")
    private TipoVino tipoVino;

    public Vino2() {
    }

    public Vino2(int id) {
        this.id = id;
    }

    public Vino2(String nombre, String descripcion, String cosecha, String graduacion, TipoVino tipoVino) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cosecha = cosecha;
        this.graduacion = graduacion;
        this.tipoVino = tipoVino;
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

    public String getGraduacion() {
        return graduacion;
    }

    public void setGraduacion(String graduacion) {
        this.graduacion = graduacion;
    }

    public TipoVino getTipoVino() {
        return tipoVino;
    }

    public void setTipoVino(TipoVino tipoVino) {
        this.tipoVino = tipoVino;
    }
}

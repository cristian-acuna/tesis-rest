package somellier.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "uva")
public class Uva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String nombre;

    @NotNull
    private String descripcion;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="cod_tipo")
    private TipoVino tipoVino;

    public Uva() {
    }

    public Uva(int id) {
        this.id = id;
    }

    public Uva(String nombre, String descripcion, TipoVino tipoVino) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public TipoVino getTipoVino() {
        return tipoVino;
    }

    public void setTipoVino(TipoVino tipoVino) {
        this.tipoVino = tipoVino;
    }
}

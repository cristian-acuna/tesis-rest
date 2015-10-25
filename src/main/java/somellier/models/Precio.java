package somellier.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "precio")
public class Precio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private Date fecha;

    @NotNull
    private float precio;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="cod_usuario")
    private Usuario usuario;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="cod_vino")
    private Vino vino;

    public Precio() {
    }

    public Precio(int id) {
        this.id = id;
    }

    public Precio(Date fecha, float precio, Usuario usuario, Vino vino) {
        this.fecha = fecha;
        this.precio = precio;
        this.usuario = usuario;
        this.vino = vino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getComentario() {
        return precio;
    }

    public void setComentario(float precio) {
        this.precio = precio;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vino getVino() {
        return vino;
    }

    public void setVino(Vino vino) {
        this.vino = vino;
    }
}

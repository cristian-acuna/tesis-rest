package somellier.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "puntaje")
public class Puntaje {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private int puntaje;

    @NotNull
    private String fecha;

    @NotNull
    private float precio;

    @NotNull
    private String comentario;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="cod_usuario")
    private Usuario usuario;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="cod_vino")
    private Vino vino;

    public Puntaje() {
    }

    public Puntaje(int id) {
        this.id = id;
    }

    public Puntaje(int puntaje, String fecha, float precio, String comentario, Usuario usuario, Vino vino) {
        this.puntaje = puntaje;
        this.fecha = fecha;
        this.precio = precio;
        this.comentario = comentario;
        this.usuario = usuario;
        this.vino = vino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
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

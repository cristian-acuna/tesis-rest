package somellier.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private Date fecha;

    @NotNull
    private String comentario;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="cod_usuario")
    private Usuario usuario;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="cod_vino")
    private Vino vino;

    public Comentario() {
    }

    public Comentario(int id) {
        this.id = id;
    }

    public Comentario(Date fecha, String comentario, Usuario usuario, Vino vino) {
        this.fecha = fecha;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
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

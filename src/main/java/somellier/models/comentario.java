package somellier.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
@Table(name = "comentario")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @JsonFormat(pattern="dd-MM-yyyy HH:mm", timezone="America/Argentina/Buenos_Aires")
    private Timestamp fecha = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

    @NotNull
    @Column(length=1000)
    private String comentario;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="cod_usuario")
    private Usuario usuario;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="cod_vino")
    private Vino vino;

    public Comentario() {
    }

    public Comentario(int id) {
        this.id = id;
    }

    public Comentario(String comentario, Usuario usuario, Vino vino) {
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

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
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

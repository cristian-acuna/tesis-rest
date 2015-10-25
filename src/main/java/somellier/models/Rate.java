package somellier.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "rate")
public class Rate implements Serializable{

    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private long fecha = System.currentTimeMillis();

    @NotNull
    private float rate;

    @Id
    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="cod_usuario")
    private Usuario usuario;

    @Id
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="cod_vino")
    private Vino vino;

    public Rate() {
    }

    public Rate(int id) {
        this.id = id;
    }

    public Rate(float rate, Usuario usuario, Vino vino) {
        this.fecha = System.currentTimeMillis();
        this.rate = rate;
        this.usuario = usuario;
        this.vino = vino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getFecha() {
        return fecha;
    }

    public void setFecha(long fecha) {
        this.fecha = fecha;
    }

    public float getRate() {
        return rate;
    }

    public void setComentario(float rate) {
        this.rate = rate;
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

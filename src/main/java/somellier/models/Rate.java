package somellier.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
@Table(name = "rate")
public class Rate implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @JsonFormat(pattern="dd-MM-yyyy HH:mm", timezone="America/Argentina/Buenos_Aires")
    private Timestamp fecha = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

    @NotNull
    private float rate;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="cod_usuario")
    private Usuario usuario;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="cod_vino")
    @JsonBackReference
    private Vino vino;

    public Rate() {}

    public Rate(float rate, Usuario usuario, Vino vino) {
        this.rate = rate;
        this.usuario = usuario;
        this.vino = vino;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}

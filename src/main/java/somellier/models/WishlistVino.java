package somellier.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
@Table(name = "wishlist_vino")
public class WishlistVino implements Serializable {

    @Id
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="cod_usuario")
    private Usuario usuario;

    @Id
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="cod_vino")
    private Vino vino;

    @NotNull
    @JsonFormat(pattern="dd-MM-yyyy HH:mm", timezone="America/Argentina/Buenos_Aires")
    private Timestamp fecha = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

    public WishlistVino() {
    }

    public WishlistVino(Usuario usuario, Vino vino) {
        this.usuario = usuario;
        this.vino = vino;
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

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }
}

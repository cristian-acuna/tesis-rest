package somellier.models;

import javax.persistence.*;
import java.io.Serializable;

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
}

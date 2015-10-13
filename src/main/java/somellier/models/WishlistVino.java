package somellier.models;

import javax.persistence.*;

@Entity
@Table(name = "wishlist_vino")
public class WishlistVino {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="cod_usuario")
    private Usuario usuario;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="cod_vino")
    private Vino vino;

    public WishlistVino() {
    }

    public WishlistVino(int id) {
        this.id = id;
    }

    public WishlistVino(Usuario usuario, Vino vino) {
        this.usuario = usuario;
        this.vino = vino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

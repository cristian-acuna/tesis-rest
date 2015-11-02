package somellier.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String nombre;

    @NotNull
    private String apellido;

    @NotNull
    private String email;

    @NotNull
    private String password;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="cod_residencia")
    private Residencia residencia;

/*    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_vino", joinColumns = { @JoinColumn(name = "cod_usuario") }, inverseJoinColumns = { @JoinColumn(name = "cod_vino") })
    private Set<Vino> wishlist = new HashSet<Vino>(0);*/

    @NotNull
    private EstadoUsuario estado = EstadoUsuario.ACTIVO;

    public Usuario() {
    }

    public Usuario(int id) {
        this.id = id;
    }

    public Usuario(String nombre, String apellido, String email, String password, Residencia residencia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.residencia = residencia;
        this.estado = EstadoUsuario.ACTIVO;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Residencia getResidencia() {return residencia;}

    public void setResidencia(Residencia residencia) {
        this.residencia = residencia;
    }

    public EstadoUsuario getEstado() {
        return estado;
    }

    public void setEstado(EstadoUsuario estado) {
        this.estado = estado;
    }
/*
    public Set<Vino> getWishlist() {
        return wishlist;
    }

    public void setWishlist(Set<Vino> wishlist) {
        this.wishlist = wishlist;
    }*/
}

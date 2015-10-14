package somellier.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "uva")
public class Uva {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String nombre;

    @NotNull
    @Column(length=1000)
    private String descripcion;

    public Uva() {
    }

    public Uva(int id) {
        this.id = id;
    }

    public Uva(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}

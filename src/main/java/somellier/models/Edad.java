package somellier.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "edad")
public class Edad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    private String nombre;

    @NotNull
    @Column(length=1000)
    private String descripcion;

    public Edad() {
    }

    public Edad(int id) {
        this.id = id;
    }

    public Edad(String nombre, String descripcion) {
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

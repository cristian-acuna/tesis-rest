package somellier.models;

import javax.persistence.*;

@Entity
@Table(name = "residencia")
public class Residencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String ciudad;
    private int provincia;
    private String pais;

    public Residencia() {
    }

    public Residencia(int id) {
        this.id = id;
    }

    public Residencia(String ciudad, int provincia, String pais) {
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.pais = pais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getProvincia() {
        return provincia;
    }

    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}

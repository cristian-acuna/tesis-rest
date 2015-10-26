package somellier.models;

import javax.persistence.*;

@Entity
@Table(name = "residencia")
public class Residencia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String ciudad;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="cod_provincia")
    private Provincia provincia;

    private String pais;

    public Residencia() {
    }

    public Residencia(int id) {
        this.id = id;
    }

    public Residencia(String ciudad, Provincia provincia, String pais) {
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

    public Provincia getProvincia() {
        return provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}

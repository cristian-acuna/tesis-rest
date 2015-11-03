package somellier.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "precio")
public class Precio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @JsonFormat(pattern="dd-MM-yyyy HH:mm", timezone="America/Argentina/Buenos_Aires")
    private Timestamp fecha = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

    @NotNull
    private float precio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cod_vino", nullable = false)
    private Vino vino;

/*    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name="cod_vino")
    private Vino vino;*/

    public Precio() {
    }

    public Precio(int id) {
        this.id = id;
    }

    public Precio(float precio, Vino vino) {
        this.precio = precio;
        this.vino = vino;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public Vino getVino() {
        return vino;
    }

    public void setVino(Vino vino) {
        this.vino = vino;
    }
}

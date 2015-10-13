package somellier.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



    @Entity
    @Table(name = "vino")
    public class Vino {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        @NotNull
        private String nombre;

        @NotNull
        private String descripcion;

        @NotNull
        private String anio;

        @NotNull
        private float graduacion;

        @ManyToOne(cascade = {CascadeType.ALL})
        @JoinColumn(name="cod_bodega")
        private Bodega bodega;

        @ManyToOne(cascade = {CascadeType.ALL})
        @JoinColumn(name="cod_uva")
        private Uva uva;

        @ManyToOne(cascade = {CascadeType.ALL})
        @JoinColumn(name="cod_edad")
        private Edad edad;

        public Vino() {
        }

        public Vino(int id) {
            this.id = id;
        }

        public Vino(String nombre, String descripcion, String anio, float graduacion, Bodega bodega, Uva uva, Edad edad) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.anio = anio;
            this.graduacion = graduacion;
            this.bodega = bodega;
            this.uva = uva;
            this.edad = edad;
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

        public String getAnio() {
            return anio;
        }

        public void setAnio(String anio) {
            this.anio = anio;
        }

        public Bodega getBodega() {
            return bodega;
        }

        public void setBodega(Bodega bodega) {
            this.bodega = bodega;
        }

        public Uva getUva() {
            return uva;
        }

        public void setUva(Uva uva) {
            this.uva = uva;
        }

        public Edad getEdad() {
            return edad;
        }

        public void setEdad(Edad edad) {
            this.edad = edad;
        }

        public float getGraduacion() {
            return graduacion;
        }

        public void setGraduacion(float graduacion) {
            this.graduacion = graduacion;
        }
    }

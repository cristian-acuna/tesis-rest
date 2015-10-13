package somellier.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

    @Entity
    @Table(name = "bodega")
    public class Bodega {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private int id;

        @NotNull
        private String nombre;

        @NotNull
        private String descripcion;

        @NotNull
        private int anio;

        @NotNull
        private String link;

        @OneToOne(cascade = {CascadeType.ALL})
        @JoinColumn(name="cod_residencia")
        private Residencia residencia;

        public Bodega() {
        }

        public Bodega(int id) {
            this.id = id;
        }

        public Bodega(String nombre, String descripcion, int anio, String link, Residencia residencia) {
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.anio = anio;
            this.link = link;
            this.residencia = residencia;
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

        public int getAnio() {
            return anio;
        }

        public void setAnio(int anio) {
            this.anio = anio;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }

        public Residencia getResidencia() {
            return residencia;
        }

        public void setResidencia(Residencia residencia) {
            this.residencia = residencia;
        }
    }

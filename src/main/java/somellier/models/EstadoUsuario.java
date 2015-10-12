package somellier.models;

public enum EstadoUsuario {
    ACTIVO("activo"),
    INACTIVO("inactivo"),
    EXPULSADO("expulsado");

    private String estado;

    private EstadoUsuario(String estado) {
        estado = estado;
    }

    private String getEstado() {
        return estado;
    }
}

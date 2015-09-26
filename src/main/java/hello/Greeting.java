package hello;

public class Greeting {

    private final long id;
    private final String usuario;
    private final String password;

    public Greeting(long id, String usuario, String password) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }
}

package somellier.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import somellier.models.Provincia;
import somellier.models.Residencia;
import somellier.models.Usuario;
import somellier.models.UsuarioDao;

@Controller
public class LoginController {

    @Autowired
    private UsuarioDao usuarioDao;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public @ResponseBody
    Usuario login(
            @RequestParam(value="email", required=true, defaultValue="user") String email,
            @RequestParam(value="password", required=true, defaultValue="pass") String password)
    {
        System.out.println("LOGED-IN:");
        Usuario usuario = usuarioDao.getByEmail(email);

        return usuario.getPassword().equals(password)? usuario : null;
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.GET)
    public @ResponseBody
    boolean registrar(
            @RequestParam(value="nombre") String nombre,
            @RequestParam(value="apellido") String apellido,
            @RequestParam(value="email") String email,
            @RequestParam(value="password") String password,
            @RequestParam(value="ciudad") String ciudad,
            @RequestParam(value="provincia") String provincia,
            @RequestParam(value="pais") String pais)
    {
        Provincia prov = new Provincia(Integer.parseInt(provincia));
        Residencia residencia = new Residencia(ciudad,prov,pais);
        Usuario usuario = new Usuario(nombre, apellido, email, password, residencia);
        System.out.println("REGISTROOOOO:"+usuario.toString());
        try {
            usuarioDao.create(usuario);
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }
}
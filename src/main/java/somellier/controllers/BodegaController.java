package somellier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import somellier.models.Bodega;
import somellier.models.BodegaDao;
import somellier.models.Provincia;
import somellier.models.Residencia;

import java.util.List;

@RequestMapping(value = "/bodega")
@Controller
public class BodegaController {

    @Autowired
    private BodegaDao bodegaDao;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public @ResponseBody
    List<Bodega> listar()
    {
        List<Bodega> bodegas = bodegaDao.getAll();
        System.out.println("BODEGAS OBTENIDAS!!!!!!!!!!!!!!!!:");

        return bodegas;
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.GET)
    public @ResponseBody
    boolean registrar(
            @RequestParam(value="nombre") String nombre,
            @RequestParam(value="descripcion") String descripcion,
            @RequestParam(value="anio") String anio,
            @RequestParam(value="link") String link,
            @RequestParam(value="ciudad") String ciudad,
            @RequestParam(value="provincia") String provincia,
            @RequestParam(value="pais") String pais)
    {
        Provincia prov = new Provincia(Integer.parseInt(provincia));
        Residencia residencia = new Residencia(ciudad,prov,pais);
        Bodega bodega = new Bodega(nombre, descripcion, Integer.parseInt(anio), link, residencia);
        System.out.println("REGISTROOOOO:"+bodega.toString());
        try {
            bodegaDao.create(bodega);
        }
        catch (Exception ex) {
            return false;
        }
        return true;
    }
}

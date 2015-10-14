package somellier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import somellier.models.*;

import java.util.List;

@RequestMapping(value = "/vino")
@Controller
public class VinoController {

    @Autowired
    private VinoDao vinoDao;

    @Autowired
    private EdadDao edadDao;

    @Autowired
    private UvaDao uvaDao;

    @Autowired
    private TipoVinoDao tipoVinoDao;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public @ResponseBody
    List<Vino> listar()
    {
        List<Vino> vinos = vinoDao.getAll();
        System.out.println("VINOS OBTENIDOS!!!!!!!!!!!!!!!!:");

        return vinos;
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public @ResponseBody
    boolean registrar(@RequestBody Vino vino)
    {
        TipoVino tipo = tipoVinoDao.getById(vino.getTipoVino().getId());
        System.out.println("REGISTROOOOO:"+tipo.getNombre());

        try {
            //vinoDao.create(vino);
        }
        catch (Exception ex) {
            return false;
        }

        return true;
    }

//    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
//    public @ResponseBody
//    boolean registrar(
//            @RequestParam(value="nombre") String nombre,
//            @RequestParam(value="descripcion") String descripcion,
//            @RequestParam(value="cosecha") String cosecha,
//            @RequestParam(value="graduacion") String graduacion,
//            @RequestParam(value="bodega") Bodega bodega,
//            @RequestParam(value="uva") Uva uva,
//            @RequestParam(value="edad") Edad edad,
//            @RequestParam(value="tipo") TipoVino tipoVino
//            )
//    {
//        Vino vino = new Vino(nombre, descripcion, cosecha, Float.parseFloat(graduacion), bodega, uva, tipoVino, edad);
//        System.out.println("REGISTROOOOO:"+vino.toString());
//        try {
//            vinoDao.create(vino);
//        }
//        catch (Exception ex) {
//            return false;
//        }
//
//        return true;
//    }

    @RequestMapping(value = "/edades", method = RequestMethod.GET)
    public @ResponseBody
    List<Edad> listarEdad()
    {
        List<Edad> edades = edadDao.getAll();
        System.out.println("EDADES OBTENIDAS!!!!!!!!!!!!!!!!:");

        return edades;
    }

    @RequestMapping(value = "/uvas", method = RequestMethod.GET)
    public @ResponseBody
    List<Uva> listarUva()
    {
        List<Uva> uvas = uvaDao.getAll();
        System.out.println("UVAS OBTENIDAS!!!!!!!!!!!!!!!!:");

        return uvas;
    }

    @RequestMapping(value = "/tipos", method = RequestMethod.GET)
    public @ResponseBody
    List<TipoVino> listarTipos()
    {
        List<TipoVino> tipos = tipoVinoDao.getAll();
        System.out.println("TIPOS OBTENIDOS!!!!!!!!!!!!!!!!:");

        return tipos;
    }
}


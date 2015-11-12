package somellier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import somellier.models.*;

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

    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public @ResponseBody
    Bodega registrar(@RequestBody Bodega bodega)
    {
        try {
            bodegaDao.create(bodega);
            return bodega;
        }
        catch (Exception ex) {
            return null;
        }
    }
}

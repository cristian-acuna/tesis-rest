package somellier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import somellier.models.*;

import java.util.List;

@RequestMapping(value = "/wishlist")
@Controller
public class WishlistController {

    @Autowired
    private VinoDao vinoDao;

    @Autowired
    private RateDao rateDao;

    @Autowired
    private WishlistVinoDao wishlistDao;

    @Autowired
    private PrecioDao precioDao;

    @Autowired
    private UsuarioDao usuarioDao;


    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public @ResponseBody
    List<Vino> listar(@RequestParam(value="id") int idUsuario)
    {
        List<Vino> vinos = wishlistDao.getByUsuario(idUsuario);

        return vinos;
    }

/*    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public @ResponseBody
    boolean registrar(@RequestBody Vino vino)
    {
        try {
            vinoDao.create(vino);
        }
        catch (Exception ex) {
            System.out.println(ex);
            return false;
        }

        return true;
    }

    @RequestMapping(value = "/wish", method = RequestMethod.POST)
    public @ResponseBody
    boolean wish(@RequestBody WishlistVino wish)
    {
        try {
            if (wishlistDao.getById(wish)==null) {
                wishlistDao.create(wish);
            } else {
                wishlistDao.delete(wish);
            }
        }
        catch (Exception ex) {
            System.out.println(ex);
            return false;
        }

        return true;
    }*/
}


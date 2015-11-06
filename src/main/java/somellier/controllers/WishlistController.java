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
    private WishlistVinoDao wishlistDao;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public @ResponseBody
    List<Vino> listar(@RequestParam(value="id") int idUsuario)
    {
        return wishlistDao.getByUsuario(idUsuario);
    }

    @RequestMapping(value = "/iswish", method = RequestMethod.POST)
    public @ResponseBody
    boolean isWish(@RequestBody WishlistVino wish)
    {
        return wishlistDao.getById(wish) != null;
    }

    @RequestMapping(value = "/wish", method = RequestMethod.POST)
    public @ResponseBody
    List<Vino> wish(@RequestBody WishlistVino wish)
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
            return null;
        }

        return listar(wish.getUsuario().getId());
    }
}


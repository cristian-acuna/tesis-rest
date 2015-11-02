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
    private RateDao rateDao;

    @Autowired
    private WishlistVinoDao wishlistDao;

    @Autowired
    private ComentarioDao comentarioDao;

    @Autowired
    private PrecioDao precioDao;

    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private UvaDao uvaDao;

    @Autowired
    private TipoVinoDao tipoVinoDao;

    @RequestMapping(value = "/listar", method = RequestMethod.GET)
    public @ResponseBody
    List<Vino> listar()
    {
        List<Vino> vinos = vinoDao.getAll();
        System.out.println(vinos.toString());

        return vinos;
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public @ResponseBody
    boolean registrar(@RequestBody Vino vino)
    {
        System.out.println("REGISTROOOOO:");

        try {
            vinoDao.create(vino);
        }
        catch (Exception ex) {
            System.out.println(ex);
            return false;
        }

        return true;
    }

    @RequestMapping(value = "/filtrar", method = RequestMethod.GET)
    public @ResponseBody
    List<Vino> filtrar(
            @RequestParam(value="queryText") String queryText,
            @RequestParam(value="bodega") String bodega,
            @RequestParam(value="edad") String edad,
            @RequestParam(value="uva") String uva,
            @RequestParam(value="tipo") String tipo)
    {
        System.out.println("PARAMETROSSSSSSSSSSSSSSSSSSSSSS:"+queryText+bodega+edad+uva+tipo);
        List<Vino> vinos = vinoDao.getByCriteria(queryText, bodega, edad, uva, tipo);

        return vinos;
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
/*        try {
        Usuario usuario = usuarioDao.getById(wish.getUsuario().getId());
            System.out.println("USUARIO:::::::::::::::::"+wish.getUsuario().getId()+"VINO::::::::"+wish.getVino().getId());
        usuario.getWishlist().add(wish.getVino());
            System.out.println("USUARIO TRAIDO:::::::::::::::::" + usuario.getNombre());
        //usuarioDao.update(usuario);
    }
    catch (Exception ex) {
        System.out.println(ex);
        return false;
    }
        return true;*/
    }

    @RequestMapping(value = "/rate", method = RequestMethod.POST)
         public @ResponseBody
         boolean rate(@RequestBody Rate rate)
    {
        System.out.println("RATEEEEEEEDDDDDDD!!!!!:");
        try {
            rateDao.create(rate);
        }
        catch (Exception ex) {
            System.out.println(ex);
            return false;
        }

        return true;
    }

    @RequestMapping(value = "/comentar", method = RequestMethod.POST)
    public @ResponseBody
    List<Comentario> comentar(@RequestBody Comentario comentario)
    {
        Comentario comentarioFull;
        try {
            comentarioDao.create(comentario);
        }
        catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

        return comentarioDao.getByVino(comentario.getVino().getId());
    }

    @RequestMapping(value = "/descomentar", method = RequestMethod.GET)
    public @ResponseBody
    List<Comentario> descomentar(@RequestParam(value="id") int id,
                                 @RequestParam(value="idVino") int idVino)
    {
        try {
            comentarioDao.delete(id);
        }
        catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

        return comentarioDao.getByVino(idVino);
    }

    @RequestMapping(value = "/comentarios", method = RequestMethod.GET)
    public @ResponseBody
    List<Comentario> getComentarios(@RequestParam(value="id") int id)
    {
        System.out.println("GETTING COMMENTARIOS!!!!!:");
        System.out.println(id);

        return comentarioDao.getByVino(id);
    }

    @RequestMapping(value = "/valorar", method = RequestMethod.POST)
    public @ResponseBody
    boolean valorar(@RequestBody Precio precio)
    {
        System.out.println("VALORADOOOOOOOOOOOOOO!!!!!:");

        try {
            precioDao.create(precio);
        }
        catch (Exception ex) {
            System.out.println(ex);
            return false;
        }

        return true;
    }


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


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

        return vinos;
    }

    @RequestMapping(value = "/registrar", method = RequestMethod.POST)
    public @ResponseBody
    Vino registrar(@RequestBody Vino vino)
    {
        try {
            System.out.println("LLEGA A REGISTRAR!!!!!!!!!!!!!!!!");
            vinoDao.create(vino);
            System.out.println(vino.getImagen());
        }
        catch (Exception ex) {
            System.out.println(ex);
            return null;
        }

        return vino;
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
        List<Vino> vinos = vinoDao.getByCriteria(queryText, bodega, edad, uva, tipo);

        return vinos;
    }

    @RequestMapping(value = "/rate", method = RequestMethod.POST)
         public @ResponseBody
         boolean rate(@RequestBody Rate rate)
    {
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

    @RequestMapping(value = "/precio", method = RequestMethod.GET)
    public @ResponseBody
    String getCostoPromedio(@RequestParam(value="id") int id)
    {
        List<Precio> precios = precioDao.getByVino(id);
        float sumatoria = 0;

        for (Precio precio : precios) {
            sumatoria += precio.getPrecio();
        }
        float promedio = sumatoria/precios.size();

        return promedio >= 0 ? String.format("%.2f", promedio) : "0";
    }

    @RequestMapping(value = "/rating", method = RequestMethod.GET)
    public @ResponseBody
    float getRatingPromedio(@RequestParam(value="id") int id)
    {
        List<Rate> rates = rateDao.getByVino(id);
        float sumatoria = 0;

        for (Rate rate : rates) {
            sumatoria += rate.getRate();
        }
        float promedio = sumatoria/rates.size();

        return promedio >= 0 ? promedio : 0;
    }

    @RequestMapping(value = "/valorar", method = RequestMethod.POST)
    public @ResponseBody
    boolean valorar(@RequestBody Precio precio)
    {
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


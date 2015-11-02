package somellier.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class WishlistVinoDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void create(WishlistVino wishlistVino) {
        getSession().saveOrUpdate(wishlistVino);
    }

    public void delete(WishlistVino wish) {
        getSession().createQuery(
                "delete from WishlistVino where usuario.id = :idUsuario and vino.id = :idVino")
                .setParameter("idUsuario", wish.getUsuario().getId())
                .setParameter("idVino", wish.getVino().getId())
                .executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<WishlistVino> getAll() {
        return getSession().createQuery("from WishlistVino").list();
    }

    @SuppressWarnings("unchecked")
    public List<WishlistVino> getByUsuario(int id) {
        return getSession().createQuery(
                "from WishlistVino where usuario.id = :id order by fecha desc")
                .setParameter("id", id)
                .list();
    }

    public WishlistVino getById(WishlistVino wish) {
        return (WishlistVino) getSession().get(WishlistVino.class, wish);
    }

    public void update(WishlistVino wishlistVino) {
        getSession().merge(wishlistVino);
    }
}

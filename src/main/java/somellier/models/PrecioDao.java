package somellier.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PrecioDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void create(Precio precio) {
        getSession().saveOrUpdate(precio);
    }

    public void delete(int id) {
        getSession().createQuery(
                "delete from Precio where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Precio> getAll() {
        return getSession().createQuery("from Precio").list();
    }

    @SuppressWarnings("unchecked")
    public List<Precio> getByVino(int id) {
        return getSession().createQuery(
                "from Precio where vino.id = :id")
                .setParameter("id", id)
                .list();
    }

    public Precio getById(int id) {
        return (Precio) getSession().load(Precio.class, id);
    }

    public void update(Precio precio) {
        getSession().merge(precio);
    }
}


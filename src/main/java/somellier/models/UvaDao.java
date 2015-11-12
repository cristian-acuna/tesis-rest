package somellier.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UvaDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void create(Uva uva) {
        getSession().saveOrUpdate(uva);
    }

    public void delete(Uva uva) {
        getSession().delete(uva);
    }

    @SuppressWarnings("unchecked")
    public List<Uva> getAll() {
        return getSession().createQuery("from Uva").list();
    }

    public Uva getByNombre(String nombre) {
        return (Uva) getSession().createQuery(
                "from Uva where nombre = :nombre")
                .setParameter("nombre", nombre)
                .uniqueResult();
    }

    public Uva getById(int id) {
        return (Uva) getSession().load(Uva.class, id);
    }

    public void update(Uva uva) {
        getSession().merge(uva);
    }
}


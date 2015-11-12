package somellier.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProvinciaDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void create(Provincia provincia) {
        getSession().saveOrUpdate(provincia);
    }

    @SuppressWarnings("unchecked")
    public List<Provincia> getAll() {
        return getSession().createQuery("from Provincia").list();
    }

    public Provincia getById(int id) {
        return (Provincia) getSession().load(Provincia.class, id);
    }

    public void update(Provincia provincia) {
        getSession().merge(provincia);
    }
}

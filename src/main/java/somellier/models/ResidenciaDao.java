package somellier.models;

import java.util.List;
import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ResidenciaDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void create(Residencia residencia) {
        getSession().saveOrUpdate(residencia);
    }

    public void delete(Residencia residencia) {
        getSession().delete(residencia);
    }

    @SuppressWarnings("unchecked")
    public List<Residencia> getAll() {
        return getSession().createQuery("from Residencia").list();
    }

    public Residencia getByCiudad(String ciudad) {
        return (Residencia) getSession().createQuery(
                "from Residencia where ciudad = :ciudad")
                .setParameter("ciudad", ciudad)
                .uniqueResult();
    }

    public Residencia getById(int id) {
        return (Residencia) getSession().load(Residencia.class, id);
    }

    public void update(Residencia residencia) {
        getSession().merge(residencia);
    }
}

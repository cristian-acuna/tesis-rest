package somellier.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EdadDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public int create(Edad edad) {
        Integer id = (Integer) getSession().save(edad);

        return id.intValue();
    }

    public void delete(Edad edad) {
        getSession().delete(edad);
    }

    @SuppressWarnings("unchecked")
    public List<Edad> getAll() {
        return getSession().createQuery("from Edad").list();
    }

    public Edad getByNombre(String nombre) {
        return (Edad) getSession().createQuery(
                "from Edad where nombre = :nombre")
                .setParameter("nombre", nombre)
                .uniqueResult();
    }

    public Edad getById(int id) {
        return (Edad) getSession().load(Edad.class, id);
    }

    public void update(Edad edad) { getSession().merge(edad); }
}


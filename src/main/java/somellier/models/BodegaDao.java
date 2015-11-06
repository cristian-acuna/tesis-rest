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
public class BodegaDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void create(Bodega bodega) {
        int idBodega = (int) getSession().save(bodega);
        System.out.println("DEVUELVE:"+idBodega);
/*
        return (Bodega) getSession().load(Bodega.class, idBodega);
*/
    }

    public void delete(Bodega bodega) {
        getSession().delete(bodega);
    }

    @SuppressWarnings("unchecked")
    public List<Bodega> getAll() {
        return getSession().createQuery("from Bodega").list();
    }

    public Bodega getByNombre(String nombre) {
        return (Bodega) getSession().createQuery(
                "from Bodega where nombre = :nombre")
                .setParameter("nombre", nombre)
                .uniqueResult();
    }

    public Bodega getById(int id) {
        return (Bodega) getSession().load(Bodega.class, id);
    }

    public void update(Bodega bodega) {
        getSession().merge(bodega);
    }
} // class BodegaDao


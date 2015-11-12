package somellier.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TipoVinoDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void create(TipoVino tipoVino) {
        getSession().saveOrUpdate(tipoVino);
    }

    public void delete(TipoVino tipoVino) {
        getSession().delete(tipoVino);
    }

    @SuppressWarnings("unchecked")
    public List<TipoVino> getAll() {
        return getSession().createQuery("from TipoVino").list();
    }

    public TipoVino getByNombre(String nombre) {
        return (TipoVino) getSession().createQuery(
                "from TipoVino where nombre = :nombre")
                .setParameter("nombre", nombre)
                .uniqueResult();
    }

    public TipoVino getById(int id) {
        return (TipoVino) getSession().load(TipoVino.class, id);
    }

    public void update(TipoVino tipoVino) {
        getSession().merge(tipoVino);
    }
}

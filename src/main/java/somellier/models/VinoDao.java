package somellier.models;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class VinoDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void create(Vino vino) {
        getSession().saveOrUpdate(vino);
    }

    public void delete(Vino vino) {
        getSession().delete(vino);

    }

    @SuppressWarnings("unchecked")
    public List<Vino> getByCriteria(String queryText, String bodega, String edad, String uva, String tipo) {
        Criteria criteria = getSession().createCriteria(Vino.class);
        criteria.createAlias("bodega", "b");
        criteria.createAlias("edad", "e");
        criteria.createAlias("uva", "u");
        criteria.createAlias("tipoVino", "t");
        if (!queryText.equals("")) {
            criteria.add(Restrictions.ilike("nombre", queryText, MatchMode.ANYWHERE));
        }
        if (!bodega.equals("")) {
            criteria.add(Restrictions.eq("b.nombre", bodega));
        }
        if (!edad.equals("")) {
            criteria.add(Restrictions.eq("e.nombre", edad));
        }
        if (!uva.equals("")) {
            criteria.add(Restrictions.eq("u.nombre", uva));
        }
        if (!tipo.equals("")) {
            criteria.add(Restrictions.eq("t.nombre", tipo));
        }

        return criteria.list();
    }

    @SuppressWarnings("unchecked")
    public List<Vino> getAll() {
        return getSession().createQuery("from Vino").list();
    }

    public Vino getByNombre(String nombre) {
        return (Vino) getSession().createQuery(
                "from Vino where nombre = :nombre")
                .setParameter("nombre", nombre)
                .uniqueResult();
    }

    public Vino getById(int id) {
        return (Vino) getSession().load(Vino.class, id);
    }

    public void update(Vino vino) {
        getSession().merge(vino);
    }
} // class UserDao

package somellier.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RateDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void create(Rate rate) {
        Vino vino = (Vino) getSession().load(Vino.class, rate.getVino().getId());
        vino.getRates().add(rate);
        getSession().saveOrUpdate(vino);
    }

    public void delete(Rate rate) {
    getSession().delete(rate);
    }

    @SuppressWarnings("unchecked")
    public List<Rate> getAll() {
        return getSession().createQuery("from Rate").list();
    }

    @SuppressWarnings("unchecked")
    public List<Rate> getByVino(int id) {
        return getSession().createQuery(
                "from Rate where vino.id = :id")
                .setParameter("id", id)
                .list();
    }

    @SuppressWarnings("unchecked")
    public Rate getByVinoAndUsuario(Rate rate) {
        return (Rate) getSession().createQuery(
                "from Rate where vino.id = :idVino AND usuario.id = :idUsuario")
                .setParameter("idVino", rate.getVino().getId())
                .setParameter("idUsuario", rate.getUsuario().getId())
                .uniqueResult();
/*
        return (Rate) getSession().load(Rate.class, id);
*/
    }

    public void update(Rate rate) {
        getSession().merge(rate);
    }
} // class RateDao


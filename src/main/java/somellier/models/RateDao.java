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
        getSession().saveOrUpdate(rate);
    }

    public void delete(Rate rate) {
    getSession().delete(rate);
    }

    @SuppressWarnings("unchecked")
    public List<Rate> getAll() {
        return getSession().createQuery("from Rate").list();
    }

    public Rate getByVino(Usuario vino) {
        return (Rate) getSession().createQuery(
                "from Rate where vino.id = :id")
                .setParameter("id", vino.getId())
                .uniqueResult();
    }

    public Rate getById(int id) {
        return (Rate) getSession().load(Rate.class, id);
    }

    public void update(Rate rate) {
        getSession().merge(rate);
    }
} // class RateDao


package somellier.models;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ComentarioDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public int create(Comentario comentario) {
        Integer id = (Integer) getSession().save(comentario);

        return id.intValue();
    }

    public void delete(int id) {
        getSession().createQuery(
                "delete from Comentario where id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public List<Comentario> getAll() {
        return getSession().createQuery("from Comentario").list();
    }

    @SuppressWarnings("unchecked")
    public List<Comentario> getByVino(int id) {
        return getSession().createQuery(
                "from Comentario where vino.id = :id order by fecha desc")
                .setParameter("id", id)
                .list();
    }

    public Comentario getById(int id) {
        return (Comentario) getSession().get(Comentario.class, id);
    }

    public void update(Comentario comentario) {
        getSession().merge(comentario);
    }
}


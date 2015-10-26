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
public class UsuarioDao {

    @Autowired
    private SessionFactory _sessionFactory;

    private Session getSession() {
        return _sessionFactory.getCurrentSession();
    }

    public void create(Usuario usuario) {
        getSession().saveOrUpdate(usuario);
        return;
    }

    public void delete(Usuario usuario) {
        getSession().delete(usuario);

        return;
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> getAll() {
        return getSession().createQuery("from Usuario").list();
    }

    public Usuario getByEmail(String email) {
        return (Usuario) getSession().createQuery(
                "from Usuario where email = :email")
                .setParameter("email", email)
                .uniqueResult();
    }

    public Usuario getById(int id) {
        return (Usuario) getSession().load(Usuario.class, id);
    }

    public void update(Usuario usuario) {
        getSession().update(usuario);
        return;
    }
} // class UserDao
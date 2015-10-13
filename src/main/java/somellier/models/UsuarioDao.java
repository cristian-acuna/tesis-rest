package somellier.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UsuarioDao {

    public void create(Usuario usuario) {
        entityManager.persist(usuario);
        return;
    }

    public void delete(Usuario usuario) {
        if (entityManager.contains(usuario))
            entityManager.remove(usuario);
        else
            entityManager.remove(entityManager.merge(usuario));
        return;
    }

    @SuppressWarnings("unchecked")
    public List<Usuario> getAll() {
        return entityManager.createQuery("from Usuario").getResultList();
    }

    public Usuario getByEmail(String email) {
        return (Usuario) entityManager.createQuery(
                "from Usuario where email = :email")
                .setParameter("email", email)
                .getSingleResult();
    }

    public Usuario getById(int id) {
        return entityManager.find(Usuario.class, id);
    }

    public void update(Usuario usuario) {
        entityManager.merge(usuario);
        return;
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;

} // class UserDao
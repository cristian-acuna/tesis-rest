package somellier.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

/**
 * This class is used to access data for the User entity.
 * Repository annotation allows the component scanning support to find and
 * configure the DAO wihtout any XML configuration and also provide the Spring
 * exceptiom translation.
 * Since we've setup setPackagesToScan and transaction manager on
 * DatabaseConfig, any bean method annotated with Transactional will cause
 * Spring to magically call begin() and commit() at the start/end of the
 * method. If exception occurs it will also call rollback().
 */
@Repository
@Transactional
public class UsuarioDao {

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    /**
     * Save the user in the database.
     */
    public void create(Usuario usuario) {
        entityManager.persist(usuario);
        return;
    }

    /**
     * Delete the user from the database.
     */
    public void delete(Usuario usuario) {
        if (entityManager.contains(usuario))
            entityManager.remove(usuario);
        else
            entityManager.remove(entityManager.merge(usuario));
        return;
    }

    /**
     * Return all the users stored in the database.
     */
    @SuppressWarnings("unchecked")
    public List<Usuario> getAll() {
        return entityManager.createQuery("from Usuario").getResultList();
    }

    /**
     * Return the user having the passed email.
     */
    public Usuario getByEmail(String email) {
        return (Usuario) entityManager.createQuery(
                "from Usuario where email = :email")
                .setParameter("email", email)
                .getSingleResult();
    }

    /**
     * Return the user having the passed id.
     */
    public Usuario getById(int id) {
        return entityManager.find(Usuario.class, id);
    }

    /**
     * Update the passed user in the database.
     */
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
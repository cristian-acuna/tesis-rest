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
public class ResidenciaDao {

    // ------------------------
    // PUBLIC METHODS
    // ------------------------

    /**
     * Save the residencia in the database.
     */
    public void create(Residencia residencia) {
        entityManager.persist(residencia);
        return;
    }

    /**
     * Delete the residencia from the database.
     */
    public void delete(Residencia residencia) {
        if (entityManager.contains(residencia))
            entityManager.remove(residencia);
        else
            entityManager.remove(entityManager.merge(residencia));
        return;
    }

    /**
     * Return all the residencias stored in the database.
     */
    @SuppressWarnings("unchecked")
    public List<Residencia> getAll() {
        return entityManager.createQuery("from Residencia").getResultList();
    }

    /**
     * Return the residencia having the passed email.
     */
    public Residencia getByEmail(String email) {
        return (Residencia) entityManager.createQuery(
                "from Residencia where email = :email")
                .setParameter("email", email)
                .getSingleResult();
    }

    /**
     * Return the residencia having the passed id.
     */
    public Residencia getById(long id) {
        return entityManager.find(Residencia.class, id);
    }

    /**
     * Update the passed residencia in the database.
     */
    public void update(Residencia residencia) {
        entityManager.merge(residencia);
        return;
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;

} // class ResidenciaDao

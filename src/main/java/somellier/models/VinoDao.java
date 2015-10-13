package somellier.models;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class VinoDao {

    public void create(Vino usuario) {
        entityManager.persist(usuario);
        return;
    }

    public void delete(Vino vino) {
        if (entityManager.contains(vino))
            entityManager.remove(vino);
        else
            entityManager.remove(entityManager.merge(vino));
        return;
    }

    @SuppressWarnings("unchecked")
    public List<Vino> getAll() {
        return entityManager.createQuery("from Vino").getResultList();
    }

    public Vino getByNombre(String nombre) {
        return (Vino) entityManager.createQuery(
                "from Vino where nombre = :nombre")
                .setParameter("nombre", nombre)
                .getSingleResult();
    }

    public Vino getById(int id) {
        return entityManager.find(Vino.class, id);
    }

    public void update(Vino vino) {
        entityManager.merge(vino);
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

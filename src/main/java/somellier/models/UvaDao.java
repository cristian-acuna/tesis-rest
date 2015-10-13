package somellier.models;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class UvaDao {

    public void create(Uva uva) {
        entityManager.persist(uva);
        return;
    }

    public void delete(Uva uva) {
        if (entityManager.contains(uva))
            entityManager.remove(uva);
        else
            entityManager.remove(entityManager.merge(uva));
        return;
    }

    @SuppressWarnings("unchecked")
    public List<Uva> getAll() {
        return entityManager.createQuery("from Uva").getResultList();
    }

    public Uva getByNombre(String nombre) {
        return (Uva) entityManager.createQuery(
                "from Uva where nombre = :nombre")
                .setParameter("nombre", nombre)
                .getSingleResult();
    }

    public Uva getById(int id) {
        return entityManager.find(Uva.class, id);
    }

    public void update(Uva uva) {
        entityManager.merge(uva);
        return;
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;

} // class UvaDao


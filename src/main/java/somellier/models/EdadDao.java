package somellier.models;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EdadDao {

    public void create(Edad edad) {
        entityManager.persist(edad);
        return;
    }

    public void delete(Edad edad) {
        if (entityManager.contains(edad))
            entityManager.remove(edad);
        else
            entityManager.remove(entityManager.merge(edad));
        return;
    }

    @SuppressWarnings("unchecked")
    public List<Edad> getAll() {
        return entityManager.createQuery("from Edad").getResultList();
    }

    public Edad getByNombre(String nombre) {
        return (Edad) entityManager.createQuery(
                "from Edad where nombre = :nombre")
                .setParameter("nombre", nombre)
                .getSingleResult();
    }

    public Edad getById(int id) {
        return entityManager.find(Edad.class, id);
    }

    public void update(Edad edad) {
        entityManager.merge(edad);
        return;
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;

} // class EdadDao


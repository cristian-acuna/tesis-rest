package somellier.models;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BodegaDao {

    public void create(Bodega bodega) {
        entityManager.persist(bodega);
        return;
    }

    public void delete(Bodega bodega) {
        if (entityManager.contains(bodega))
            entityManager.remove(bodega);
        else
            entityManager.remove(entityManager.merge(bodega));
        return;
    }

    @SuppressWarnings("unchecked")
    public List<Bodega> getAll() {
        return entityManager.createQuery("from Bodega").getResultList();
    }

    public Bodega getByNombre(String nombre) {
        return (Bodega) entityManager.createQuery(
                "from Bodega where nombre = :nombre")
                .setParameter("nombre", nombre)
                .getSingleResult();
    }

    public Bodega getById(int id) {
        return entityManager.find(Bodega.class, id);
    }

    public void update(Bodega bodega) {
        entityManager.merge(bodega);
        return;
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;

} // class BodegaDao


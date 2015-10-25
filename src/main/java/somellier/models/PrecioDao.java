package somellier.models;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PrecioDao {

    public void create(Precio precio) {
        entityManager.persist(precio);
        return;
    }

    public void delete(Precio precio) {
        if (entityManager.contains(precio))
            entityManager.remove(precio);
        else
            entityManager.remove(entityManager.merge(precio));
        return;
    }

    @SuppressWarnings("unchecked")
    public List<Precio> getAll() {
        return entityManager.createQuery("from Precio").getResultList();
    }

    public Precio getByVino(Usuario vino) {
        return (Precio) entityManager.createQuery(
                "from Precio where vino.id = :id")
                .setParameter("id", vino.getId())
                .getSingleResult();
    }

    public Precio getById(int id) {
        return entityManager.find(Precio.class, id);
    }

    public void update(Precio precio) {
        entityManager.merge(precio);
        return;
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;

} // class PrecioDao


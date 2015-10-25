package somellier.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ProvinciaDao {

    public void create(Provincia provincia) {
        entityManager.persist(provincia);
        return;
    }

    public void delete(Provincia provincia) {
        if (entityManager.contains(provincia))
            entityManager.remove(provincia);
        else
            entityManager.remove(entityManager.merge(provincia));
        return;
    }

    @SuppressWarnings("unchecked")
    public List<Provincia> getAll() {
        return entityManager.createQuery("from Provincia").getResultList();
    }

    public Provincia getByDescripcion(String descripcion) {
        return (Provincia) entityManager.createQuery(
                "from Provincia where descripcion = :descripcion")
                .setParameter("descripcion", descripcion)
                .getSingleResult();
    }

    public Provincia getById(int id) {
        return entityManager.find(Provincia.class, id);
    }

    public void update(Provincia provincia) {
        entityManager.merge(provincia);
        return;
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;

} // class ProvinciaDao

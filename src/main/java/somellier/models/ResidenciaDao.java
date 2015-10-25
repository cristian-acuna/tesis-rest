package somellier.models;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class ResidenciaDao {

    public void create(Residencia residencia) {
        entityManager.persist(residencia);
        return;
    }

    public void delete(Residencia residencia) {
        if (entityManager.contains(residencia))
            entityManager.remove(residencia);
        else
            entityManager.remove(entityManager.merge(residencia));
        return;
    }

    @SuppressWarnings("unchecked")
    public List<Residencia> getAll() {
        return entityManager.createQuery("from Residencia").getResultList();
    }

    public Residencia getByCiudad(String ciudad) {
        return (Residencia) entityManager.createQuery(
                "from Residencia where ciudad = :ciudad")
                .setParameter("ciudad", ciudad)
                .getSingleResult();
    }

    public Residencia getById(int id) {
        return entityManager.find(Residencia.class, id);
    }

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

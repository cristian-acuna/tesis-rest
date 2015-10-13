package somellier.models;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class TipoVinoDao {

    public void create(TipoVino tipoVino) {
        entityManager.persist(tipoVino);
        return;
    }

    public void delete(TipoVino tipoVino) {
        if (entityManager.contains(tipoVino))
            entityManager.remove(tipoVino);
        else
            entityManager.remove(entityManager.merge(tipoVino));
        return;
    }

    @SuppressWarnings("unchecked")
    public List<TipoVino> getAll() {
        return entityManager.createQuery("from TipoVino").getResultList();
    }

    public TipoVino getByNombre(String nombre) {
        return (TipoVino) entityManager.createQuery(
                "from TipoVino where nombre = :nombre")
                .setParameter("nombre", nombre)
                .getSingleResult();
    }

    public TipoVino getById(int id) {
        return entityManager.find(TipoVino.class, id);
    }

    public void update(TipoVino tipoVino) {
        entityManager.merge(tipoVino);
        return;
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;

} // class TipoVinoDao

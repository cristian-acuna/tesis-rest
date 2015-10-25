package somellier.models;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class RateDao {

    public void create(Rate rate) {
        entityManager.persist(rate);
        return;
    }

    public void delete(Rate rate) {
        if (entityManager.contains(rate))
            entityManager.remove(rate);
        else
            entityManager.remove(entityManager.merge(rate));
        return;
    }

    @SuppressWarnings("unchecked")
    public List<Rate> getAll() {
        return entityManager.createQuery("from Rate").getResultList();
    }

    public Rate getByVino(Usuario vino) {
        return (Rate) entityManager.createQuery(
                "from Rate where vino.id = :id")
                .setParameter("id", vino.getId())
                .getSingleResult();
    }

    public Rate getById(int id) {
        return entityManager.find(Rate.class, id);
    }

    public void update(Rate rate) {
        entityManager.merge(rate);
        return;
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;

} // class RateDao


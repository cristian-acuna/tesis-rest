package somellier.models;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class ComentarioDao {

    public void create(Comentario comentario) {
        entityManager.persist(comentario);
        return;
    }

    public void delete(Comentario comentario) {
        if (entityManager.contains(comentario))
            entityManager.remove(comentario);
        else
            entityManager.remove(entityManager.merge(comentario));
        return;
    }

    @SuppressWarnings("unchecked")
    public List<Comentario> getAll() {
        return entityManager.createQuery("from Comentario").getResultList();
    }

    public Comentario getByVino(Usuario vino) {
        return (Comentario) entityManager.createQuery(
                "from Comentario where vino.id = :id")
                .setParameter("id", vino.getId())
                .getSingleResult();
    }

    public Comentario getById(int id) {
        return entityManager.find(Comentario.class, id);
    }

    public void update(Comentario comentario) {
        entityManager.merge(comentario);
        return;
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;

} // class ComentarioDao


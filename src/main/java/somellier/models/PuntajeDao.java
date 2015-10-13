package somellier.models;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class PuntajeDao {

    public void create(Puntaje puntaje) {
        entityManager.persist(puntaje);
        return;
    }

    public void delete(Puntaje puntaje) {
        if (entityManager.contains(puntaje))
            entityManager.remove(puntaje);
        else
            entityManager.remove(entityManager.merge(puntaje));
        return;
    }

    @SuppressWarnings("unchecked")
    public List<Puntaje> getAll() {
        return entityManager.createQuery("from Puntaje").getResultList();
    }

    public Puntaje getByUsuario(Usuario usuario) {
        return (Puntaje) entityManager.createQuery(
                "from Puntaje where usuario = :usuario")
                .setParameter("usuario", usuario)
                .getSingleResult();
    }

    public Puntaje getById(int id) {
        return entityManager.find(Puntaje.class, id);
    }

    public void update(Puntaje puntaje) {
        entityManager.merge(puntaje);
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
package somellier.models;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class WishlistVinoDao {

    public void create(WishlistVino wishlistVino) {
        entityManager.persist(wishlistVino);
        return;
    }

    public void delete(WishlistVino wishlistVino) {
        if (entityManager.contains(wishlistVino))
            entityManager.remove(wishlistVino);
        else
            entityManager.remove(entityManager.merge(wishlistVino));
        return;
    }

    @SuppressWarnings("unchecked")
    public List<WishlistVino> getAll() {
        return entityManager.createQuery("from WishlistVino").getResultList();
    }

    public WishlistVino getByUsuario(Usuario usuario) {
        return (WishlistVino) entityManager.createQuery(
                "from WishlistVino where usuario = :usuario")
                .setParameter("usuario", usuario)
                .getSingleResult();
    }

    public WishlistVino getById(int id) {
        return entityManager.find(WishlistVino.class, id);
    }

    public void update(WishlistVino wishlistVino) {
        entityManager.merge(wishlistVino);
        return;
    }

    // ------------------------
    // PRIVATE FIELDS
    // ------------------------

    // An EntityManager will be automatically injected from entityManagerFactory
    // setup on DatabaseConfig class.
    @PersistenceContext
    private EntityManager entityManager;

} // class WishlistVinoDao

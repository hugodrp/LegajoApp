package legajoSIS.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import legajoSIS.models.Menu;

/**
 *
 * @author usuario
 */
@Stateless
public class MenuDAO extends AbstractDAO<Menu> {

    @PersistenceContext(unitName = "legajoSISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuDAO() {
        super(Menu.class);
    }

    public List<Menu> findAllOrderMenu() {
        try {
            Query query = em.createNamedQuery("Menu.findAllOrderMenu");
            return (List<Menu>) query.getResultList();
        } catch (Exception e) {
            return null;
        }
    }
/*
    public Menu findByAction(String action) {
        try {
            Query query = em.createNamedQuery("Menu.findByAction");
            query.setParameter("action", action);
            return (Menu) query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
*/
}

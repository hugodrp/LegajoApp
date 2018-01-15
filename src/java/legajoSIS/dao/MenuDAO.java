package legajoSIS.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    
}

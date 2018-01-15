package legajoSIS.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import legajoSIS.models.Menu;
import legajoSIS.models.MenuTipousuario;
import legajoSIS.models.Tipousuario;

/**
 *
 * @author usuario
 */
@Stateless
public class MenuTipousuarioDAO extends AbstractDAO<MenuTipousuario> {

    @PersistenceContext(unitName = "legajoSISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuTipousuarioDAO() {
        super(MenuTipousuario.class);
    }

    public Boolean findByMenuAndTipousuario(Menu menu, Tipousuario tipo) {
        try {
            Query query = em.createNamedQuery("MenuTipousuario.findByMenuAndTipousuario");
            query.setParameter("menu", menu);
            query.setParameter("tipo", tipo);
            query.getSingleResult();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

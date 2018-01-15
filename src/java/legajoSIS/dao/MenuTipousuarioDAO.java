package legajoSIS.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import legajoSIS.models.MenuTipousuario;

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
    
}

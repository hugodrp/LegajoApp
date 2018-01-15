package legajoSIS.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import legajoSIS.models.Tipousuario;

/**
 *
 * @author usuario
 */
@Stateless
public class TipousuarioDAO extends AbstractDAO<Tipousuario> {

    @PersistenceContext(unitName = "legajoSISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipousuarioDAO() {
        super(Tipousuario.class);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class MenuTipousuarioFacade extends AbstractDAO<MenuTipousuario> {

    @PersistenceContext(unitName = "legajoSISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MenuTipousuarioFacade() {
        super(MenuTipousuario.class);
    }
    
}

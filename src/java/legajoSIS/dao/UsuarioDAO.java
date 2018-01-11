/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legajoSIS.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import legajoSIS.models.Usuario;

/**
 *
 * @author usuario
 */
@Stateless
public class UsuarioDAO extends AbstractDAO<Usuario> {

    @PersistenceContext(unitName = "legajoSISPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioDAO() {
        super(Usuario.class);
    }
    
}

package legajoSIS.controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import legajoSIS.dao.TipousuarioDAO;
import legajoSIS.models.Tipousuario;

/**
 *
 * @author usuario
 */
@Named(value = "tipousuarioController")
@SessionScoped
public class TipousuarioController implements Serializable {

    @EJB
    TipousuarioDAO dao = new TipousuarioDAO();

    private Tipousuario selected;

    public TipousuarioController() {
    }

    public Tipousuario getSelected() {
        if (selected == null) {
            selected = new Tipousuario();
        }
        return selected;
    }

    public String index() {
        return "/tipousuario/index";
    }

    public List<Tipousuario> listado() {
        return dao.findAll();
    }

    public String create() {
        selected = new Tipousuario();
        return "/tipousuario/new";
    }

    public String agregar() {
        Date d = new Date();
        selected.setCreated(d);
        selected.setUpdated(d);
        dao.create(selected);
        return "/tipousuario/index";
    }

    public String edit(int codigo) {
        selected = dao.find(codigo);
        return "/tipousuario/edit";
    }

    public String guardar() {
        Date d = new Date();
        selected.setUpdated(d);
        dao.edit(selected);
        return "/tipousuario/index";
    }

    public String eliminar(int codigo) {
        selected = dao.find(codigo);
        try {
            dao.remove(selected);
        } catch (Exception e) {
            SessionUtil.addErrorMessage("No se puede eliminar, posibles datos asociados");
        }
        return "/tipousuario/index";
    }

}

package legajoSIS.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.validation.constraints.Size;
import legajoSIS.dao.MenuDAO;
import legajoSIS.dao.MenuTipousuarioDAO;
import legajoSIS.dao.TipousuarioDAO;
import legajoSIS.dao.UsuarioDAO;
import legajoSIS.models.Menu;
import legajoSIS.models.Tipousuario;
import legajoSIS.models.Usuario;

/**
 *
 * @author usuario
 */
@Named(value = "homeController")
@SessionScoped
public class HomeController implements Serializable {

    @EJB
    private UsuarioDAO dao;
    @EJB
    private MenuDAO daoMenu;
    @EJB
    private TipousuarioDAO daoTU;
    @EJB
    private MenuTipousuarioDAO daoMTU;

    @Size(min = 1, message = "Debe ingresar un usuario")
    private String usuario;

    @Size(min = 1, message = "Debe ingresar la clave")
    private String clave;

    @Size(min = 1, message = "Debe ingresar la clave actual")
    private String claveAct;

    @Size(min = 1, message = "Debe ingresar la clave nueva")
    private String claveNew;

    @Size(min = 1, message = "Debe repetir la nueva clave")
    private String claveRep;

    // --------------------- Constructor de la clase ---------------------
    public HomeController() {
    }

    // --------------------- Getters y Setters ---------------------
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getClaveAct() {
        return claveAct;
    }

    public void setClaveAct(String claveAct) {
        this.claveAct = claveAct;
    }

    public String getClaveNew() {
        return claveNew;
    }

    public void setClaveNew(String claveNew) {
        this.claveNew = claveNew;
    }

    public String getClaveRep() {
        return claveRep;
    }

    public void setClaveRep(String claveRep) {
        this.claveRep = claveRep;
    }

    // --------------------- Métodos del Bean ---------------------
    public String index() {
        return "/index";
    }

    public String acercaDe() {
        return "/home/acerca_de";
    }

    public String login() {
        return "/home/login";
    }

    //  -------------------- Función de ingreso al sistema --------------------
    public String ingresar() {

        Usuario login = dao.getLogin(usuario, clave);

        // Si el login no es correcto, se queda en la página actual.
        if (login == null) {
            SessionUtil.addErrorMessage("Usuario o Claves incorrectos");
            return null;
        }

        // Cierra la sesion y la crea con el nuevo usuario logueada.
        SessionUtil.closeSession();
        SessionUtil.addSession(login.getId(), login.getNombre(), login.getTipousuarioId().getId(), login.getTipousuarioId().getNombre());
        return "/index";
    }

    public String logout() {
        SessionUtil.closeSession();
        return "/index";
    }

    public String cambio_clave() {
        return "/home/cambio_clave";
    }

    // Funcion para cambiar la clave del usuario.
    public String cambiarPWD() {

        // Si las claves nueva y repetida no coinciden, error.
        if (!(claveNew.equals(claveRep))) {
            SessionUtil.addErrorMessage("La clave nueva debe ser igual al campo repetida");
            return null;
        }

        // Recupera el usuario actual para conocer su clave
        Usuario current = dao.find(SessionUtil.getUserLog());
        String claveUsr = current.getClave();

        // La clave del usuario debe ser la actual
        if (!(claveAct.equals(claveUsr))) {
            SessionUtil.addErrorMessage("La clave actual no coincide con la de su usuario");
            return null;
        }

        current.setClave(claveNew);
        dao.edit(current);
        return "/index";
    }

    public String irA(String accion) {
        return accion;
    }

    public void accesoURL(Boolean ctrl, String pagina) {
        if (!tieneAcceso(ctrl, pagina)) {
            SessionUtil.redirectTo("/faces/home/acceso_denegado.xhtml");
        }
    }

    // Determina si la pagina para el tipo de usuario puede ser accedida.
    public boolean tieneAcceso(Boolean ctrl, String pagina) {

        if (!ctrl) {
            return true;
        } // Si el indicador dice que no hay que controlar, tiene acceso.

        // Si el usuario no ingreso, no hay acceso.
        Integer userLog = SessionUtil.getUserLog();
        if (userLog == null) {
            return false;
        }

        // El usuario ingreso, si la página está en blanco, hay acceso.
        // Página en blanco indica que solo se requiere está logueado).
        if (pagina.equals("")) {
            return true;
        }

        // Si la opción de menú no existe, no hay acceso.
        Menu menu = daoMenu.findByAction(pagina);
        if (menu == null) {
            return false;
        }

        // No debería pasar, pero si el tipo no existe, no hay acceso.
        Tipousuario tipo = daoTU.find(SessionUtil.getIdUserTipoLog());
        if (tipo == null) {
            return false;
        }

        // Se controla acceso por menu (se busca en la tabla de accesos el tipo usuario y la página).
        return daoMTU.findByMenuAndTipousuario(menu, tipo);

    }

    // Funcion que determina si hay un usuario logueado.
    public Boolean logueado() {
        Integer userLog = SessionUtil.getUserLog();
        // Modifiqué con la ayuda de Vicente para que funcione
        if (userLog == null) {
            return (false);
        } else {
            return (true);
        }
        //return !(userLog == null);
    }

    public String infoDelPie() {

        String nombre = SessionUtil.getUserNombreLog();
        String tipo = SessionUtil.getUserTipoLog();
        String usuario = "";
        if (nombre != null && tipo != null) {
            usuario = nombre + " (" + tipo + ")";
        }

        //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm a");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date d = new Date();
        String fechaStr = sdf.format(d);

        return usuario + " - " + fechaStr + " - Desarrollado por Hugo Daniel Ramirez - ";

    }
}

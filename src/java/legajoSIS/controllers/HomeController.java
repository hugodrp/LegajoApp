package legajoSIS.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author usuario
 */
@Named(value = "homeController")
@SessionScoped
public class HomeController implements Serializable {

    // --------------------- Constructor de la clase ---------------------
    public HomeController() {
    }

    // --------------------- Métodos del Bean ---------------------
    public String index() {
        return "/index";
    }

    public String acercaDe() {
        return "/home/acerca_de";
    }

    public String infoDelPie() {
        String nombre = null;
        String tipo = null;
        String usuario = "";
        if (nombre != null && tipo != null) {
            usuario = nombre + " (" + tipo + ")";
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy h:mm a");
        Date d = new Date();
        String fechaStr = sdf.format(d);

        return usuario + " - " + fechaStr + " - Desarrollado con Java EE 8 - ";
    }
}

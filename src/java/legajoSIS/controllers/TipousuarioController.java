/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legajoSIS.controllers;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author usuario
 */
@Named(value = "tipousuarioController")
@SessionScoped
public class TipousuarioController implements Serializable {

    /**
     * Creates a new instance of TipousuarioController
     */
    public TipousuarioController() {
    }

    public String index() {
        return "/tipousuario/index";
    }
}

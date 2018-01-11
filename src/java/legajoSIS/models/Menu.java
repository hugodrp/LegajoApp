/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legajoSIS.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "menu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")
    , @NamedQuery(name = "Menu.findById", query = "SELECT m FROM Menu m WHERE m.id = :id")
    , @NamedQuery(name = "Menu.findByNombre", query = "SELECT m FROM Menu m WHERE m.nombre = :nombre")
    , @NamedQuery(name = "Menu.findByImagen", query = "SELECT m FROM Menu m WHERE m.imagen = :imagen")
    , @NamedQuery(name = "Menu.findByUrl", query = "SELECT m FROM Menu m WHERE m.url = :url")
    , @NamedQuery(name = "Menu.findByAccion", query = "SELECT m FROM Menu m WHERE m.accion = :accion")
    , @NamedQuery(name = "Menu.findByRaiz", query = "SELECT m FROM Menu m WHERE m.raiz = :raiz")
    , @NamedQuery(name = "Menu.findByOrden", query = "SELECT m FROM Menu m WHERE m.orden = :orden")
    , @NamedQuery(name = "Menu.findByCreated", query = "SELECT m FROM Menu m WHERE m.created = :created")
    , @NamedQuery(name = "Menu.findByUpdated", query = "SELECT m FROM Menu m WHERE m.updated = :updated")})
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 100)
    @Column(name = "imagen")
    private String imagen;
    @Size(max = 100)
    @Column(name = "url")
    private String url;
    @Size(max = 100)
    @Column(name = "accion")
    private String accion;
    @Column(name = "raiz")
    private Integer raiz;
    @Column(name = "orden")
    private Integer orden;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @OneToMany(mappedBy = "menuId")
    private List<MenuTipousuario> menuTipousuarioList;

    public Menu() {
    }

    public Menu(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public Integer getRaiz() {
        return raiz;
    }

    public void setRaiz(Integer raiz) {
        this.raiz = raiz;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @XmlTransient
    public List<MenuTipousuario> getMenuTipousuarioList() {
        return menuTipousuarioList;
    }

    public void setMenuTipousuarioList(List<MenuTipousuario> menuTipousuarioList) {
        this.menuTipousuarioList = menuTipousuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "legajoSIS.models.Menu[ id=" + id + " ]";
    }
    
}

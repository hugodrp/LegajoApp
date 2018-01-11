/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package legajoSIS.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author usuario
 */
@Entity
@Table(name = "menu_tipousuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MenuTipousuario.findAll", query = "SELECT m FROM MenuTipousuario m")
    , @NamedQuery(name = "MenuTipousuario.findById", query = "SELECT m FROM MenuTipousuario m WHERE m.id = :id")
    , @NamedQuery(name = "MenuTipousuario.findByCreated", query = "SELECT m FROM MenuTipousuario m WHERE m.created = :created")
    , @NamedQuery(name = "MenuTipousuario.findByUpdated", query = "SELECT m FROM MenuTipousuario m WHERE m.updated = :updated")})
public class MenuTipousuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created;
    @Column(name = "updated")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updated;
    @JoinColumn(name = "menu_id", referencedColumnName = "id")
    @ManyToOne
    private Menu menuId;
    @JoinColumn(name = "tipousuario_id", referencedColumnName = "id")
    @ManyToOne
    private Tipousuario tipousuarioId;

    public MenuTipousuario() {
    }

    public MenuTipousuario(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Menu getMenuId() {
        return menuId;
    }

    public void setMenuId(Menu menuId) {
        this.menuId = menuId;
    }

    public Tipousuario getTipousuarioId() {
        return tipousuarioId;
    }

    public void setTipousuarioId(Tipousuario tipousuarioId) {
        this.tipousuarioId = tipousuarioId;
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
        if (!(object instanceof MenuTipousuario)) {
            return false;
        }
        MenuTipousuario other = (MenuTipousuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "legajoSIS.models.MenuTipousuario[ id=" + id + " ]";
    }
    
}

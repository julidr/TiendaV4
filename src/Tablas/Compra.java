package Tablas;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import com.sun.istack.NotNull;

@Entity
@Table(name = "compra")
@XmlRootElement
public class Compra {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Compra_id")
    private Integer compraid;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Compra")
    @Temporal(TemporalType.DATE)
    private java.util.Date fechaCompra;
    @JoinColumn(name = "Cancion_id", referencedColumnName = "Cancion_id")
    @ManyToOne(optional = false)
    private Cancion cancionid;
    @JoinColumn(name = "Cliente_id", referencedColumnName = "Cliente_id")
    @ManyToOne(optional = false)
    private Cliente clienteid;

    public Compra() {
    }

    public Compra(Integer compraid) {
        this.compraid = compraid;
    }

    public Compra(Integer compraid, Date fechaCompra) {
        this.compraid = compraid;
        this.fechaCompra = fechaCompra;
    }

    public Integer getCompraid() {
        return compraid;
    }

    public void setCompraid(Integer compraid) {
        this.compraid = compraid;
    }

    public java.util.Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(java.util.Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public Cancion getCancionid() {
        return cancionid;
    }

    public void setCancionid(Cancion cancionid) {
        this.cancionid = cancionid;
    }

    public Cliente getClienteid() {
        return clienteid;
    }

    public void setClienteid(Cliente clienteid) {
        this.clienteid = clienteid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (compraid != null ? compraid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.compraid == null && other.compraid != null) || (this.compraid != null && !this.compraid.equals(other.compraid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tienda.Compra[ compraid=" + compraid + " ]";
    }

}

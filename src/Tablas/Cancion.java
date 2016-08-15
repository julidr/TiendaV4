package Tablas;

import java.sql.Date;
import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sun.istack.NotNull;

@Entity
@Table(name = "cancion")
@XmlRootElement
public class Cancion {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cancion_id")
    private Integer cancionid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre_Cancion")
    private String nombreCancion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Genero_Cancion")
    private String generoCancion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Fecha_Cancion")
    @Temporal(TemporalType.DATE)
    private java.util.Date fechaCancion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cancionid")
    private Collection<Compra> compraCollection;
    @JoinColumn(name = "Album_id", referencedColumnName = "Album_id")
    @ManyToOne(optional = false)
    private Album albumid;

    public Cancion() {
    }

    public Cancion(Integer cancionid) {
        this.cancionid = cancionid;
    }

    public Cancion(Integer cancionid, String nombreCancion, String generoCancion, Date fechaCancion) {
        this.cancionid = cancionid;
        this.nombreCancion = nombreCancion;
        this.generoCancion = generoCancion;
        this.fechaCancion = fechaCancion;
    }

    public Integer getCancionid() {
        return cancionid;
    }

    public void setCancionid(Integer cancionid) {
        this.cancionid = cancionid;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getGeneroCancion() {
        return generoCancion;
    }

    public void setGeneroCancion(String generoCancion) {
        this.generoCancion = generoCancion;
    }

    public java.util.Date getFechaCancion() {
        return fechaCancion;
    }

    public void setFechaCancion(java.util.Date fechaCancion) {
        this.fechaCancion = fechaCancion;
    }

    @XmlTransient
    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    public Album getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Album albumid) {
        this.albumid = albumid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cancionid != null ? cancionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancion)) {
            return false;
        }
        Cancion other = (Cancion) object;
        if ((this.cancionid == null && other.cancionid != null) || (this.cancionid != null && !this.cancionid.equals(other.cancionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tienda.Cancion[ cancionid=" + cancionid + " ]";
    }

}

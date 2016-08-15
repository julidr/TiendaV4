package Tablas;

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
@Table(name = "album")
@XmlRootElement
public class Album {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Album_id")
    private Integer albumid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre_Album")
    private String nombreAlbum;
    @Column(name = "Fecha_Album")
    @Temporal(TemporalType.DATE)
    private java.util.Date fechaAlbum;
    @Size(max = 45)
    @Column(name = "Genero_Album")
    private String generoAlbum;
    @JoinColumn(name = "Artista_id", referencedColumnName = "Artista_id")
    @ManyToOne(optional = false)
    private Artista artistaid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "albumid")
    private Collection<Cancion> cancionCollection;

    public Album() {
    }

    public Album(Integer albumid) {
        this.albumid = albumid;
    }

    public Album(Integer albumid, String nombreAlbum) {
        this.albumid = albumid;
        this.nombreAlbum = nombreAlbum;
    }

    public Integer getAlbumid() {
        return albumid;
    }

    public void setAlbumid(Integer albumid) {
        this.albumid = albumid;
    }

    public String getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreAlbum(String nombreAlbum) {
        this.nombreAlbum = nombreAlbum;
    }

    public java.util.Date getFechaAlbum() {
        return fechaAlbum;
    }

    public void setFechaAlbum(java.util.Date fechaAlbum) {
        this.fechaAlbum = fechaAlbum;
    }

    public String getGeneroAlbum() {
        return generoAlbum;
    }

    public void setGeneroAlbum(String generoAlbum) {
        this.generoAlbum = generoAlbum;
    }

    public Artista getArtistaid() {
        return artistaid;
    }

    public void setArtistaid(Artista artistaid) {
        this.artistaid = artistaid;
    }

    @XmlTransient
    public Collection<Cancion> getCancionCollection() {
        return cancionCollection;
    }

    public void setCancionCollection(Collection<Cancion> cancionCollection) {
        this.cancionCollection = cancionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (albumid != null ? albumid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Album)) {
            return false;
        }
        Album other = (Album) object;
        if ((this.albumid == null && other.albumid != null) || (this.albumid != null && !this.albumid.equals(other.albumid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tienda.Album[ albumid=" + albumid + " ]";
    }

}

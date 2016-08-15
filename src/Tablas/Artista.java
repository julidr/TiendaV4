package Tablas;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.sun.istack.NotNull;

@Entity
@Table(name = "artista")
@XmlRootElement
public class Artista {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Artista_id")
    private Integer artistaid;
    @Size(max = 45)
    @Column(name = "Nombre_Real")
    private String nombreReal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre_Artistico")
    private String nombreArtistico;
    @Column(name = "Edad_Artista")
    private Integer edadArtista;
    @Size(max = 45)
    @Column(name = "Nacionalidad_Artista")
    private String nacionalidadArtista;
    @Size(max = 2)
    @Column(name = "Genero_Artista")
    private String generoArtista;
    @Size(max = 12)
    @Column(name = "Tipo_Artista")
    private String tipoArtista;
    @Size(max = 45)
    @Column(name = "Segundo_Artista")
    private String segundoArtista;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "artistaid")
    private Collection<Album> albumCollection;

    public Artista() {
    }

    public Artista(Integer artistaid) {
        this.artistaid = artistaid;
    }

    public Artista(Integer artistaid, String nombreArtistico) {
        this.artistaid = artistaid;
        this.nombreArtistico = nombreArtistico;
    }

    public Integer getArtistaid() {
        return artistaid;
    }

    public void setArtistaid(Integer artistaid) {
        this.artistaid = artistaid;
    }

    public String getNombreReal() {
        return nombreReal;
    }

    public void setNombreReal(String nombreReal) {
        this.nombreReal = nombreReal;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public Integer getEdadArtista() {
        return edadArtista;
    }

    public void setEdadArtista(Integer edadArtista) {
        this.edadArtista = edadArtista;
    }

    public String getNacionalidadArtista() {
        return nacionalidadArtista;
    }

    public void setNacionalidadArtista(String nacionalidadArtista) {
        this.nacionalidadArtista = nacionalidadArtista;
    }

    public String getGeneroArtista() {
        return generoArtista;
    }

    public void setGeneroArtista(String generoArtista) {
        this.generoArtista = generoArtista;
    }

    public String getTipoArtista() {
        return tipoArtista;
    }

    public void setTipoArtista(String tipoArtista) {
        this.tipoArtista = tipoArtista;
    }

    public String getSegundoArtista() {
        return segundoArtista;
    }

    public void setSegundoArtista(String segundoArtista) {
        this.segundoArtista = segundoArtista;
    }

    @XmlTransient
    public Collection<Album> getAlbumCollection() {
        return albumCollection;
    }

    public void setAlbumCollection(Collection<Album> albumCollection) {
        this.albumCollection = albumCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (artistaid != null ? artistaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artista)) {
            return false;
        }
        Artista other = (Artista) object;
        if ((this.artistaid == null && other.artistaid != null) || (this.artistaid != null && !this.artistaid.equals(other.artistaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tienda.Artista[ artistaid=" + artistaid + " ]";
    }

}

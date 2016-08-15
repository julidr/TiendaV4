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

@Entity
@Table(name = "cliente")
@XmlRootElement
public class Cliente {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Cliente_id")
    private Integer clienteid;
    @Size(max = 45)
    @Column(name = "Nombre_Cliente")
    private String nombreCliente;
    @Size(max = 45)
    @Column(name = "Direccion_Cliente")
    private String direccionCliente;
    @Size(max = 45)
    @Column(name = "Telefono_Cliente")
    private String telefonoCliente;
    @Size(max = 45)
    @Column(name = "Correo_Cliente")
    private String correoCliente;
    @Size(max=100)
    @Column(name= "Cedula_Cliente")
    private String cedulaCliente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteid")
    private Collection<Compra> compraCollection;

    public Cliente() {
    }

    public Cliente(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public Integer getClienteid() {
        return clienteid;
    }

    public void setClienteid(Integer clienteid) {
        this.clienteid = clienteid;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }
    
    public String getCedulaCliente(){
    	return cedulaCliente;
    }
    
    public void setCedulaCliente(String cedulaCliente){
    	this.cedulaCliente= cedulaCliente;
    }

    @XmlTransient
    public Collection<Compra> getCompraCollection() {
        return compraCollection;
    }

    public void setCompraCollection(Collection<Compra> compraCollection) {
        this.compraCollection = compraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clienteid != null ? clienteid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.clienteid == null && other.clienteid != null) || (this.clienteid != null && !this.clienteid.equals(other.clienteid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.tienda.Cliente[ clienteid=" + clienteid + " ]";
    }

}

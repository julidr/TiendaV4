package WebService;

import java.util.Date;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="cancion")
public class ReporteXML {
	
	int idCancion;
	int cantidadVendida;
	String nombreCancion;
	Date fechaCancion;
	String generoCancion;
	String nombreAlbum;
	String cantante;
	
	@XmlAttribute
	public int getIdCancion() {
		return idCancion;
	}
	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}
	@XmlElement
	public int getCantidadVendida() {
		return cantidadVendida;
	}
	public void setCantidadVendida(int cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}
	@XmlElement
	public String getNombreCancion() {
		return nombreCancion;
	}
	public void setNombreCancion(String nombreCancion) {
		this.nombreCancion = nombreCancion;
	}
	@XmlElement
	public Date getFechaCancion() {
		return fechaCancion;
	}
	public void setFechaCancion(Date fechaCancion) {
		this.fechaCancion = fechaCancion;
	}
	@XmlElement
	public String getGeneroCancion() {
		return generoCancion;
	}
	public void setGeneroCancion(String generoCancion) {
		this.generoCancion = generoCancion;
	}
	@XmlElement
	public String getNombreAlbum() {
		return nombreAlbum;
	}
	public void setNombreAlbum(String nombreAlbum) {
		this.nombreAlbum = nombreAlbum;
	}
	@XmlElement
	public String getCantante() {
		return cantante;
	}
	public void setCantante(String cantante) {
		this.cantante = cantante;
	}
	
	
	
	

}

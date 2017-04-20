package WebService;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import Servicios.AdministradorDeTienda;
import Validaciones.Comparacion;

@Path("/ServicioREST")
public class ServicioREST {
	
	static AdministradorDeTienda ad= new AdministradorDeTienda();
	
	@POST
	@Path("/aceptarCancion")
    public String aceptarCancion(@QueryParam("nombre") String nombre,@QueryParam("artista") String artista, @QueryParam("album") String album, @QueryParam("genero") String genero ){
        if(!Comparacion.bloquear("C:\\Users\\Usuario\\workspace\\TiendaV4\\ListaNoPermitidos.txt", genero.toLowerCase(), "Reggaeton", 2)){
        	ad.agregarCatalogo(ad.transformarEspacios(artista), ad.transformarEspacios(album), ad.transformarEspacios(nombre), ad.transformarEspacios(genero));
        }
        else{
        	System.out.println("El genero de su cancion no es aceptado por nuestra tienda");
        }
        return ad.texto(nombre, artista, album, genero);
    }
	
	@GET
	@Path("/generarReporte")
	@Produces(MediaType.APPLICATION_XML)
	public ArrayList<ReporteXML> generarReporte(@QueryParam("fechaInicio") String fechaInicio, @QueryParam("fechaFin") String fechaFin){
		ArrayList<ReporteXML> listaReporte= new ArrayList<ReporteXML>();
		List<Object> lista= ad.GenerarReporte(fechaInicio, fechaFin);
		if(lista.size()==0){
			System.out.println("No hay resultados en ese rango de fechas");
		}
		else{
			Iterator itr= lista.iterator();
			while(itr.hasNext()){
				ReporteXML reporte= new ReporteXML();
				Object[] obj= (Object[]) itr.next();
				reporte.setIdCancion(Integer.parseInt(obj[0]+""));
				reporte.setCantidadVendida(Integer.parseInt(obj[1]+""));
				reporte.setNombreCancion(obj[2]+"");
				reporte.setFechaCancion((Date)obj[3]);
				reporte.setGeneroCancion(obj[4]+"");
				reporte.setNombreAlbum(obj[5]+"");
				reporte.setCantante(obj[6]+"");
				listaReporte.add(reporte);
			}
		}		
		return listaReporte;
	}

}

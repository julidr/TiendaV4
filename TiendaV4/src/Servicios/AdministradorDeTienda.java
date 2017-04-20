package Servicios;


import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import Tablas.Album;
import Tablas.Artista;
import Tablas.Cancion;
import Tablas.Cliente;
import Tablas.Compra;


public class AdministradorDeTienda {
	
	 public static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "TiendaV4" );
	 public static EntityManager entitymanager = emfactory.createEntityManager( );

//Metodo que llama a un metodo estatico de la clase CatalogoDeCanciones para agregarlas a la base
	public void agregarCatalogo(String artista, String album, String nombre, String genero){
		CatalogoDeCanciones.agregarCatalogo(artista, album, nombre, genero);
    }
	
	
//Metodo que llama a un metodo estatico de la clase AdministradorDeClientes para crear clientes en la base
	public void crearCliente(String nombre, String direccion, String telefono, String correo, String cedula){
		AdministradorDeClientes.crearCliente(nombre, direccion, telefono, correo, cedula);		
	}
	
	//Metodo que llama a un metodo estatico de la clase CatalogoDeCanciones para buscar una cancion por su nombre
	public void BuscarCancionesPorNombre(String nombreCancion){
		CatalogoDeCanciones.BuscarCancionesPorNombre(nombreCancion);
	}
	
	//Metodo que llama a un metodo estatico de la clase CatalogoDeCanciones para buscar un album por su nombre
	public void BuscarAlbumPorNombre(String nombreAlbum){
		CatalogoDeCanciones.BuscarAlbumPorNombre(nombreAlbum);
	}	
	
	/*Metodo que recibe como parametros el id de una cancion y la cedula del cliente
	 * y realiza la asociacion correspondiente 
	 * para generar una compra en la base de datos
	 * 
	*/
	public void generarCompraCancion(int idCancion, String cedula){
		
		Cancion single= entitymanager.find(Cancion.class,idCancion);
		int idCliente= AdministradorDeClientes.DevolverIdCliente(cedula);
		if(idCliente!=0){
			Cliente clientico= entitymanager.find(Cliente.class, idCliente);
			Compra comprita= new Compra();
			
			java.util.Date fechaCompra= new Date();
			
			entitymanager.getTransaction( ).begin( );
			comprita.setCancionid(single);
			comprita.setClienteid(clientico);
			comprita.setFechaCompra(fechaCompra);
			entitymanager.persist(comprita);
			entitymanager.getTransaction().commit();	
		}
		else{
			System.out.println("El cliente no existe");
		}
	}
	
	/*Metodo que recibe como parametros el id de un album y la cedula del cliente
	 * para realizar la asociacion correspondiente entre todas las canciones de un album y agregarlas a la compra
	 */
	public void generarCompraAlbum(int idAlbum, String cedula){
		Album albumMusic= entitymanager.find(Album.class, idAlbum);
		Query query= entitymanager.createNativeQuery("select t1.Cancion_id from cancion"+
				" as t1 inner join album as t2 on t1.Album_id=t2.Album_id where t2.Album_id="+idAlbum);
		List<Object> listaDeCancionesEnElAlbum= query.getResultList();
		Iterator itr= listaDeCancionesEnElAlbum.iterator();
		int i=0;
		while(itr.hasNext()){
			int obj= (int) itr.next();
			System.out.println(obj);
			generarCompraCancion(obj, cedula);
		}
	}
	
	public List<Object> GenerarReporte(String fechaInicio, String fechaFinal){
		try {
			System.out.println("Entre");
			Query query= entitymanager.createNativeQuery("select t1.Cancion_id, count(*), t2.Nombre_Cancion, "+
					"t2.Fecha_Cancion, t2.Genero_Cancion, t3.Nombre_Album, t4.Nombre_Artistico "+
					"from compra t1 inner join cancion t2 on t1.Cancion_id=t2.Cancion_id inner join album t3 "+
					"on t2.Album_id=t3.Album_id inner join artista t4 on t3.Artista_id=t4.Artista_id "+
					"where (t2.Fecha_Cancion>='"+fechaInicio+"' and t2.Fecha_Cancion<='"+fechaFinal
					+"') group by t1.Cancion_id ");
			List<Object> listaReporte= query.getResultList();
			Iterator itr= listaReporte.iterator();
			System.out.println(" "+"Id"+"  "+"Ventas"+" "+"Cancion"+" "+"Fecha"+" "+"Genero"+" "+"Album"+" "+"Cantante");
			while(itr.hasNext()){
				Object[] obj= (Object[]) itr.next();
				System.out.println(" "+ obj[0]+"  "+obj[1]+" "+obj[2]+" "+obj[3]+" "+obj[4]+" "+obj[5]+" "+obj[6]);
			}
			return listaReporte;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	public String transformarEspacios(String texto){
		String[] separador= texto.split("_");
		String textoConEspacios="";
		for(int i=0; i<separador.length; i++){
			textoConEspacios=textoConEspacios+separador[i]+" ";
		}
		return textoConEspacios;
	}
	
	//Metodo de prueba de que se puede acceder
	public String texto(String nombre, String artista, String album, String genero){
		return "Si funciono " + nombre +" "+ artista + " "+album+" "+genero;
	}
	
}

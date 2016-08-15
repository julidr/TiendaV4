package Servicios;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import Tablas.Album;
import Tablas.Artista;
import Tablas.Cancion;

public class CatalogoDeCanciones {
	
	/*Metodo que implementa JPA para insertar una cancion a la base de datos
	 * Recibe como Parametros el nombre del cantante, del album, de la cancion y su genero musical
	 * El metodo busca si el album o el cantante ya se encuentran en la base de datos, en dado caso de que ya exista
	 * solamente vinculara la cancion con su artista y album, de lo contrario los creara.
	*/
		public static void agregarCatalogo(String artista, String album, String nombre, String genero){
			
			Artista cantante= new Artista();
		    Album albumMusic= new Album();
		    Cancion single= new Cancion();
		    java.util.Date fechaIngreso= new Date();
		    int idAlbum= BuscarAlbumYDevolverId(album);
		    int idCantante= BuscarCantanteYDevolverId(artista);
	        
	        AdministradorDeTienda.entitymanager.getTransaction( ).begin( );
	        if(idCantante==0){
	        	System.out.println("El Cantante no existe...creando");
	        	cantante.setNombreArtistico(artista);
	            AdministradorDeTienda.entitymanager.persist(cantante);
	        }
	        else{
	        	System.out.println("Cantante ya existente");
	        	cantante=AdministradorDeTienda.entitymanager.find(Artista.class, idCantante);
	        }
	        
	        if(idAlbum==0){
	           System.out.println("El Album no existe...creando");
	           albumMusic.setNombreAlbum(album);
	           albumMusic.setArtistaid(cantante);
	           AdministradorDeTienda.entitymanager.persist(albumMusic);
	        }
	        else{
	        	System.out.println("Album ya Existente");
	        	albumMusic=AdministradorDeTienda.entitymanager.find(Album.class, idAlbum);
	        }
	        single.setNombreCancion(nombre);
	        single.setAlbumid(albumMusic);
	        single.setGeneroCancion(genero);
	        single.setFechaCancion(fechaIngreso);
	        AdministradorDeTienda.entitymanager.persist(single);
	        AdministradorDeTienda.entitymanager.getTransaction().commit();
	             
	        System.out.println("La inserción ha sido un exito");
	    }
		
		/*Metodo que recibe el nombre de un album y devuelve su correspondiente id
		 * En caso de que el Album no sea encontrado, devuelve un 0
		*/
		public static int BuscarAlbumYDevolverId(String album){
			try {
				Query query= AdministradorDeTienda.entitymanager.createNativeQuery("select Album_id from album "+
						"where Nombre_Album='"+album+"'");
				Object idAlbum= query.getSingleResult();
				return Integer.parseInt(idAlbum+"");

			} catch (NoResultException e) {
				return 0;
			}
		}
		
		/*Metodo que recibe el nombre de un cantante (su nombre artistico) y devuelve su correspondiente id
		 * en caso de que el cantante no exista, devuelve un 0
		*/
		public static int BuscarCantanteYDevolverId(String artista){
			try {
				Query query= AdministradorDeTienda.entitymanager.createNativeQuery("select Artista_id from artista where Nombre_Artistico='"+artista+"'");
				Object idArtista= query.getSingleResult();
				return Integer.parseInt(idArtista+"");
			} catch (NoResultException e) {
				return 0;
			}
		}
		
		/*Metodo que Recibe el nombre de una cancion como parametro y permite visualizar su informacion relacionada
		 * Dentro de la informacion que permite visualizar esta:
		 * -Id de la cancion, Nombre de la Cancion y Genero de la cancion
		 * -Nombre artistico del cantante
		 * -Nombre del Album al cual pertenece
		 */
		public static void BuscarCancionesPorNombre(String nombreCancion){
			Query query= AdministradorDeTienda.entitymanager.createNativeQuery("select t3.Cancion_id, t3.Nombre_Cancion,"+
					" t3.Genero_Cancion, t1.Nombre_Artistico, t2.Nombre_Album"+
					" from artista as t1 inner join album as t2 on t1.artista_id=t2.artista_id"+
					" inner join cancion as t3 on t2.album_id=t3.album_id where t3.Nombre_Cancion='"+nombreCancion+"'");
			List<Object> cancionesBusqueda= query.getResultList();
			Iterator itr= cancionesBusqueda.iterator();
			System.out.println("\n");
			System.out.println("Id             Nombre                           Genero                       Artista                              Album");
			while(itr.hasNext()){
				Object[] obj= (Object[]) itr.next();
				System.out.println(obj[0] + "             " + obj[1] + "                           " + obj[2] + "                       " + obj[3]+ "                              " + obj[4]);
			}	
		}
		
		/*Metodo que recibe como parametro el Nombre de un Album y permite visualizar su informacion relacionada
		 * Dentro de la informacion que permite visualizar esta:
		 * -Id del album, nombre del album
		 * -Nombre artistico del cantante
		 */
		public static void BuscarAlbumPorNombre(String nombreAlbum){
			Query query= AdministradorDeTienda.entitymanager.createNativeQuery("select t2.Album_id, t2.Nombre_Album,"+
					" t1.Nombre_Artistico from artista as t1 inner join album as t2 on t1.artista_id=t2.artista_id"+
					" inner join cancion as t3 on t2.album_id=t3.album_id where t2.Nombre_Album='"+nombreAlbum+"'");
			List<Object> ListaAlbumnes= query.getResultList();
			Iterator itr= ListaAlbumnes.iterator();
			System.out.println("\n");
			System.out.println("Id                      Album                      Artista");
			Object[] obj= (Object[]) itr.next();
			System.out.println(obj[0] + "                      " + obj[1] + "                      " + obj[2]);
		}		

}

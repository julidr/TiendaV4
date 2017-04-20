package Servicios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Inicio {
	
	public static AdministradorDeTienda ad= new AdministradorDeTienda();
	public static BufferedReader leer= new BufferedReader(new InputStreamReader(System.in));
    public static String nombreCancion;
    public static String cedula;
    public static String album;

    //Main que pemrite ejecutar la aplicacion de manera local
	public static void main(String[] args){
	    int opc;
        try {
        	do{
            	System.out.println("\n 1) Crear un Cliente\n 2) Comprar una Cancion\n 3) Comprar un Album\n "+
            			"4) Agregar una Canción\n 5) Generar Reporte\n 0) Salir");
                System.out.println("Digite la opcion que desea realizar");
                opc= Integer.parseInt(leer.readLine());
                
                switch(opc){
            	case 1: crearCliente(); break;
            	case 2: comprarCancion(); break;
            	case 3: comprarAlbum();  break;
            	case 4: agregarCancion(); break;
            	case 5: generarReporte(); break;	
                }
            }while(opc!=0);  
			
		} catch (Exception e) {
			System.out.println("Ingrese solamente numeros para seleccionar las opciones");
			main(null);
		}
     }

	//Metodo que recoge las fechas para empezar a generar los reportes
	private static void generarReporte() {
		try {
			System.out.println("Ingrese la fecha de Inicio");
    		String fechaInicio= leer.readLine();
    		System.out.println("Ingrese la fecha de Fin");
    		String fechaFinal= leer.readLine();
    		ad.GenerarReporte(fechaInicio, fechaFinal);
		} catch (Exception e) {
		}
	}

	//Metodo que recoge la informacion basica de una cancion para agregarla a la base de datos
	private static void agregarCancion() {
		try {
			System.out.println("Nombre del artista");
            String artista= leer.readLine();
            System.out.println("Nombre del Album");
            album= leer.readLine();
            System.out.println("Nombre de la cancion");
            nombreCancion=leer.readLine();
            System.out.println("Genero de la cancion");
            String genero= leer.readLine();
            ad.agregarCatalogo(artista, album, nombreCancion, genero);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	//Metodo que recoge la informacion necesaria para realizar la compra de un Album
	private static void comprarAlbum() {
		try {
			System.out.println("Ingrese el nombre del Album");
    		album= leer.readLine();
    		ad.BuscarAlbumPorNombre(album);
    		System.out.println("Ingrese el Id del Album que se va a comprar");
    		int idAlbum= Integer.parseInt(leer.readLine());
    		System.out.println("Ingrese la cedula del Cliente");
    		cedula=leer.readLine();
    		ad.generarCompraAlbum(idAlbum, cedula);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	//Metodo que recoge la informacion necesaria para comprar una cancion
	private static void comprarCancion() {
		try {
			System.out.println("Ingrese el nombre de la Cancion");
			nombreCancion= leer.readLine();
			ad.BuscarCancionesPorNombre(nombreCancion);
			System.out.println("Ingrese el Id de la Cancion que se va a comprar");
			int id= Integer.parseInt(leer.readLine());
			System.out.println("Ingrese la cedula del Cliente");
			cedula=leer.readLine();
			ad.generarCompraCancion(id, cedula);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	//Metodo que recoge la informacion necesaria para crear un cliente
	private static void crearCliente() {
		try {
			System.out.println("Ingrese la Cedula del Cliente");
			cedula= leer.readLine();
			System.out.println("Ingrese el Nombre del Cliente");
			String nombre= leer.readLine();
			System.out.println("Ingrese la Direccion del Cliente");
			String direccion= leer.readLine();
			System.out.println("Ingrese el telefono del Cliente");
			String telefono= leer.readLine();
			System.out.println("Ingrese el correo del Cliente");
			String correo= leer.readLine();
			ad.crearCliente(nombre, direccion, telefono, correo, cedula);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

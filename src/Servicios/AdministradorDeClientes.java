package Servicios;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import Tablas.Cliente;

public class AdministradorDeClientes {
	
	/*Metodo que implementa JPA para insertar un cliente nuevo a la base de datos
	 * Recibe como parametros el nombre del cliente, su direccion, telefono, correo y su cedula
	 * El metodo busca si el cliente ya existe, en caso de que ta exista no hace ninguna insercion a la base de datos
	 */
		public static void crearCliente(String nombre, String direccion, String telefono, String correo, String cedula){
			if(DevolverIdCliente(cedula)!=0){
				System.out.println("El cliente ya existe, no se puede repetir cedula");
			}else{
				Cliente clientico= new Cliente();
				AdministradorDeTienda.entitymanager.getTransaction().begin();
				clientico.setNombreCliente(nombre);
				clientico.setDireccionCliente(direccion);
				clientico.setTelefonoCliente(telefono);
				clientico.setCorreoCliente(correo);
				clientico.setCedulaCliente(cedula);
				AdministradorDeTienda.entitymanager.persist(clientico);
				AdministradorDeTienda.entitymanager.getTransaction().commit();
				System.out.println("Cliente creado");
			}
		}
		
		/*El metodo recibe como parametros la cedula del cliente y retorna el id con el que se identifica en la base
		 * En caso de que el cliente no sea encontrado, retorna 0
		 */
		public static int DevolverIdCliente(String cedula){
			try {
				Query query= AdministradorDeTienda.entitymanager.createNativeQuery("select Cliente_id from cliente where Cedula_Cliente='"+cedula+"'");
				Object idCliente= query.getSingleResult();
				return Integer.parseInt(idCliente+"");
			} catch (NoResultException e) {
				return 0;
			}
		}

}

package ejercicio1;

import java.util.Scanner;

/**
 * Clase que realiza una conexion a base de datos, da al usuario distintas opciones
 * como: conectar, desconectar la conexion de una base de datos, ademas tambien permite
 * al usuario revisar los datos de la tabla, modificar, agregar y eliminar.
 * @author Adrian Valdivieso
 */
public class Main {

	public static Scanner n;
	public static BBDDAccess bd;
	public static boolean conexion;
	
	/**
	 * Pre:---
	 * Post: metodo principal el cual se trata de un bucle infinito en el cual
	 * 		 se pide al usuario distintas opciones para luego llamar a los distintos
	 * 		 metodos que realizan distintas opciones.
	 * @param args
	 */
	public static void main(String[] args) {
		menu();
		String alerta = "Tienes que conectar con la base de datos antes.";
		try {
			bd = new BBDDAccess();
			n = new Scanner(System.in);
			conexion = false;
			while(true) {
				int pregunta = realizarPregunta();
				if(pregunta == 1) {
					if(!conexion) {
						bd.iniciarConexion();
						System.out.println("Conexion Iniciada");
						conexion = true;
					} else {
						System.out.println("Ya tienes la conexion iniciada!!!");
					}
				} else if(pregunta == 2) {
					if(conexion) {
						bd.close();
						System.out.println("Conexion terminada");
						conexion = false;
					} else {
						System.out.println("Tienes la conexion apagada ya!!!");
					}
				} else if(pregunta == 3) {
					if(conexion) {
						bd.enseñarInformacion();						
					} else {
						System.out.println(alerta);
					}
				} else if(pregunta == 4) {
					if(conexion) {
						pedirDatosInsercion();
					} else {
						System.out.println(alerta);
					}
				} else if(pregunta == 5) {
					if(conexion) {
						pedirDatosEliminacion();
					} else {
						System.out.println(alerta);
					}
				} else if(pregunta == 6) {
					if(conexion) {
						pedirDatosActualizacion();
					} else {
						System.out.println(alerta);
					}
				} else if(pregunta == 7) {
					if(!conexion) {
						System.out.println("Hasta luego!!!");
						break;
					} else {
						System.out.println("Recuerda cerrar la conexion a la base de datos");						
					}
				} else if(pregunta == 8) {
					menu();
				} else {
					System.out.println("Opcion no correcta");
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
			//Si ocurre algun fallo se llama al metodo que realiza un rollback en la base de datos.
			bd.rollback();
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que pide datos al usuario para realizar una actualizacion
	 * 		 segun el nombre, el telefono del usuario con dicho nombre.
	 */
	public static void pedirDatosActualizacion() {
		try {
			String nombre = pedirDatos("Dime el nombre de la persona que quieres modificar");
			String telefono = "+34 " + pedirDatos("Dime el nuevo numero de telefono:");
			bd.actualizarUsuario(nombre, telefono);
		} catch(Exception e ) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Pre:---
	 * Post: metodo que pide al usuario el nombre de usuario el cual va a eliminar
	 * 		 en la base de datos.
	 */
	public static void pedirDatosEliminacion() {
		try {
			String nombre = pedirDatos("Dame un nombre al que deseas eliminar");
			bd.eliminarUsuario(nombre);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que pide al usuario por pantalla los datos necesarios
	 * 		 para añadir un nuevo elemento a la tabla de cliente.
	 */
	public static void pedirDatosInsercion() {
		try {
			String DNI = pedirDatos("Dame un DNI");
			String nombre = pedirDatos("Dame un nombre");
			String telefono = pedirDatos("Dame un telefono");
			String direccion = pedirDatos("Dame una direccion");
			bd.agregarDatos(DNI, nombre, telefono, direccion);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que gestiona los datos escritos por el usuario y si estan
	 * 		 bien los devuelve, sino vuelve a pedir al usuario los datos.
	 * @param mensaje
	 * @return String
	 */
	public static String pedirDatos(String mensaje) {
		System.out.println(mensaje);
		while(true) {
			try {
				return n.next();
			} catch(Exception e) {
				n.next();
				System.out.println("Vuelve a introducir el dato.");
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que gestiona la seleccion del menu mediante una
	 * 		 pregunta al usuario.
	 * @return String
	 */
	public static int realizarPregunta() {
		try{
			System.out.print("-> Dame una opcion(8 menu): ");
			return n.nextInt();
		} catch(Exception e) {
			n.next();
			return -1;
		}	
	}
	
	/**
	 * Pre:---
	 * Post: Muestra las opciones que tiene el usuario para elegir
	 */
	public static void menu() {
		System.out.println("-------------------\n1. Conectar a la base de datos.\n2. "
				+ "Desconectar de la base de datos.\n3. Ver nombres.\n4. Añadir nombres."
				+ "\n5. Eliminar nombre.\n6. Actualizar nombre.\n7. Salir."
				+ "\n8. Ver menu.\n-------------------");
	}
}
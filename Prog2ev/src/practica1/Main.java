package practica1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * <h2>Vamos a desarrollar un programa Java que se encargara de la gestion
 * completa de una liga de futbol.<h2> 
 * Para ello se crearan clases como la de: Liga, Equipo, Jugador y las 
 * necesarias para que el programa se pueda llevar a cabo. Una vez creadas
 * las clases, se gestionara de manera que se le permita al usuario interactuar
 * con un menu con una serie de opciones que mostraran por pantalla datos de la
 * liga, como su clasificacion, participantes, equipos, etc.
 * @author Adrian Valdivieso Paredes
 * @version 1.0 Fecha: 19/05/2023
 */
public class Main {
	
	/**
	 * Pre: ---
	 * Post: metodo el cual muestra por pantalla un mensaje de bienvenida, manda
	 * 		 a la creacion de la liga, contiene el try y el catch del programa y
	 * 		 manda a ejecutar el programa.
	 * @param args
	 */
	public static void main(String[] args) {
		Liga champions = crearLiga();
		System.out.println("---Bienvenido a la Liga Santander---");
		try {
			ejecutor(champions);
		} catch(InputMismatchException e) {
			System.out.println("Comando no compatible " + e);
			ejecutor(champions);
		}
	}
	/**
	 * Pre:---
	 * Post: metodo que se encarga de la creacion del objeto liga, equipos y de
	 * 		 jugadores, devuelve como parametro un objeto Liga.
	 * @return un objeto de tipo liga.
	 */
	public static Liga crearLiga() {
		Liga champions = new Liga("Champions");
		for(int i = 0; i < 15; i++) {
			Equipo equipo = new Equipo(devNombre(i), devEstadio(i));
			champions.getClasificacion().add(equipo);
			for(int j = 0; j < 11; j++) {
				Jugador jugador = new Jugador(devNomJug(), j + 1);
				equipo.getJugadores().add(jugador);
			}
		} return champions;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe un int de posicion y devuelve un nombre de la tabla
	 * 		 creada segun la posicion que se le haya enviado.
	 * @param posicion generada aleatoriamente.
	 * @return el nombre de un equipo segun la posicion.
	 */
	public static String devNombre(int posicion) {
		String[] tabla = new String[] {"Madrid", "Barcelona", "Liverpool", "Manchester",
				"PSG", "Sevilla", "Zaragoza", "Valencia", "Napoles", "Atletico", "Salesiano",
				"Alicante", "Santander", "Bilbao", "Huesca"};
		return tabla[posicion];
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe un int de posicion y devuekve un nombre de la tabla
	 * 		 creada segun la posicion que se le haya enviado.
	 */
	public static String devEstadio(int posicion) {
		String[] tabla = new String[] {"Bernabeu", "Camp Nou", "Anefield", "Old Trafford",
				"Parque de los Principes", "Ramon", "Romareda", "Mestalla", "Diego", "Civitas",
				"Salesionados", "Hercules", "Sardinero", "San Mames", "El Aclorraz"};
		return tabla[posicion];
	}
	
	/**
	 * Pre:---
	 * Post: metodo que devuelve un nombre aleatorio generado entre los que existen
	 * 		 en una tabla creada.
	 * @param posicion generada aleatoriamente.
	 * @return el nombre de un equipo segun la posicion.
	 */
	public static String devNomJug() {
		String[] nombreJugador = new String[] { "Hugo", "Mateo", "Martin", "Lucas", "Leo",
				"Daniel", "Alejandro", "Adrian", "Manuel", "Andres", "Jesus", "Marcelo",
				"Ivan", "Fran", "Alex", "David", "Matias", "Dwayne", "Carlos", "Antonio",
				"Maverick", "Elvis", "Diego", "Alan", "Marcos", "Juan", "Pablo", "Guillermo",
				"Rigo", "Joseph", "Fernando", "Raul", "Cuasi", "Kratos", "Atreus", "Mimir",
				"Odin", "Thor", "Loki", "Logan", "Miles"};
		return nombreJugador[(int) Math.floor(Math.random()*(40-0)+0)];
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametro el objeto Liga champions, llama al metodo
	 * 		 menu() y pide al usuario que ingrese un entero (1-5) para segun eso llamar
	 * 		 a un metodo o llamar a otro.
	 * @param champions
	 */
	public static void ejecutor(Liga champions) {
		Scanner selector = new Scanner(System.in);
		int eleccion = 0;
		while(true) {
			menu();
			System.out.println("Elija una opcion(1-5):");
			eleccion = selector.nextInt();
			if(eleccion >= 1 && eleccion <= 5) {
				if(eleccion == 1) {
					champions.ordenarEquipos();
				} else if(eleccion == 2) {
					champions.maxJugadores(true);
				} else if(eleccion == 3) {
					champions.maxJugadores(false);
				} else if(eleccion == 4) {
					champions.equiposGoleadores();
				} else if(eleccion == 5) {
					System.out.println("Programa finalizado.");
					break;
				}
			} else {
				System.out.println("Eleccion no valida.");
			}
		}
	}
	/**
	 * Pre:---
	 * Post: metodo que muestra por pantalla el menu con las opciones que
	 * 		 tiene el usuario.
	 */
	public static void menu() {
		System.out.println("1. Visualizar clasificacion ordenada por puntos.");
		System.out.println("2. Visualizar los 5 maximos goleadores.");
		System.out.println("3. Visualizar los 5 jugadores con mas explusiones.");
		System.out.println("4. Obtener los 3 equipos mas goleadores.");
		System.out.println("5. Salir.");
	}
}
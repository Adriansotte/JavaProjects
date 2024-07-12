package practica7Aeropuerto;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programa que simula un control de accesos de un aeropuerto
 * utilizando estructura de datos propias, el funcionamiento es:
 * se registra un usuario, el usuario pasa a la lista de espera,
 * se hace pasar al usuario a su avion, la pila y la cola tienen
 * un maximo de 3 y 2 respectivamente.
 * @author Adri
 */
public class Main {
	
	// Declaramos las variables globales que vamos a ir utilizando en el codigo.
	private static Scanner n;
	private static Pila pila;
	private static Cola cola;
	private static ListaSimple listaSimple;
	
	/**
	 * Pre:---
	 * Post: metodo que inicializa la lista, la cola, la pila y el scanner
	 * 		 ademas rodea con un tryCatch el metodo donde se desarrolla 
	 * 		 el programa.
	 */
	public static void main(String[] args) {
		System.out.println("----BIENVENIDO GESTOR DE AEROPUERTO----");
		n = new Scanner(System.in);
		pila = new Pila();
		cola = new Cola();
		listaSimple = new ListaSimple();
		try {
			ejecutor();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo principal el cual sirve como menu para desarrollar las
	 * 		 distintas opciones que tiene el usuario.
	 */
	public static void ejecutor() {
		while(true) {
			menu();
			String eleccion = pedirOrden("-> ");
			if(eleccion.equalsIgnoreCase("REGISTRAR")) {
				registrarPersona();
			} else if(eleccion.equalsIgnoreCase("PASAR")) {
				if(!cola.isEmpty()) {
					pasarPasajeros();
					comprobarEspera();
				} else {
					System.out.println("No hay mas pasajeros en la cola.");
				}
			} else if(eleccion.equalsIgnoreCase("MOSTRAR")){
				if(listaSimple.getSize() != 0) {
					listaSimple.mostrarAviones();
				} else {
					System.out.println("No hay vuelos.");
				}
			} else if(eleccion.equalsIgnoreCase("LISTAR")){
				cola.show();
				pila.show();
			} else if(eleccion.equalsIgnoreCase("SALIR")){
				break;
			} else {
				System.out.println("Eleccion incorrecta, intenalo de nuevo.");
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que pasa el ultimo objeto de la pila a la ultima posicion
	 * 		 de la cola si la cola no esta a su maximo y la pila aun tiene
	 * 		 pasajeros.
	 */
	public static void comprobarEspera() {
		if(!cola.isFull() && !pila.isEmpty()) {
			Node Pasajero = pila.pop();
			cola.push(Pasajero);
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que saca el primer pasajero de la cola y lo añade al avion
	 * 		 que esta dentro de la listaSimple. Si el avion en el que esta 
	 *		 apuntado el pasajero no existe, se crea un objeto avion y se añade
	 *		 a la lista y se añade al Array de pasajeros que tiene el avion.
	 */
	public static void pasarPasajeros() {
		Node asiento = cola.pop();
		Avion avion = listaSimple.getAvion(asiento.getPasajero().getNumeroAvion());
		if(avion == null) {
			avion  = new Avion(asiento.getPasajero().getNumeroAvion());
			NodeAvion nuevo = new NodeAvion(avion);
			listaSimple.add(nuevo);
		} 
		avion.getPasajeros().add(asiento.getPasajero());
		System.out.println("Pasajero añadido al avion numero: " + avion.getNumero());
	}
	
	/**
	 * Pre:---
	 * Post: metodo que comprueba si la cola y la fila estan llenas, si no estan llenas
	 * 		 añade primero a la cola y si la cola esta vacia, añade a la pila.
	 */
	public static void registrarPersona() {
		if(cola.isFull() && pila.isFull()) {
			System.out.println("No se pueden añadir porque ambas estan llenas");
		} else {
			Pasajero pasajero = crearPasajero();
			Node asiento = new Node(pasajero);
			if(!cola.isFull()) {
				System.out.println(pasajero.getNombre() + " se ha metido en la cola.");
				cola.push(asiento);
			} else {
				System.out.println(pasajero.getNombre() + " se ha metido en la pila");
				pila.push(asiento);
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que pide al usuario los datos necesarios para crear un
	 * 		 objeto de tipo Pasajero y devolverlo.
	 */
	public static Pasajero crearPasajero() {
		String nombre = pedirOrden("Introduce su nombre: ");
		String dni = pedirOrden("Dame su Dni: ");
		int vuelo = solicitarNumero("Dame el numero de vuelo: ");
		return new Pasajero(dni, nombre, vuelo);
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametros un Scanner y un mensaje a mostrar por
	 * 		 pantalla para soliictar al usuario un numero, devuelve un numero entero.
	 */
	public static int solicitarNumero(String preg) {
		int numero = 0;
		while(true) {
			try {
				System.out.print(preg);
				numero = n.nextInt();
				if(numero > 0) {
					n.nextLine();
					return numero;
				} else {
					System.out.println("Vuelo no valido");
				}
			} catch(InputMismatchException e) {
				System.out.println("No reconocido");
				n.nextLine();
			}
		}  
	}
	
	/**
	 * Pre:---
	 * Post: metodo que muestra por pantalla las opciones que tiene el usuario.
	 */
	public static void menu() {
		System.out.println("-> Registrar Usuario [REGISTRAR] \n-> Pasar siguiente a avion [PASAR] \n-> "
				+ "Mostrar Aviones [MOSTRAR]" + "\n-> Listar.[LISTAR]" + "\n-> Salir.[SALIR]");
	}
	
	/**
	 * Pre:---
	 * Post: metodo principal que pide al usuario un String mediante un mensaje
	 * 		 que recibe como parametro.
	 */
	public static String pedirOrden(String preg) {
		System.out.print(preg);
		String orden = n.nextLine().trim();
		return orden;
	}
}
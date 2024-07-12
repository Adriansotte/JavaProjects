package examen3Evaluacion;

import java.util.Random;
import java.util.Scanner;

/**
 * Programa se simula la pelicula de Matrix, basado en un tablero que es
 * infectado por agentes smith, neo se encarga de Desinfectar el tablero.
 */
public class Ejercicio1Matrix {

	private static Scanner n;
	private static Cola cola;
	private static String[] nombres;
	private static Random r;
	private static Personajes[][] matrix;
	private static Neo neo;
	private static Smith smith;
	
	/**
	 * Pre:---
	 * Post: metodo principal donde se inicializan las globales principales,
	 * 		 se ubica a neo y a smith y se rellena la matrix. Por ultimo se llama
	 * 		 al desarrollo del programa para empezar la infeccion de los smiths
	 * 		 y la desinfeccion de Neo.
	 */
	public static void main(String[] args) {	
		n = new Scanner(System.in);
		matrix = new Personajes[5][5];
		r = new Random();
		cola = new Cola();
		nombres = new String[] {"Pepe", "Juan", "Ana", "Sonia", "Pedro", "Chiquito", "Elena"};
		rellenarCola();
		crearNeoySmith();
		ubicar(neo);
		ubicar(smith);
		rellenarMatrix();
		System.out.println("Matrix inicial:");
		mostrarMatrix();
		try {
			matrix();			
		} catch(Exception e) {}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recorre la matriz y muestra su contenido por pantalla
	 */
	public static void mostrarMatrix() {
		System.out.println("-----------------------------------");
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == null) {
					System.out.print("- ");
				} else if(matrix[i][j].getNombre().equalsIgnoreCase("NEO")) {
					System.out.print("N ");
				} else if(matrix[i][j].getNombre().equalsIgnoreCase("SMITH")) {
					System.out.print("S ");
				} else if(matrix[i][j] != null){
					System.out.print("P ");
				} 
			}
			System.out.println("");
		}
		System.out.println("-----------------------------------");
	}
	
	/**
	 * Pre:---
	 * Post: metodo que ubica en la matriz al personaje recibido como parametro.
	 */
	public static void ubicar(Personajes p) {
		int x = r.nextInt(5);
		int y = r.nextInt(5);
		Personajes personaje = matrix[x][y]; 
		if(personaje == null) {
			matrix[y][x] = p;
		} else {
			matrix[y][r.nextInt(5)]= p;
		}
	}
	
	/**
	 * Pre:---
	 * Post: programa principal que ejecuta los turnos segun el enunciado,
	 * 		 si es impar es turno de smith, si es par es turno de neo.
	 * 		 Revisa en cada iteracion las personas que quedan con vida.
	 */
	public static void matrix() {
		double porcentaje = 30;
		int turno = 1;
		while(true) {
			System.out.println("Turno: " + turno);
			revisarVida(porcentaje);
			if(turno % 2 == 0) {
				turnoNeo();
			} else {
				turnoSmith();
			}
			System.out.println("Seleccione 'n' para generar un nuevo turno o 'q' para finalizar: ");			
			String respuesta = pedirOrden();
			if(respuesta.equalsIgnoreCase("Q")) {
				mostrarMatrix();
				break;
			}
			rellenarMatrix();
			mostrarMatrix();
			porcentaje = porcentaje * 0.9;
			turno++;
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que se asegura que el valor introducido por el usuario es o q o n
	 */
	public static String pedirOrden() {
		while(true) {
			String letra = n.nextLine();
			if(letra.equalsIgnoreCase("N") || letra.equalsIgnoreCase("Q")) {
				return letra;
			} else {
				System.out.println("Opcion no valida introduce de nuevo.");
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: turno de neo, se reccore la tabla en busqueda de la ubicacion de neo
	 * 		 y se elimina a los smiths adyacentes.
	 */
	public static void turnoNeo() {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] != null && matrix[i][j].getNombre().equalsIgnoreCase("NEO")) {
					derrotar(i, j);
				}
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que elimina a los sugetos smiths adyacentes e intercambia la
	 * 		 posicion de neo.
	 */
	public static void derrotar(int fila, int columna) {
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				try {
					if(matrix[i + fila][j+ columna].getNombre().equalsIgnoreCase("SMITH")) {
						matrix[i + fila][j+ columna] = null;
					}
				} catch(Exception e) {}
			}
		}
		int x = r.nextInt(5);
		int y = r.nextInt(5);
		Personajes p = matrix[x][y];
		if(matrix[x][y] == null || p.getNombre().equalsIgnoreCase("SMITH")) {
			matrix[x][y] = neo;
			matrix[fila][columna] = null;
		} else {
			matrix[fila][columna] = p;
			matrix[x][y] = neo;
		} 
	}
	
	/**
	 * Pre:---
	 * Post: metodo que desarrolla el turno de Smith, infectando a los personajes a su alrededor
	 *		 menos a neo.
	 */
	public static void turnoSmith() {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				try {
					if(matrix[i][j].getNombre().equalsIgnoreCase("SMITH")) {
						infectar(i, j);
					}
				} catch(Exception e) {}
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que infectaa todos los perosnajes adyacentes al señor smith, segun su poder
	 * 		 de infectacion.
	 */
	public static void infectar(int fila, int columna) {
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				try {
					if(!matrix[i + fila][j+ columna].getNombre().equalsIgnoreCase("NEO")) {
						matrix[i + fila][j+ columna] = new Smith(0, "Smith", 0, 6);
					}
				} catch(ArrayIndexOutOfBoundsException e) {}
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metoto que recorre la tabla revisando la vida de los personaes, si la vida
	 * 		 es menor al porcentaje estipulado la persona es reemplazada.
	 */
	public static void revisarVida(double porcentaje) {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] != null) {
					if(!matrix[i][j].getNombre().equalsIgnoreCase("NEO") && 
							!matrix[i][j].getNombre().equalsIgnoreCase("SMITH")) {
						Generico nuevo = (Generico) matrix[i][j];
						if(nuevo.getVida() < porcentaje && !cola.isEmpty()) {
							matrix[i][j] = cola.pop();
						}
					}
				}
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: se crea a neo y al señor smith
	 */
	public static void crearNeoySmith() {
		int elegido = r.nextInt(100);
		if(elegido < 50) {
			neo = new Neo(0, "Neo", 0, true);
		} else {
			neo = new Neo(0, "Neo", 0, false);
		}
		smith = new Smith(0, "Smith", 0, 6);
	}
	
	/**
	 * Pre:---
	 * Post: metodo que rellena la matrix una vez neo y smith estan ya dentro.
	 */
	public static void rellenarMatrix() {
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				if(matrix[i][j] == null) {
					matrix[i][j] = cola.pop();
				}
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que rellena la cola de genericos para luego ir metiendolos
	 * 		 a la matrix.
	 */
	public static void rellenarCola() {
		for(int i = 0; i < 200; i++) {
			Generico generico = new Generico(i, nombres[r.nextInt(nombres.length)], 0, r.nextInt(101));
			NodeMatrix nuevo = new NodeMatrix(generico);
			cola.push(nuevo);
		}
	}
}

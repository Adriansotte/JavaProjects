package subirNota;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase que simula el mecanismo de juego del videjuego League of
 * Legends, contiene su tablero, los personajes que lo comprenden,
 * las torres.
 */
public class Main {

	private static Personaje[][] tableroInicial;
	private static Random r;
	private static Scanner n;
	private static String primerEquipo;
	private static Cola cola;
	private static Personaje[][] tableroAnterior;
	
	/**
	 * Pre:---
	 * Post: metodo principal en el cual se inicializan las variables globales,
	 * 		 y se llama al metodo donde se realiza el juego. 
	 */
	public static void main(String[] args) {
		System.out.println("----BIENVENIDO AL LEAGUE OF LEGENDS----");
		r = new Random();
		n = new Scanner(System.in);
		primerEquipo = primerEquipo();
		tableroAnterior = new Personaje[10][10];
		System.out.println("El equipo " + primerEquipo + " empieza primero.");
		posicionarTablero();
		mostrarTablero(tableroInicial);
		empezarTurno();
		juego();
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual rellena la cola segun el el equipo que vaya primero
	 */
	public static void empezarTurno() {
		cola = new Cola();
		if(primerEquipo.equalsIgnoreCase("AZUL")) {
			primeroAzules();
		} else {
			primeroRojos();
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que almacena en la cola los personajes, primero los azules.
	 */
	public static void primeroAzules()  {
		for(int i = 0; i < tableroInicial[9].length; i++) {
			if(tableroInicial[1][i] != null) {
				Nodo n = new Nodo(tableroInicial[1][i]);	
				cola.push(n);
			}
		}
		for(int i = 0; i < tableroInicial[1].length; i++) {
			if(tableroInicial[8][i] != null) {
				Nodo n = new Nodo(tableroInicial[8][i]);
				cola.push(n);
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que almacena los personajes en la cola, primero los rojos.
	 */
	public static void primeroRojos()  {
		for(int i = 0; i < tableroInicial[1].length; i++) {
			if(tableroInicial[8][i] != null) {
				Nodo n = new Nodo(tableroInicial[8][i]);
				cola.push(n);
			}
		}
		for(int i = 0; i < tableroInicial[9].length; i++) {
			if(tableroInicial[1][i] != null) {
				Nodo n = new Nodo(tableroInicial[1][i]);	
				cola.push(n);
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que copia el tablero, para que podamos modificar libremente el
	 * 		 tablero que estamos utilizando.
	 */
	public static void copiarTablero(Personaje[][] tableroCopiado, Personaje[][] copiar) {		
		for(int i = 0; i < tableroCopiado.length; i++) {
			for(int j = 0; j < tableroCopiado[i].length; j++) {
				tableroCopiado[i][j] = copiar[i][j];
			}
		}		
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void juego() {
		Personaje[][] tableroAnterior = new Personaje[10][10];
		copiarTablero(tableroAnterior, tableroInicial);
		Cola auxiliar = new Cola();
		while(!cola.isEmpty()) {
			Personaje[][] tableroTurno = new Personaje[10][10];
			copiarTablero(tableroTurno, tableroAnterior);
			Campeon primero = (Campeon) cola.pop();
			Nodo n = new Nodo(primero);
			auxiliar.push(n);
			System.out.println(primero.toString());
			int[] posicion = encontrarCampeon(primero, tableroTurno);
			int enemigos = comprobarPerimetro(posicion[0], posicion[1], primero, tableroTurno);
			menuJugador();
			String orden = pedirOrden("¿Que deseas hacer?");
			try {
				if(orden.equalsIgnoreCase("ATACAR") && enemigos > 0) {
					System.out.println("ataca");
					Campeon enemigo = (Campeon) recogerEnemigo(posicion[0], posicion[1], primero, tableroTurno);
					System.out.println(enemigo);
					if(enemigo != null) {
						int calcularDañoEnemigo = primero.getDaño() - enemigo.getDefensa();
						int calcularDañoAmigo = enemigo.getDaño() - primero.getDefensa();
						enemigo.setVida(enemigo.getVida() - calcularDañoEnemigo);
						primero.setVida(primero.getVida() - calcularDañoAmigo);
						System.out.println("Vida de: " + enemigo.getNombre() + ": " + enemigo.getVida() +
								"\nVida de: " + primero.getNombre() + ": " + primero.getVida());
						if(calcularDañoEnemigo > calcularDañoAmigo) {
							enemigo.aumentarNivel();
							System.out.println(enemigo.getNombre() + " ha subido 1 nivel!!!");
						} else {
							primero.aumentarNivel();
							System.out.println(primero.getNombre() + " ha subido 1 nivel!!!");
						}
						if(enemigo.getVida() < 1) {
							System.out.println("El personaje: " + enemigo.getVida() + " ha muerto y ha sido"
									+ "recolocado");
							recolocarPersonaje(enemigo, tableroTurno, posicion);
						}
						if(primero.getVida() < 1) {
							recolocarPersonaje(primero, tableroTurno, posicion);
							System.out.println("El personaje: " + primero.getVida() + " ha muerto y ha sido"
									+ "recolocado");
						}
					}
				} else if(orden.equalsIgnoreCase("CURAR")) {
					primero.setVida(primero.getVida() + 10);
					System.out.println("Tu campeon se ha curado 10 puntos de vida.");
				} else if(orden.equalsIgnoreCase("W")){
					if(tableroAnterior[posicion[0] - 1][posicion[1]] == null) {
						tableroTurno[posicion[0] - 1][posicion[1]] = primero;
						tableroTurno[posicion[0]][posicion[1]] = null;
					} else {
						System.out.println("No te puedes mover porque esta ocupado el sitio.");
					}
				} else if(orden.equalsIgnoreCase("A")){
					if(tableroAnterior[posicion[0]][posicion[1] - 1] == null) {
						tableroTurno[posicion[0]][posicion[1] - 1] = primero;
						tableroTurno[posicion[0]][posicion[1]] = null;
					} else {
						System.out.println("No te puedes mover porque esta ocupado el sitio.");
					}
				} else if(orden.equalsIgnoreCase("S")){
					if(tableroAnterior[posicion[0] + 1][posicion[1]] == null) {
						tableroTurno[posicion[0] + 1][posicion[1]] = primero;
						tableroTurno[posicion[0]][posicion[1]] = null;
					} else {
						System.out.println("No te puedes mover porque esta ocupado el sitio.");
					}
				} else if(orden.equalsIgnoreCase("D")){
					if(tableroAnterior[posicion[0]][posicion[1] + 1] == null) {
						tableroTurno[posicion[0]][posicion[1] + 1] = primero;
						tableroTurno[posicion[0]][posicion[1]] = null;
					} else {
						System.out.println("No te puedes mover porque esta ocupado el sitio.");
					}
				}
				if(cola.isEmpty()) {
					renovarCola(auxiliar);
				}
				copiarTablero(tableroAnterior, tableroTurno);
				mostrarTablero(tableroTurno);
				if(tableroTurno[0][4].getVida() < 1) {
					System.out.println("El equipo ROJO ha ganado");
					break;
				}
				if(tableroTurno[9][4].getVida() < 1) {
					System.out.println("El equipo AZUL ha ganado");
					break;
				}
			} catch(Exception e) {
				e.printStackTrace();
				System.out.println("Posicion no permitida.");
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que dado un personaje que ha muerto, lo recoloca en su situacion inicial.
	 */
	public static void recolocarPersonaje(Campeon personaje, Personaje[][] tableroTurno, int[] posicion) {
		int[] indices = encontrarCampeon(personaje, tableroInicial);
		tableroTurno[indices[0]][indices[1]] = personaje;
		tableroTurno[posicion[0]][posicion[1]] = null;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que renueva la cola segun el orden establecido una vez que la cola
	 * 		 principal se haya vaciado.
	 */
	public static void renovarCola(Cola auxiliar) {
		while(!auxiliar.isEmpty()) {
			Personaje p = auxiliar.pop();
			Nodo n = new Nodo(p);
			cola.push(n);
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que informa sobre el menu de juego al usuario.
	 */
	public static void menuJugador() {
		System.out.println("--> Moverse A / S / W / D \n--> Atacar [ATACAR]\n--> Curar [CURAR]");
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recorre el tablero y devuelve las coordenadas del
	 * 		 objeto pasado como parametro.
	 */
	public static int[] encontrarCampeon(Campeon primero, Personaje[][] tableroTurno) {
		for(int i = 0; i < tableroTurno.length; i++) {
			for(int j = 0; j < tableroTurno[i].length; j++) {
				if(tableroTurno[i][j] != null) {
					if(tableroTurno[i][j].getNombre().equalsIgnoreCase(primero.getNombre())) {
						return new int[]{i, j};
					}
				}
			}
		}
		return null;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recorre la tabla y devuelve como parametro el primer enemigo
	 * 		 en que se encuentre adyacente a las coordenadas enviadas.
	 */
	public static Personaje recogerEnemigo(int fila, int columna, Campeon primero, Personaje[][] tableroTurno) {
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				try {
					if(tableroTurno[i + fila][j+ columna] != null) {
						if(!tableroTurno[i + fila][j+ columna].getColor().equalsIgnoreCase(primero.getColor()) &&
								!tableroTurno[i + fila][j+ columna].getNombre().equalsIgnoreCase("Jungla")) {
							return tableroTurno[i + fila][j+ columna]; 
						}						
					}
				} catch(Exception e) {}
			}
		}
		return null;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que comprueba el perimetro de las coordenadas enviadas.
	 * 		 Devuelve un entero que informa al usuario de cuantos enemigos adyacentes tiene.
	 */
	public static int comprobarPerimetro(int fila, int columna, Campeon primero, Personaje[][] tableroTurno) {
		int contador = 0;
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				try {
					if(tableroTurno[i + fila][j+ columna] != null) {
						if(!tableroTurno[i + fila][j+ columna].getColor().equalsIgnoreCase(primero.getColor()) &&
								!tableroTurno[i + fila][j+ columna].getNombre().equalsIgnoreCase("Jungla")) {
							contador++;
						}						
					}
				} catch(Exception e) {}
			}
		}
		System.out.println("Tienes: " + contador + " enemigos a tu alrededor.");
		return contador;
	}
	
	
	/**
	 * Pre:---
	 * Post: metodo el cual mediante un random selecciona que equipo sale primero y que
	 * 		 equipo sale segundo.
	 */
	public static String primerEquipo() {
		boolean random = r.nextBoolean();
		if(random) {
			return "AZUL";
		} else {
			return "ROJO";			
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que rellena el tablero de inicio de la partida.
	 */
	public static void posicionarTablero() {
		tableroInicial = new Personaje[10][10];
		for(int i = 0; i < tableroInicial.length; i++) {
			for(int j = 0; j < tableroInicial[i].length; j++) {
				if(i == 0 && j == 4) {
					tableroInicial[i][j] = new Campeon("NEXO", 10, 0, "Azul", 0);
				} else if(i == 9 && j == 4) {
					tableroInicial[i][j] = new Campeon("NEXO", 10, 0, "Rojo", 0);
				} else if(i == 1 & j % 2 == 0) {
					tableroInicial[i][j] = new Campeon("CAMPEONAZUL" + j, 100, r.nextInt(10), "Azul", r.nextInt(10));
				} else if(i == 8 && j % 2 == 0) {
					tableroInicial[i][j] = new Campeon("CAMPEONROJO" + j, 100, r.nextInt(10), "Rojo", r.nextInt(10));
				} else if((i > 1 && i < 8) && (j == 2 || j == 3 || j == 6 || j == 7)) {
					tableroInicial[i][j] = new Personaje("Jungla");
				}
			}
		}	
	}
	
	/**
	 * Pre:---
	 * Post: metodo que muestra por pantalla el contenido del tablero.
	 */
	public static void mostrarTablero(Personaje[][] tablero) {
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				if(tablero[i][j] == null) {
					System.out.print("  ");
				} else if(tablero[i][j].getNombre().equalsIgnoreCase("NEXO")) {
					System.out.print("N ");
				} else if(tablero[i][j].getNombre().contains("CAMPEONAZUL")) {
					System.out.print("A ");
				} else if(tablero[i][j].getNombre().contains("CAMPEONROJO")) {
					System.out.print("R ");
				} else if(tablero[i][j].getNombre().equalsIgnoreCase("MINION")) {
					System.out.print("M ");
				} else if(tablero[i][j].getNombre().equalsIgnoreCase("JUNGLA")) {
					System.out.print("- ");
				}
			}
			System.out.println("");
		}	
	}
	
	/**
	 * Pre:---
	 * Post: metodo que pide al usuario una orden. Comprueba que esta orden siga
	 * 		 con unas directrices y lo devuelve como parametro.
	 */
	public static String pedirOrden(String orden) {
		System.out.println(orden);
		while(true) {
			String movimiento = "AWSDawsd";
			String letra = n.nextLine();
			if(letra.equalsIgnoreCase("ATACAR")) {
				return letra;
			} else if(letra.equalsIgnoreCase("CURAR")) {
				return letra;
			} else if(movimiento.contains(letra)) {
				return letra;
			} else {
				System.out.println("Opcion no valida, introducela de nuevo.");
			}
		}
	}
}

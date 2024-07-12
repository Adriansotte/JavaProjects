package juegoVida;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Vamos a desarrollar un programa el cual simule la evolucion de varias
 * generaciones de celulas segun unas condiciones dadas segun el juego de
 * la vida. Para esto vamos a utilizar varios metodos, los cuales: creen,
 * cambien, registren informacion, rellenen nuevas generaciones y muestren
 * por pantalla cada una de las generaciones de las celulas.
 */
public class JuegoVida {
	
	/**
	 * Pre: ---
	 * Post: metodo principal el cual da la bienvenida al usuario, y da las opciones
	 * 		 que tiene el usuario para interactuar con el programa. Consta de un menu
	 * 	 	 con tres opciones y cada una de las opciones tienen sus distintas 
	 * 		 funcionalidades
	 */
	public static void main(String[] args) {
		System.out.println("---BIENVENIDO AL JUEGO DE LA VIDA---");
		Scanner n = new Scanner(System.in);
		ArrayList<Tripleta> resultado = new ArrayList<>();
		int modo;
		while(true) {
			menu();
			modo = solicitarUsuario(n, "Elija modo(1-3) --> ");
			if(modo == 1) {
				int filas = solicitarUsuario(n, "Numero de filas: ");
				int columnas = solicitarUsuario(n, "Numero de columnas: ");
				int numGeneraciones = solicitarUsuario(n, "Numero de generaciones: ");
				boolean[][] primeraGeneracion = hacerGeneracion(filas, columnas, resultado);
				ejecutor(primeraGeneracion, numGeneraciones, resultado);
				enseñarResultado(resultado);
				break;
			} else if(modo == 2) {
				ArrayList<boolean[][]> pruebas = hacerPruebas();
				for(int i = 0; i < 3; i++) {
					mostrarCelulas(pruebas.get(i));
					ejecutor(pruebas.get(i), 30, resultado);
				}
				enseñarResultado(resultado);
				break;
			} else if(modo == 3) {
				System.out.println("Programa finalizado.");
				break;
			} else System.out.println("Numero no reconocido, intentelo de nuevo.");
		}
	}
	
	/**
	 * Pre: ---
	 * Post: metodo que muestra por pantalla la informacion almacenada en un ArrayList
	 * 		 de las distintas colonias generadas.
	 */
	public static void enseñarResultado(ArrayList<Tripleta> resultado) {
		for(int i = 0; i < resultado.size(); i++) {
			System.out.println("Generacion " + resultado.get(i).getNumIteracion() + 
					" Celulas vivas: " + resultado.get(i).getNumCelulasVivas() +
					" Con respecto al anterior: " + resultado.get(i).getNumCelulasNuevas());
		} 
	}
	
	/**
	 * Pre:---
	 * Post: metodo que genera la primera generacion de celulas basandose
	 * 	 	 en los parametros que ha introducido el usuario anteriormente
	 * 		 y almacena dicha generacion en un ArrayList que almacenara la
	 * 		 informacion de las siguientes generaciones.
	 */
	public static boolean[][] hacerGeneracion(int f, int c, ArrayList<Tripleta> resultado) {
		int numero;
		int celulasVivas = 0;
		boolean[][] celulas = new boolean[f][c];
		for(int i = 0; i < celulas.length; i++) {
			for(int j = 0; j < celulas[i].length; j++) {
				numero = (int) Math.floor(Math.random()*(9-0)+0);
				if(numero > 4) {
					celulas[i][j] = true;
					celulasVivas += 1;
				} else celulas[i][j] = false;
			}
		} mostrarCelulas(celulas);
		Tripleta primera = new Tripleta(0, celulasVivas, 0);
		resultado.add(primera);
		return celulas;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que mediante un bucle con tantas iteraciones haya seleccionado el usuario
	 * 	 	 genera tablas de booleans y las rellena de manera que cada tabla nueva se base
	 * 	 	 en la tabla generada con anterioridad, recibe como parametros la primera tabla
	 * 	 	 generada, el numero de generaciones a iterar y un ArrayList donde almacena
	 * 		 informacion de cada tabla generada en el bucle.
	 */
	public static void ejecutor(boolean[][] tabla, int generaciones, ArrayList<Tripleta> resultado) {
		boolean comprobacion;
		for(int i = 1; i <= generaciones; i++) {
			boolean[][] nueva = new boolean[tabla.length][tabla[0].length];
			nueva = rellenarTabla(tabla, resultado, i);
			System.out.println("GENERACION -> " + i);
			comprobacion = comprobarTabla(nueva);
			if(!comprobacion) {
				System.out.println("------COLONIA EXTINTA------");
				break;
			} else {
				tabla = intercambiarGeneraciones(nueva);
				mostrarCelulas(nueva);
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que se utiliza para copiar loas datos de una tabla a otra,
	 * 		 recibe como parametro una tabla de booleans y devuelve la tabla 
	 * 		 una vez este copiada.
	 */
	public static boolean[][] intercambiarGeneraciones(boolean[][] n) {
		boolean[][] copia =  new boolean[n.length][n[0].length];
		for(int i = 0; i < n.length; i++) {
			for(int j = 0; j < n[i].length; j++) {
				copia[i][j] = n[i][j];
			}
		} return copia;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que comprueba si en la tabla recibida como parametro aun existen
	 * 		 celulas vivas, si es asi devuelve un "TRUE" sino devuelve un "FALSE".
	 */
	public static boolean comprobarTabla(boolean[][] n) {
		for(int i = 0; i < n.length; i++) {
			for(int j = 0; j < n[i].length; j++) {
				if(n[i][j]) return true;
			}
		}
		return false;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que se encarga de la creacion de una nueva tabla de celulas, la cual se rellenara
	 * 		 segun las condiciones descritas basandose en una tabla recibida como parametro. Una vez
	 * 		 rellenada se agrega al ArrayList y se devuelve la tabla.
	 */
	public static boolean[][] rellenarTabla(boolean[][] vieja, ArrayList<Tripleta> resultado,  int ite) {
		boolean[][] nueva = new boolean[vieja.length][vieja[0].length];
		int vivas = 0;
		int contador = 0;
		int nuevas = 0;
		for(int i = 0; i < nueva.length; i++) {
			for(int j = 0;  j < nueva[i].length; j++) {
				contador = contarCelulas(vieja, i, j);
				if(vieja[i][j]) {
					nuevas++;
					if(contador < 2) {
						nueva[i][j] = false;
					} else if(contador == 2 || contador == 3) {
						nueva[i][j] = true;
						vivas++;
					} else if(contador < 3) {
						nueva[i][j] = false;
					}
				} else if(!vieja[i][j]) {
					if(contador == 3) {
						nueva[i][j] = true;
						vivas++;
					} else nueva[i][j] = false;
				} 
			}
		}
		Tripleta nuevaColonia = new Tripleta(ite, vivas, vivas - nuevas);
		resultado.add(nuevaColonia);
		return nueva;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametro una tabla de booleans, de la cual va a
	 * 		 comprobar la celda mediante la fila y la columna recibidas como parametros.
	 * 		 Se cuenta el numero de "Celulas existentes" alrededor de dicha celda mediante
	 * 		 un bucle anidado de 3x3 que va desde la posicion "-1" a la "1" comprobando 
	 * 		 cada celda y añadiendo al contador. Si la celda enviada por parametro
	 * 		 contiente una celula se resta del contador para simplemente las celulas de
	 * 		 alrededor.
	 */
	public static int contarCelulas(boolean[][] n, int fila, int columna) {
		int cont = 0;
		if(n[fila][columna]) cont--;
		for(int i = -1; i < 2; i++) {
			for(int j = -1; j < 2; j++) {
				try {
					if((n[i + fila][j+ columna])) cont++;
				} catch(ArrayIndexOutOfBoundsException e) {}
			}
		} return cont;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametros un Scanner y un mensaje a mostrar por
	 * 		 pantalla para soliictar al usuario un numero, devuelve un numero entero.
	 */
	public static int solicitarUsuario(Scanner n, String preg) {
		int numero = 0;
		while(true) {
			try {
				System.out.print(preg);
				numero = n.nextInt();
				if(numero > 0) return numero;
				else System.out.println("Numero no valido");
			} catch(InputMismatchException e) {
				System.out.println("No reconocido");
				n.nextLine();
			}
		}  
	}
	
	/**
	 * Pre:---
	 * Post: metodo que muestra por pantalla las opciones que tiene a elegir el usuario.
	 */
	public static void menu() {
		System.out.println("1. MODO NORMAL.");
		System.out.println("2. MODO DE PRUEBAS.");
		System.out.println("3. Salir.");
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametro una tabla de booleans y pinta una tabla
	 * 		 donde intercambia los true por "* ", y los false por "  ".
	 */
	public static void mostrarCelulas(boolean[][] t) {
		pintarLineas(t[0].length * 2);
		for(int i = 0; i < t.length; i++) {	
			System.out.print("|");
			for(int j = 0; j < t[i].length; j++) {
				if(t[i][j]) System.out.print("* ");
				else System.out.print("  ");
			} System.out.println("|");
		}
		pintarLineas(t[0].length * 2);
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametro la longitud a pintar y genera una parte
	 * 		 del recuadro de la generacion.
	 */
	public static void pintarLineas(int longitud) {
		System.out.print("+");
		for(int recuadro = 0; recuadro < longitud; recuadro++) {
			System.out.print("-");
		} System.out.println("+");
	}
	
	/**
	 * Pre:---
	 * Post: metodo que genera un ArrayList donde guarda las tablas de booleanos que
	 * 		 contienen los patrones para hacer las pruebas del programa y devuelve el
	 * 		 ArrayList.
	 */
	public static ArrayList<boolean[][]> hacerPruebas() {
		ArrayList<boolean[][]> pruebas = new ArrayList<>();
		boolean[][] primera = new boolean[][] {{false, false, false, false},
			{false, true, true, false}, {false, true, true, false}, 
			{false, false, false, false}};
		boolean[][] segunda = new boolean[][] {{false, false, false, false, false},
			{false, false, false, false, false}, {false, true, true, true, false},
			{false, false, false, false, false}, {false, false, false, false,  false}};
		boolean[][] tercera = new boolean[][] {{false, false, false, false, false, false},
			{false, true, true, false, false, false}, {false, true, true, false, false, false},
			{false, false, false, true, true, false}, {false, false, false, true, true, false},
			{false, false, false, false, false, false}};
		pruebas.add(primera);
		pruebas.add(segunda);
		pruebas.add(tercera);
		return pruebas;
	}
}
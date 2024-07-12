package wordle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Es un programa el cual sirve de ayuda para completar el juego llamado
 * Wordle, funciona de la sigueinte manera: el usuario esribe las posiciones
 * y las letras que van en esas posiciones, luego introduce todas las letras
 * que no deben estar en esas palabras a buscar. Por ultimo el programa
 * mediante un fichero de texto que contiene todas las palabras del diccionario
 * selecciona las que tengan cinco caracteres y que no contengan las letras 
 * que ha dicho el usuario que no deben aparecer y muestra las posibles soluciones
 * segun las indicaciones del usuario.
 */
public class Wordle {
	
	/**
	 * Pre:---
	 * Post: metodo principal donde se crea una variable tipo Scanner
	 * 		 se da la bienvenida al usuario y se rodea mediante un try
	 * 		 catch el metodo ejecutor para evitar posibles fallos.
	 */
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		System.out.println("----BIENVENIDO A WORDLE----");
		try {
			ejecutor(n);
		} catch (Exception e) {}
		
	}
	
	/**
	 * Pre:---
	 * Post: metodo ejecutor donde se crean: las palabras a buscar en el
	 * 		 diccionario y las palabras que no deben estar en la busqueda
	 * 		 mediante dos tablas de Strings
	 */
	public static void ejecutor(Scanner n) {
		String[] palabra = hacerPalabra(n);
		String[] noEstan = noEstan(n, "Dime las que no estan ej: \"jnkcb\" ");
		enseñarPalabra(palabra);
		ArrayList<String> letras = devolverPalabras(noEstan);
		comprobarExistencias(palabra, letras);
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametro un Scanner para preguntar al
	 * 		 usuario y la pregunta, pide al usuario las letras que no deben
	 * 		 estar en la palabra y crea una tabla de String que se devuelve.
	 */
	public static String[] noEstan(Scanner n, String preg) {
		System.out.println(preg);
		String ausentes = n.nextLine();
		String[] noEstan = ausentes.split("");
		return noEstan;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que comprueba las concidencias que hay entre la palabra
	 * 		 introducida por el usuario y las palabras del diccionario, si
	 * 		 son coincidientes la muestra por pantalla
	 */
	public static void comprobarExistencias(String[] palabra, ArrayList<String> letras) {
		boolean comprobacion = true;
		int cont = 0;
		for(int i = 0; i < letras.size(); i++) {
			String[] aComprobar = letras.get(i).split("");
			comprobacion = comprobar(aComprobar, palabra);
			if(comprobacion) {
				System.out.println(letras.get(i));
				cont++;
			}
		}
		System.out.println("Posibles resultados: " + cont);
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual recibe dos tablas de String y que verifica los index de
	 * 		 la tabla los cuales tengan un valor que no sea null, si todos los caracteres
	 * 		 que no sean nulos devolvera un True, sino devolvera un false.
	 */
	public static boolean comprobar(String[]a, String[] p) {
		for(int i = 0; i < p.length; i++) {
			if(p[i] != null && !p[i].toLowerCase().equals(a[i].toLowerCase())) return false;
		} 
		return true;
	}
	/**
	 * Pre:---
	 * Post: metodo el cual genera una tabla de String donde almacenara las letras
	 * 		 que el usuario introduzca para luego devolver dicho String para la 
	 *  	 comparacion con el diccionario.
	 */
	public static String[] hacerPalabra(Scanner n) {
		String[] palabra = new String[5];
		int cantidadLetras = pedirNumero(n, "¿Cuantas letras desea introducir? 1-5 ");
		palabra = pedirPalabra(n, cantidadLetras);
		return palabra;
	}
	
	/**
	 * Pre:---
	 * Post: metodo en el cual mediante un bucle con el numero de iteraciones
	 * 		 introducido por el usuario, crea una tabla unidimensional de String
	 * 		 luego pregunta al usuario el index de la tabla y el valor que le va
	 * 		 a dar al index, para luego devolver la tabla de String.
	 */
	public static String[] pedirPalabra(Scanner n, int cant) {
		String[] palabra = new String[5];
		for(int i = 0; i < cant; i++) {
			int index = pedirNumero(n, "Dame la posicion (1-5): ");
			n.nextLine();
			String letra = pedirLetra(n, "Dame una letra: ");
			n.nextLine();
			palabra[index - 1] = letra;
		} 
		return palabra;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que pide al usuario una letra, verifica que el caracter
	 * 		 introducido por el usuario sea valido, y si es asi devuelve
	 * 		 dicho caracter.
	 */
	public static String pedirLetra(Scanner n,  String preg) {
		String[] caracteresNulos = new String[] {"0", "1", "2", "3", "4", "5", "6",
				"7", "8", "9"};
		while(true) {
			System.out.print(preg);
			String letra = n.next();
			boolean comp = comprobarNoEstan(letra, caracteresNulos);
			if(comp) return letra;
			else System.out.println("Caracter no valido.");
		}
		
	}
	
	/**
	 * Pre:---
	 * Post: metodo que pide al usuario un numero mediante un mensaje
	 * 		 orientetivo que enseña por consola. Devuelve un entero.
	 */
	public static int pedirNumero(Scanner n, String preg) {
		int numero = 0;
		while(true) {
			try {
				System.out.print(preg);
				numero = n.nextInt();
				if(numero > 0 && numero < 6) return numero;
				else System.out.println("Numero no valido");
			} catch(InputMismatchException e) {
				System.out.println("No reconocido");
				n.nextLine();
			}
		} 
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametro una tabla de String donde estan
	 * 	 	 las letras que no deben contener las palabras a devolver, Lee un
	 * 		 fichero donde estan las palabras del dicionario y selecciona las
	 * 		 que tengan 5 caracteres y que no contengan las letras de la tabla
	 * 		 de string y las mete dentro de un ArrayList que devolvera.
	 */
	public static ArrayList<String> devolverPalabras(String[] noEstan) {
		ArrayList<String> letras = new ArrayList<>();
		File diccionario = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\diccionario.txt");
		try {
			Scanner n = new Scanner(diccionario);
			while(n.hasNextLine()) {
				String palabra = n.nextLine().trim();
				boolean comprobar = comprobarNoEstan(palabra, noEstan);
				if(palabra.length() == 5 && comprobar) {
					letras.add(palabra);
				}
			} n.close();	
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		return letras;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametros una palabra y una tabla
	 * 		 de string con las letras que se deben buscar, realiza un bucle
	 * 		 que va comprobando si la palabra contiene la letra de la iteracion
	 * 		 y si es asi devuelve un false, si no contiene ninguna letra de la
	 * 		 la tabla devuevle un true.
	 */
	public static boolean comprobarNoEstan(String p, String[] noEstan) {
		for(int i = 0; i < noEstan.length; i++) {
			if(p.toLowerCase().contains(noEstan[i])) return false;
		} 
		return true;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametro una tabla unidimensional donde
	 * 		 estan las palabras que ha introducido el usuario y lo enseña 
	 * 		 por pantalla.
	 */
	public static void enseñarPalabra(String[] palabra) {
		for(int i = 0; i < palabra.length; i++) {
			if(palabra[i] != null) System.out.print(palabra[i]);
			else System.out.print("-");
		} 
		System.out.println("");
	}
}
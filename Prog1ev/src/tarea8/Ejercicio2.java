package tarea8;

import java.util.Scanner;

/**
 * Implementa un método Java llamado incrementarValores, el
 * cual recibe una tabla y un valor numérico, y devuelve todos los elementos
 * de la tabla multiplicados por dicho valor, excepto el primero y el último.
 */
public class Ejercicio2 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int valor = entrada.nextInt();
		int[] tabla = new int[] {2, 3, 1, 4, 3};
		incrementarValores(tabla, valor);
		for(int i = 0; i < tabla.length; i++) {
			System.out.println(tabla[i]);
		}
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static int[] incrementarValores(int[] tabla, int valor) {
		for(int i = 1; i < tabla.length - 1; i++) {
			tabla[i] *= valor;
		} return tabla;
	}
}

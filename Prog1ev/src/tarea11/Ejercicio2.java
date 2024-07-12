package tarea11;

/**
 * Implementa un programa Java que cree un Array de enteros de longitud 100 y lo
 * rellene con enteros aleatorios entre 1 y 100 (ambos incluidos).
 */
public class Ejercicio2 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		int[] numeros = new int[100];
		for(int i = 0; i < numeros.length ;i++) {
			numeros[i] = (int) Math.floor(Math.random()*(0-100+1)+100);
			System.out.print(numeros[i] + " ");
		}
	}
}

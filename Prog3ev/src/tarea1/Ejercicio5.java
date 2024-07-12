package tarea1;

/**
 * Implementa un programa Java que dada una tabla multidimensional de números enteros,
 * muestre todos los sus elementos por pantalla de forma recursiva.
 */
public class Ejercicio5 {

	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		int[][] numeros = new int[][] {{3, 5, 6, 10, 23, 45}, {2, 65, 1, 7, 9, 4}, {2, 65, 1, 7, 9, 4}};
		mostrarNumeros(numeros, 0, 0);
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void mostrarNumeros(int[][] numeros) {
		mostrarNumeros(numeros, 0, 0);
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	protected static void mostrarNumeros(int[][] numeros, int x, int y) {
		if(y < numeros[x].length) {
			System.out.print(numeros[x][y] + " ");
			mostrarNumeros(numeros, x, y + 1);
		} else if(y == numeros[x].length && x < numeros.length - 1){
			mostrarNumeros(numeros, x + 1, 0);
		} 
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	protected static void solucionAlvaro(int[][] numeros, int i, int j) {
		
	}
}

package tarea7;


/**
  * Implementa un programa Java con un método llamado
  * sum(int [] tabla) que muestre por pantalla el resultado de sumar todos los
  * elementos de la tabla pasada como parámetro.
  */
public class Ejercicio1 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		int[] tabla = new int[] {1, 1, 1, 1, 1, 1, 1, 1};
		System.out.println(sum(tabla));
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static int sum(int[] tabla) {
		int suma = 0;
		for(int i = 0; i < tabla.length; i++) {
			suma += tabla[i];
		}return suma;
	}
}

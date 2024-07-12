package tarea11;

/**
 * Implementa un programa Java que, dados dos Arrays de enteros, indique si
 * ambos son exactamente iguales o no.
 */
public class Ejercicio4 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		int[] tabla1 = {1, 2, 3, 4, 5, 6, 8, 8, 9};
		int[] tabla2 = {1, 2, 3, 4, 5, 6, 8, 8, 9};
		comprobarDatos(tabla1, tabla2);
	}
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void comprobarDatos(int[] tabla1, int[] tabla2) {
		for(int i = 0; i < tabla1.length; i++) {
			if(tabla1[i] != tabla2[i]) {
				System.out.println("Los datos no son iguales: " + tabla1[i] + ", " + tabla2[i]);
				break;
			} else if(i == tabla1.length - 1) {
				System.out.println("Los datos de las tablas son iguales");
			}
		} 
	}
}

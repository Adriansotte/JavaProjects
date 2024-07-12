package tarea7;

/**
 * Implementa un programa Java con un método llamado
 * average(double [] tabla) que devuelva un dato de tipo double, que
 * indique la media de los valores de los elementos de la tabla pasada como
 * parámetro.
 */
public class Ejercicio2 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		double[] tabla = new double[] {11, 4, 7, 30};
		System.out.println(average(tabla));
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static double average(double[] tabla) {
		double suma = 0;
		for(int i = 0; i < tabla.length; i++) {
			suma += tabla[i];
		}
		double media = suma / 4;
		return media;
	}
}

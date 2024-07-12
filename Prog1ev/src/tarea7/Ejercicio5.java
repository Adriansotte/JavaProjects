package tarea7;

/**
 * Implementa un programa Java con un método llamado
 * copyArray(String[] tabla, String[] tabla2) que devuelva “tabla2” con los
 * mismos valores de “tabla”. Es decir, el programa debe copiar el contenido
 * de una tabla en otra.
 */
public class Ejercicio5 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		String[] tabla = new String[5];
		tabla[0] = "hola";
		tabla[1] = "me";
		tabla[2] = "llamo";
		tabla[3] = "adriansote";
		tabla[4] = "fin";
		String[] tabla2 = new String[5];
		copyArray(tabla, tabla2);
		for(int i = 0; i < 5; i++) {
			System.out.println(tabla2[i]);
		}
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static String[] copyArray(String[] tabla, String[] tabla2) {
		for(int i = 0; i < tabla.length; i++) {
			tabla2[i] = tabla[i]; 
		}
		return tabla2;
	}
}

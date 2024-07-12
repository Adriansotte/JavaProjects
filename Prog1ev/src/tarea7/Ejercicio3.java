package tarea7;

/**
 * Implementa un programa Java con un método llamado
 * contains(String[] tabla, String cadena) que devuelva TRUE, sí o solo sí,
 * alguno de los elementos de la tabla pasada como parámetro es igual al
 * valor de la variable “cadena”.
 */
public class Ejercicio3 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		String n = "cadena";
		String n1 = "perro";
		String[] tabla = new String[] {n, n1};
		System.out.println(contains(tabla, n, n1));
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static boolean contains(String[] tabla, String n, String n1) {
		for(int i = 0; i < tabla.length; i++) {
			if(tabla[i].equals("cadena")) {
				return true;
			}
		}
		return false;
	}
}

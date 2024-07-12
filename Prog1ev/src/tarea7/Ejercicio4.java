package tarea7;

/**
 * Implementa un programa Java con un método llamado
 * indexContains(String[] tabla, String cadena) que devuelva el índice de la
 * tabla cuyo valor es igual al valor de “cadena”. En caso de no haber ningún
 * valor igual, devuelve -1
 */
public class Ejercicio4 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		String cadena = "hola";
		String[] tabla = {"hola", "que", "tal"};
		System.out.println(indexContains(tabla, cadena));
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static int indexContains(String[] tabla, String cadena) {
		for(int i = 0; i < tabla.length; i++) {
			if(tabla[i].equals(cadena)) {
				return i;
			} 
		}
		return -1;
	}

}

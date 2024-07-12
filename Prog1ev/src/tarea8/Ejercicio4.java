package tarea8;
/**
 * Implementa un método Java llamado copiarTabla, el cual
 * recibe como parámetro una tabla de Strings, y devuelve una nueva tabla
 * con los elementos en orden inverso.
 */
public class Ejercicio4 {
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		String[] tabla = new String[] {"nada", "puede", "malir", "sal", "porque", "si"};
		copiarTabla(tabla);
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void copiarTabla(String[] tabla) {
		String[] tabla2 = new String[6];
		for(int i = 0; i < tabla.length; i++) {
			tabla2[i] = (tabla[tabla.length-1-i]);
		}
		for(int y = 0; y < tabla.length; y++) {
			System.out.println(tabla2[y]);
		}
	}
}

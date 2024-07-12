package tarea11;

/**
 * Implementa el mismo programa que el ejercicio anterior, pero para dos Arrays
 * de Strings.
 */
public class Ejercicio3 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		String[] tabla1 = {"perro", "gato", "patata"};
		String[] tabla2 = {"perro", "gatos", "patata"};
		compararStrings(tabla1, tabla2);
	}
	/**
	 * Pre:---
	 * Post:
	 */
	public static void compararStrings(String[] tabla1, String[] tabla2) {
		for(int i = 0; i < tabla1.length; i++) {
			if(!tabla1[i].equals(tabla2[i])) {
				System.out.println("Los Strings son distintos: " + tabla1[i] + ", " + tabla2[i]); 
				break;
			} else if(i == tabla1.length - 1) {
				System.out.println("Los Strings de las tablas son iguales");
			}
		}
	}
}

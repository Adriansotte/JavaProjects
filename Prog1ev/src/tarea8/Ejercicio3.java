package tarea8;
/**
 * Implementa un método Java llamado estadisticasTabla, el
 * cual recibe una tabla de enteros y muestra por pantalla: el número de
 * enteros positivos, el número de enteros negativos, el número de 0s, el
 * número de enteros pares y el número de enteros impares.
 */
public class Ejercicio3 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String [] args) {
		int[] tabla = new int[] {-9, -1, 1, 3, -2, -10, 3, -4, 5, -6, 7, -8, 9, -10, 11, 0, 13, 0, 15};
		estadisticasTabla(tabla);
	}
	
	/**
	 * Pre: ---
	 * Post: 
	 */
	public static void estadisticasTabla(int[] tabla) {
		int positivos = 0;
		int negativos = 0;
		int ceros = 0;
		int pares = 0;
		int impares = 0;
		for(int i = 0; i < tabla.length; i++) {
			if(tabla[i] == 0) {
				ceros++;
			} else if(tabla[i] > 0) {
				positivos++;
				if(tabla[i] % 2 == 0) {
					pares++;
				} else {
					impares++;
				}
			} else if(tabla[i] < 0) {
				negativos++;
				if(tabla[i] % 2 == 0) {
					pares++;
				} else {
					impares++;
				}
			} 
		}
		System.out.println("Numeros positivos: " + positivos);
		System.out.println("Numeros negativos: " + negativos);
		System.out.println("Ceros: " + ceros);
		System.out.println("Numeros pares: " + pares);
		System.out.println("Numeros impares: " + impares);
	}
}

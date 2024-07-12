package tarea10;

import java.util.Arrays;

/**
 * Tenemos la siguiente tabla:
 * String nombres[] = {"Pepe", "Juan", "María", "Antonio", "Luisa"};
 * Implementa un programa Java que ordene la tabla anterior alfabéticamente, y
 * muestre el resultado final por pantalla.
 */
public class Ejercicio5 {
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		String nombres[] = {"Aepe", "Duan", "Baría", "Cntonio", "Guisa" ,"Fantonip"};
		//ordenarAlfabeticamente(nombres);
		ordenNombres(nombres);
	}
	/**
	 * Pre:---
	 * Post: ordenar una String alpaebticamente
	 */
	public static void ordenNombres(String[] nombres) {
		for(int i = 0; i < nombres.length - 1; i++) {
			for(int j = 0; j < nombres.length - 1; j++) {
				if(nombres[j].compareTo(nombres[j + 1]) > 0) {
					String aux = "";
					aux = nombres[j];
					nombres[j] = nombres[j+1];
					nombres[j +1] = aux;
				} 
			}
		}
		for(int x = 0; x < nombres.length; x++) {
			System.out.println(nombres[x] + " ");
		}
	}
	/**
	 * Pre:---
	 * Post:
	 */
	public static void ordenarAlfabeticamente(String[] nombres) {
		Arrays.sort(nombres);
		for(int i = 0; i < nombres.length; i++) {
			System.out.println(nombres[i]);
		}
	}
}

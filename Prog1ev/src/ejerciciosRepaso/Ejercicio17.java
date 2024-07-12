package ejerciciosRepaso;

import java.util.Arrays;

/**
 * Escribe un programa Java que encuentre, en un array de enteros, los pares de
 * elementos con mayor y menor separación entre ellos.
 */
public class Ejercicio17 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args)  {
		int[] tabla = {1, 3, 4, 11, 17, 20};
		int mayorDis = 0;
		int menorDis = 100;
		int indiceMayor = 0;
		int indiceMayor2 = 0;
		int indiceMenor = 0;
		int indiceMenor2 = 0;
		for(int i = 0; i < tabla.length; i++) {
			for(int j = 0; j < tabla.length; j++) {
				if(i != j) {
					if(Math.abs(Math.abs(tabla[i]) - Math.abs(tabla[j])) > mayorDis) {
						indiceMayor = i;
						indiceMayor2 = j;
						mayorDis = Math.abs(Math.abs(tabla[i]) - Math.abs(tabla[j]));
					} else if (Math.abs(Math.abs(tabla[i]) - Math.abs(tabla[j])) < menorDis) {
						indiceMenor = i;
						indiceMenor2 = j;
						menorDis = Math.abs(Math.abs(tabla[i]) - Math.abs(tabla[j]));
					}
				}
			}
		} System.out.println("Mayores: " + tabla[indiceMayor] + " " + tabla[indiceMayor2]);
		System.out.println("Menores: " + tabla[indiceMenor] + " " + tabla[indiceMenor2]);
	}
}

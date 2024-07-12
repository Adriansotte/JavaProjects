package ejerciciosRepaso;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Escribe un programa Java que encuentre el segundo elemento más largo de un
 * array de Strings.
 */
public class Ejercicio11 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		String[] tabla = {"Hola", "Adios", "Hasta luego", 
				"Esto es una prueba", "Mas pruebass"};
		String masLargo = "";
		String segundoMasLargo = "";
		if(tabla.length > 1) {
			masLargo = tabla[0];
			for(int i = 1; i < tabla.length; i++) {
				if(tabla[i].length() > masLargo.length()) {
					String aux = masLargo;
					masLargo = tabla[i];
					segundoMasLargo = aux;
				} else if(tabla[i].length() > segundoMasLargo.length() &&
						tabla[i].length() < masLargo.length()) {
					segundoMasLargo = tabla[i];
				}
			}
			System.out.println("El segundo elemento m�s largo es: " + segundoMasLargo);
		} else {
			System.out.println("No hay Strings suficientes para ejecutar el algoritmo");
		}
	}
}

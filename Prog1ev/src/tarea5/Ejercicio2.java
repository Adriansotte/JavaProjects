package tarea5;

import java.util.Scanner;

/**
 * Implementa un programa Java que solicite al usuario dos números reales
 * y muestre TRUE o FALSE dependiendo de si ambos están entre 0.0 y 1.0.
 */
public class Ejercicio2 {
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		System.out.println(probar());
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static boolean probar() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduzca dos numeros reales");
		double a = entrada.nextDouble();
		//System.out.println(a);
		double b = entrada.nextDouble();
		//System.out.println(b);
		if(a >= 0 && a <= 1) {
			if( b >= 0 && b <= 1) {
				return true;
			} else {
				return false;
			}	
		} else{
			return false;
		}
	}
}

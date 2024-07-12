package tarea5;

import java.util.Scanner;

/**
 * Implementa un programa Java que acepte 4 enteros por parte del usuario 
 * y muestre por la pantalla la palabra “Igual” si los 4 enteros son iguales.
 */
public class Ejercicio1 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
	igual();
	}
		
	/**
	 * Pre:---
	 * Post:
	 */
	public static void igual() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Escribe 4 numeros:");  
		String n = entrada.nextLine();  
		String n2 = n.substring(0, 1);
		String n3 = n.substring(1, 2);
		String n4 = n.substring(2, 3);
		String n5 = n.substring(3, 4);
		if(n2.equals(n2)) {
			if(n3.equals(n4)) {
				if(n4.equals(n5)) {
					System.out.println("Los numeros son iguales.");
				}
			}
		}else if(!n2.equals(n2)) {
		System.out.println("Los numeros no son iguales.");
		}
	}	
}


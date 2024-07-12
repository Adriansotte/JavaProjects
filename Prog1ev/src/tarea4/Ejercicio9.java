package tarea4;

import java.util.Scanner;

public class Ejercicio9 {
	/**
	 * Escribe un programa Java que pregunte al usuario por 10 números enteros y muestre por pantalla el número total
	 * de veces que el usuario ha introducido el 0, el número total de enteros mayores que 0 introducidos y 
	 * el número total de enteros menores que 0 introducidos.
	 */
	
	public static void main(String[] args) {
		/**
		 * Pre: ---
		 * Post:
		 */
		
		recuento();
	}
	
	public static void recuento() {
		/**
		 * Pre:---
		 * Post:
		 */
		System.out.println("Escriba diez numeros:");
		System.out.println("El programa se encargara  de clasificarlos.");
		Scanner entrada = new Scanner(System.in);
		int mayorCero = 0;
		int menorCero = 0;
		int igualCero = 0;
		for(int i = 0; i < 10; i++) {
			int x = entrada.nextInt();
			if(x == 0) {
				igualCero++;
			}else if(x > 0) {
				mayorCero++;
			}else if(x < 0) {
				menorCero++;
			}
		}
		System.out.println("Mayores que cero: " + mayorCero + ".");
		System.out.println("Menores que cero: " + menorCero + ".");
		System.out.println("Ceros: " + igualCero + ".");
	}

}

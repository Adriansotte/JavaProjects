package tarea2;

import java.util.Scanner;

public class Ejercicio4 {
	/**
	 *  Escribe un programa Java que pregunte al usuario por 2 números,
	 *  y te muestre por pantalla todos los números situados entre ambos
	 */
	
	public static void main(String[] args) {
		/**
		 *  Pre: ---
		 *  Post:
		 */
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce un numero");
		int x = entrada.nextInt();
		System.out.println("Introduce otro numero");
		int y = entrada.nextInt();
		if(x < y) {
			System.out.println("Los numeros situados entre ellos son:");
			while(x < y - 1) {
			x++;
			System.out.println(x);	
			}
		}
		if(y < x) {
			System.out.println("Los numeros situados entre ellos son:");
			while(y < x - 1) {
			y++;
			System.out.println(y);	
			}
		}
		if(x == y) {
			System.out.println("Son el mismo numero.");
		}
	}
}

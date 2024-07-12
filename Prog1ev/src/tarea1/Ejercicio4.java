package tarea1;

import java.util.Scanner;

/**
 * Implementa un programa Java que PREGUNTE al usuario por dos
 * números enteros (x, y) y muestre por pantalla la suma de ambos.
 */
public class Ejercicio4 {
	
	/**
	 * Pre: ---
	 * Post: 
	 * @return 
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.print("Introduce un entero");
		int x = entrada.nextInt();
		System.out.print("Introduce otro entero");
		int y = entrada.nextInt();
		int suma = x + y;
		System.out.println(suma);
	
	}

}

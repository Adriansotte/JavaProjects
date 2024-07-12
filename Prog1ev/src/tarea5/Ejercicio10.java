package tarea5;

import java.util.Scanner;

/**
 * Implementa un programa Java muestre por pantalla la suma de los dígitos
 * de un número entero. Ej: 23 -&gt; 2 + 3 = 5
 */
public class Ejercicio10 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		suma();
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void suma() {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce un numero y se te dara que numeros lo confroman en su suma.");
		String n = entrada.nextLine();
		int total = 0;
		for(int i = 0; i <= n.length()-1; i++) {
			String sumando = n.substring(i, i + 1);
			int s1 = Integer.parseInt(sumando);
			if(i < n.length()-1) {
				System.out.print(sumando + " + " );
				total = total + s1;
			} if(i == n.length()-1) {
				System.out.print(sumando);
				total = total + s1;
				break;
			}
		} System.out.println(" = " + total +".");
	}
}

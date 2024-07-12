package tarea2;

import java.util.Scanner;

public class Ejercicio9 {
	/**
	 * Escribe un programa Java que pregunte al usuario por 10 números enteros y muestre por pantalla el número total
	 *  de veces que el usuario ha introducido el 0, el número total de enteros mayores que 0 introducidos y 
	 *  el número total de enteros menores que 0 introducidos.
	 */
	
	public static void main(String[] args) {
		/**
		 * Pre:---
		 * Post:
		 */
		
		Scanner entrada = new Scanner(System.in);
		int vecesCero = 0;
		int enterosMayores = 0;
		int enterosMenores = 0;
		int i = 0;
		System.out.println("Introduce numeros negativos y positivos pasando por el cero:");
		while(i < 10) {
			int x = entrada.nextInt();
			if(x == 0)	{
				vecesCero++;
			} else if(x < 0)	{
				enterosMenores++;
			} else if(x > 0)	{
				enterosMayores++;
			}
			i++;
		}
		System.out.println("Numero total de ceros: " + vecesCero +".");
		System.out.println("Numero total de mayores que cero: " + enterosMayores +".");
		System.out.println("Numero total de menores que cero: " + enterosMenores +".");
		
	}

}

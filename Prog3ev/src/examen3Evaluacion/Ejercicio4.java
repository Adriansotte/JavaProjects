package examen3Evaluacion;

import java.util.Scanner;

/**
 * Implementa un método recursivo en Java llamado tablaMultiplicar() que muestre
 * por pantalla la tabla de multiplicar (únicamente de los multiplicadores pares) del número
 * solicitado (hasta multiplicar por 100).
 */
public class Ejercicio4 {
	
	private static Scanner n;
	
	/**
	 * Pre:---
	 * Post: metodo principal donde se llama al metodo recursivo.
	 */
	public static void main(String[] args) {
		n = new Scanner(System.in);
		System.out.println("Dame un numero");
		int numero = n.nextInt();
		tablaMultiplicar(numero);
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametro el numero a calcular y llama
	 * 		 al metodo junto con un indice que enseñara los datos
	 */
	public static void tablaMultiplicar(int numero) {
		tablaMultiplicar(numero, 0);
	}
	
	/**
	 * Pre:---
	 * Post: metodo recursivo que solo enseña la tabla de multiplicar del 0 al
	 * 		 100 de los numeros pares.
	 */
	private static void tablaMultiplicar(int numero, int index) {
		if(index <= 100) {
			System.out.println(numero + " * " + index + " = " + (numero * index));
			tablaMultiplicar(numero, index + 2);
		} else {
			System.out.println("Esta es la tabla de multiplicar de los numeros pares del " + numero);
		}
	}
}

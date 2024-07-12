package tarea3;

import java.util.Scanner;

public class Ejercicio4 {
	/**
	 * ¡IMPLEMENTA TU PRIMER JUEGO! Realiza un programa Java que adivine el número.
	 *  El programa generará un número aleatorio entre 0 y 20 (usando Math.random())
	 *  y luego irá pidiendo números al usuario indicando “mayor” o “menor” según
	 *  sea mayor o menor con respecto al número generado aleatoriamente. 
	 *  El proceso termina cuando el usuario acierta, y deberá mostrar un mensaje
	 *  de felicitaciones junto al número de intentos que ha necesitado el usuario.
	 */
	
	public static void main(String[] args) {
		/**
		 * Pre:---
		 * Post:
		 */
		
		Scanner entrada = new Scanner(System.in);
		double valorEntero = Math.floor(Math.random()*21);
		//System.out.println(valorEntero);
		System.out.println("Intente adivinar el numero entre 0 y 20 que la maquina ha generado");
		System.out.println("Para ello tienes vidas limitadas.");
		for(int i = 5; i >= 0; i--) {
			double x = entrada.nextDouble();
			if(x < 0) {
				System.out.println("Que sea entre 0 y 20 MELON.");
				System.out.println("Te quedan: " + i + " vidas.");
			}
			if(x > 20) {
				System.out.println("Que sea entre 0 y 20 MELON. ");
				System.out.println("Te quedan: " + i + " vidas.");
			}
			if(x == valorEntero && i != 0) {
				System.out.println("¡¡¡HAS GANADO!!! El valor oculto efectivamente es: " + x);
				break;
			}else if(x > valorEntero && x <= 20) {
				System.out.println("Intenta con otro numero menor");
				System.out.println("Te quedan: " + i + " vidas.");
			}else if(x < valorEntero && x >= 0) {
				System.out.println("Intenta con otro numero mayor");
				System.out.println("Te quedan: " + i + " vidas.");
			}
			if(i == 0) {
				System.out.println("Ohhhhh Lo siento pero has perdido. :(");
				System.out.println("El numero es: " + valorEntero);
			}
		}
	}
}

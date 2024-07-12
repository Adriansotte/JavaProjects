package examenAdrianValdivieso;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * En criptografía, el cifrado César, también conocido como cifrado por
 * desplazamiento, código de César o desplazamiento de César, es una de las técnicas
 * de cifrado más simples y más usadas. Es un tipo de cifrado por sustitución en el
 * que una letra en el texto original es reemplazada por otra letra que se encuentra
 * un número fijo de posiciones más adelante en el alfabeto. Por ejemplo, con un 
 * desplazamiento de 3, la A sería sustituida por la D (situada 3 lugares a la derecha
 * de la A), la B sería reemplazada por la E, etc. Este método debe
 * su nombre a Julio César, que lo usaba para comunicarse con sus generales.
 * El cifrado César mueve cada letra un determinado número de espacios en el alfabeto.
 * En este ejemplo se usa un desplazamiento de tres espacios, así que una B en el texto
 * original se convierte en una E en el texto codificado.
 */
public class Ejercicio1 {
	/**
	 * Pre: ---
	 * Post: Metodo principal donde se llama al metodo que va a ejecutar el programa.
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("---PROGRAMA CIFRADOR---");
		try {
			ejecutor(entrada);
		} catch(InputMismatchException e) {
			System.out.println("El dato es erroneo " + e);
		} catch(NumberFormatException e) {
			System.out.println("El dato es erroneo " + e);
		} 
	}
	/**
	 * Pre:
	 * Post: metodo en el cual se recogen los datos para mandarlos al metodo que
	 * 		 realizara la traduccion del mensaje.
	 */
	public static void ejecutor(Scanner entrada ) {
		String[] abecedario = {"a", "b", "c", "d", "e", "f", "g",
				"h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p",
				"q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
				"a", "b", "c", "d", "e", "f", "g"};
		int numero = pedirNumero(entrada);
		String[] palabra = pedirPalabra(entrada);
		traductor(numero, palabra, abecedario);
	}
	/**
	 * Pre:---
	 * Post: metodo en el cual se pregunta al usuario el numero de desplazamientos
	 *       para su traduccion.
	 */
	public static int pedirNumero(Scanner entrada) {
		System.out.println("Introduzca numero: ");
		int numero = entrada.nextInt();
		return numero;
	}
	/**
	 * Pre: ---
	 * Post: metodo en el que se pide al usuario que introduzca el mensaje a traducir.
	 */
	public static String[] pedirPalabra(Scanner entrada) {
		System.out.println("Introduzca palabra: ");
		entrada.nextLine();
		String n = entrada.nextLine();
		int n1 = n.length();
		String[] palabra = new String[n1];
		for(int i = 0; i < palabra.length; i++) {
			palabra[i] = n.substring(i, i + 1);
		} return palabra;
	}
	/**
	 * Pre: ---
	 * Post: metodo que realiza la traduccion y la muestra por pantalla.
	 */
	public static void traductor(int numero, String[] palabra, String[] abecedario) {
		String[] respuesta = new String[palabra.length];
		System.out.print("Cifrado: ");
		for(int i = 0; i < palabra.length; i++) {
			if(!palabra[i].equals(" ")) {
				for(int j = 0; j < abecedario.length - 1; j++) {
					if(palabra[i].equals(abecedario[j])) {
						respuesta[i] = abecedario[j + numero];
						break;
					}
				}
			} else {
				respuesta[i] = " ";
			} System.out.print(respuesta[i]);
		}
	}
}

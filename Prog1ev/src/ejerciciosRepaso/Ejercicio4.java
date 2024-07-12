package ejerciciosRepaso;

import java.util.Scanner;

/**
 * Escribe un programa Java que pregunte al usuario por dos Strings, y compruebe
 * si el primero de ellos finaliza con el valor del segundo.
 * 1º String: Hola 2º String: la
 * Hola finaliza con la -&gt; devuelvo TRUE
 */
public class Ejercicio4 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Dame dos Strings: ");
		String x = entrada.nextLine();
		//System.out.println(x.substring(x.length() - 2, x.length()));
		String y = entrada.nextLine();
		//System.out.println(y.substring(y.length() - 2, y.length()));
		System.out.println(trueFalse(x, y)); 
	}
	/**
	 * Pre:---
	 * Post:
	 */
	public static boolean trueFalse(String x, String y) {
		boolean respuesta;
		if(x.substring(x.length() - 2, x.length()).equalsIgnoreCase(y.substring(y.length() - 2, y.length()))) {
			respuesta = true;
		} else {
			respuesta = false;
		}
		return respuesta;
	}
}

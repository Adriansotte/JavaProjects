package practica5;

/**
 * Diseña un método recursivo "esPalindromo()" que devuelva true,
 * sí y solo sí,la palabra introducida es igual si se lee de
 * izquierda a derecha que de derecha a izquierda.
 */
public class Ejercicio3 {
	
	/**
	 * Pre:---
	 * Post: metodo principal donde se generan las palabras a comprobar
	 * 		 y se envian a comprobar al metodo correspondiente.
	 */
	public static void main(String[] args) {
		String palindromo = "akdwdka";
		String normal = "Holasasdasd as";
		System.out.println(palindromo(palindromo));
		System.out.println(palindromo(normal));
	}
	
	/**
	 * Pre:---
	 * Post: metodo auxiliar el cual asigna un indice y envia al metododo
	 * 		 palindromo para que de forma recurisiva compruebe si es palindromo.
	 */
	public static boolean palindromo(String nombre) {
		return palindromo(nombre, 0);
	}
	
	/**
	 * Pre:---
	 * Post: metodo recursivo que comprueba mediante ifs si la palabra recibida
	 * 		 como parametro es palindromo o no, si lo es devuelve true, sino false.
	 */
	private static boolean palindromo(String nombre, int i) {
		if(i < (nombre.length()/2) && nombre.substring(i, i + 1).
				equalsIgnoreCase(nombre.substring(nombre.length() - 1 - i, nombre.length() - i))) {
			return palindromo(nombre, i + 1);
		} else if(i >= (nombre.length()/2)){
			return true;
		} else {
			return false;
		}
	}
}
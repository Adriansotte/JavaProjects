package practica5;

/**
 * Diseñad un método recursivo que escriba al revés la cadena que se le
 * pasa como parámetro, más un índice que se usará para recorrer la cadena.
 * Haced dos versiones del mismo, una en la que el índice vaya incrementándose
 * a cada llamada y otra en la éste que vaya decrementándose.
 */
public class Ejercicio1 {

	/**
	 * Pre:---
	 * Post: metodo principal donde se secoge la cadena la cual va a ser dada
	 * 		 la vuelta.
	 */
	public static void main(String[] args) {
		String numero = "28450";
		System.out.println(numero);
		String[] numeros = numero.split("");
		invertirNumero(numeros);
	}
	
	/**
	 * Pre:---
	 * Post: metodo auxuliar el cual envia la tabla con la cadena a dos metodos
	 * 		 para ser invertida de dos formas distintas.
	 */
	public static void invertirNumero(String[] numeros) {
		invertirNumeroB(numeros, 0);
		System.out.println("");
		invertirNumeroA(numeros, numeros.length - 1);
	}
	
	/**
	 * Pre:---
	 * Post: metodo recursivo el cual invierte el parametro enviado mediante
	 * 		 un indice que va de forma ascendente.
	 */
	private static void invertirNumeroB(String[] numeros, int l) {
		if(l == numeros.length - 1) {
			System.out.print(numeros[numeros.length - 1 - l]);
		} else {
			System.out.print(numeros[numeros.length - 1 - l]);
			invertirNumeroB(numeros, l + 1);
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo recursivo el cual invierte el parametro enviado mediante
	 * 		 un indice que va de forma descente.
	 */
	private static void invertirNumeroA(String[] numeros, int l) {
		if(l == 0) {
			System.out.print(numeros[l]);
		} else {
			System.out.print(numeros[l]);
			invertirNumeroA(numeros, l - 1);
		}
	}
}
package ejercicio2;

/**
 * Codigo que dado un valor lo convierte de euro a dolar o viceversa
 */
public class ConversorDinero {
	
	/**
	 * Pre:---
	 * Post: metodo que convierte el euro a dolar
	 */
	public static double euroToDollar(double n) {
		return n * 0.91;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que convierte el dolar a euro
	 */
	public static double dollarToEuro(double n) {
		return n * 1.1;
	}
}

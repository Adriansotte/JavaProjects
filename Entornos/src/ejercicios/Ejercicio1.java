package ejercicios;

/**
 * Desarrolla una clase que convierte grados Fahrenheit a Celsius, y viceversa.
 */
public class Ejercicio1 {
	
	/**
	 * Pre:---
	 * Post: metodo el cual recibe como parametro un double con el numero a convertir,
	 * 		 y devuelve dicho valor.
	 */
	public double fahrenheittocelsius(double n) {
		System.out.println(n + " de fahrenheit a celcius: " + ((n - 32) * 0.56));
		return (n - 32) * 5/9;
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual recibe como parametro un double con el numero a convertir,
	 * 		 y devuelve dicho valor.
	 */
	public double celsiustofahrenheit(double n) {
		System.out.println(n + " de celcius a fahrenheit: " + ((n * 1.8) + 32));
		return (n * 9/5) + 32;
	}
}

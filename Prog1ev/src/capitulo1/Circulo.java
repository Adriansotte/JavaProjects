package capitulo1;

import java.util.Scanner;

/**
 * Al construir un programa Java alrededor de esta clase se ejecuta su método [main] que
 * escribe por pantalla el radio y el área de un círculo cuyo radio ha sido definido previamente
 * por el operador al ser interrogado por el propio programa
 */
public class Circulo {

	/**
	 * Pres: r>=0.0
	 * Post: Escribe por pantalla, en una misma línea, el valor del raido y del área de un
	 * círculo de radio [r]
	 */
	public static void circulo (double r) {
		System.out.println("El área de un círculo de radio " + r + " m es igual a " + 
				Math.PI*Math.pow(r, 2) + "m^2");
	}
	
	/**
	 * Pres: ---
	 * Post: Escribe por pantalla el valor de [mensaje], lee la respuesta del operador
	 * y devuelve el valor leído
	 */
	public static double preguntar (String mensaje) {
		System.out.print(mensaje);
		Scanner entrada = new Scanner(System.in);
		return entrada.nextDouble();
	}
	
	/**
	 * Pres: ---
	 * Post: Pregunta al operador por el "Radio del círculo: "  le informa en la línea
	 * siguiente del valor del raido y del área del círculo
	 */
	public static void main (String[] argumentos) {
		double r = preguntar("Radio del círculo: ");
		circulo(r);
	}
}

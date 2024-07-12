package capitulo1;

/**
 * Al construir un programa Java alrededor de esta clase se ejecuta su método [main]
 * que escribe un par de líneas informando del lema de la asignatura de Programación
 *
 */
public class Programacion {
	/**
	 * Pres: ---
	 * Post: Escribe por pantalla una línea con el valor de [mensaje]
	 */
	public static void escribir (String mensaje) {
		System.out.printf("%s %n", mensaje);
	}

	
	/**
	 * Pres: ---
	 * Post: Escribe por pantalla en la primera línea: El lema de la asignatura Programación es:
	 * seguida de una segunda línea: *** A programar se aprende programando ***
	 */
	public static void main (String[] argumentos) {
		escribir("El lema de la asignatura Programación es:");
		escribir("*** A programar se aprende programando ***");
	}
}

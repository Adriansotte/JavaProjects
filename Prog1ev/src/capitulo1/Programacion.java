package capitulo1;

/**
 * Al construir un programa Java alrededor de esta clase se ejecuta su m�todo [main]
 * que escribe un par de l�neas informando del lema de la asignatura de Programaci�n
 *
 */
public class Programacion {
	/**
	 * Pres: ---
	 * Post: Escribe por pantalla una l�nea con el valor de [mensaje]
	 */
	public static void escribir (String mensaje) {
		System.out.printf("%s %n", mensaje);
	}

	
	/**
	 * Pres: ---
	 * Post: Escribe por pantalla en la primera l�nea: El lema de la asignatura Programaci�n es:
	 * seguida de una segunda l�nea: *** A programar se aprende programando ***
	 */
	public static void main (String[] argumentos) {
		escribir("El lema de la asignatura Programaci�n es:");
		escribir("*** A programar se aprende programando ***");
	}
}

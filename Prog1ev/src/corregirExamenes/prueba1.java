package corregirExamenes;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * ¡Puntuando los Test de los estudiantes! El colegio te pide que diseñes un
 * programa Java que facilite a los profesores la corrección de los exámenes que
 * únicamente tienen resultados enteros. Sigue las siguientes instrucciones para
 * desarrollar el código Java necesario: 1. Pregunta al usuario cuántas
 * preguntas tiene el test a puntuar (el número de preguntas es un elemento de
 * tipo entero). 2. Pregunta al usuario por las respuestas correctas para cada
 * una de las preguntas. Debe haber una respuesta correcta por cada pregunta, y
 * estas respuestas correctas deben ser un entero. Se pueden introducir una a
 * una, o todas en la misma línea, por ejemplo: 34 9 13 100 serían las
 * respuestas correctas de un Test de cuatro preguntas. 3. Pregunta al usuario
 * por las respuestas del Test de un alumno. Al igual que en el punto anterior,
 * se podrán introducir una a una o todas en la misma línea. 4. Cuando el
 * usuario haya introducido todas las respuestas, muestra por pantalla el número
 * de respuestas correctas y el porcentaje TOTAL de preguntas acertadas contando
 * todos los test corregidos. Cuando todos los puntos funcionen correctamente,
 * añade un bucle que pregunte al usuario: “¿Desea corregir un nuevo test?
 * (y/n).” Si el usuario indica que sí, se deberá volver a ejecutar el código
 * del punto 3 y 4. Si responde que no, el programa finalizará.
 */
public class prueba1 {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		System.out.println("Bienvenido al programa corrector de examenes!!!");
		System.out.println("-----------------------------------------");
		pedirDatos(entrada, "Introduzca el numero de preguntas:");
	}

	public static void pedirDatos(Scanner entrada, String mensaje) {
		try {
			System.out.println(mensaje);
			int numPreg = entrada.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Ha introducido un dato erroneo,  vuelva a intentar:");
			entrada.nextLine();
			pedirDatos(entrada, mensaje);

		}

	}
}
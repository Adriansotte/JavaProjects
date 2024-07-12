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
public class Corrector {

	/**
	 * Pre: ---
	 * Post: metodo principal donde se da la bienvenida posteriormente se piden datos. 
	 */
	public static void main(String[] args) {
		try {
		Scanner entrada = new Scanner(System.in);
		System.out.println("-----BIENVENIDO AL PROGRAMA CORRECTOR-----");
		pedirDatos(entrada);
		} catch(InputMismatchException e) {
			System.out.println("El dato es erroneo " + e);
		} catch(NumberFormatException e) {
			System.out.println("El dato es erroneo " + e);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("No ha rellenado correctamente la tabla " + e);
		}
	}

	/**
	 * Pre:---
	 * Post: metodo que se encarga de pedir datos al usuario, dentro del mismo se llama
	 * 		 a otros metodos que recopilaran los datos de las respuestas de los alumnos.
	 */
	public static void pedirDatos(Scanner entrada) {
		System.out.println("Introduce el numero de preguntas: ");
		int numPreg = entrada.nextInt();			
		int[] soluciones = cogerTabla(entrada, numPreg);
		ejecutor(entrada, soluciones, numPreg);
	}
	/**
	 * Pre:---
	 * Post: en este metodo se comparan los resultados de la tabla del profesor con
	 * 		 con la de los alumnos. los resultados se guardaran y posteriormente en otro
	 * 		 metodo se mostraran.
	 */
	public static void ejecutor(Scanner entrada, int[] soluciones, int numPreg) {
		double totalAciertos = 0;
		double totalFallos = 0;
		while(true) {
			System.out.println("Introduzca las respuestas del alumno: ");
			int[] resAlum = cogerTabla(entrada, numPreg);
			int aciertosAlumn = 0;
			int fallosAlumn = 0;
			for(int i = 0; i < soluciones.length; i++) {
				if(soluciones[i] == resAlum[i]) {
					aciertosAlumn++;
					totalAciertos++;
				} else {
					fallosAlumn++;
					totalFallos++;
				}
			}
			enseñarDatos(aciertosAlumn, fallosAlumn, totalAciertos, totalFallos);
			entrada.nextLine();
			System.out.println("Si desea seguir presione SI o cualquier tecla. ");  
			System.out.println("Si no desea seguir presione NO.");
			String volver = entrada.nextLine();
			if(volver.equals("si")) {
				continue;
			} else if(volver.equals("no")) {
				System.out.println("El programa ha finalizado");
				break;
			} else {
				
			}

		}

	}
	/**
	 * Pre: ---
	 * Post: este metodo se encarga de creal las tablas correspondientes, para el
	 * 		 profesor y para el alumno.
	 */
	public static int[] cogerTabla(Scanner entrada, int numPreg) {
		entrada.nextLine();
		System.out.println("¿Quiere agregar todas las respuestas una en una o todas? (una/todas)");
		int[] tabla = new int[numPreg];
		String orden = entrada.nextLine();
		if(orden.equals("una")) {
			for(int i = 0; i < numPreg; i++) {
				System.out.print("Introduzca respuesta: ");
				tabla[i] = entrada.nextInt();
			}
		} else if(orden.equals("todas")) {
			System.out.print("Coloque todas las respuestas: ");
			String prof = entrada.nextLine();
			String[] tabla1 = prof.split(" ");
			for(int i = 0; i < numPreg; i++) {
				tabla[i] = Integer.parseInt(tabla1[i]);
			} 
		} return tabla;
	}
	/**
	 * Pre: ---
	 * Post: metodo que recibe los datos de las respuestad de cada alumno y muestra por pantalla
	 * 		 los resultados del mismo y los globales cada vez que el profesor termine de corregir un
	 * 		 examen.
	 */
	public static void enseñarDatos(int aciertosAlumn, int fallosAlumn, double totalAciertos, double totalFallos) {
		System.out.println("Numero de aciertos: " + aciertosAlumn);
		System.out.println("Numero de fallos: " + fallosAlumn);
		double porcAprob = (totalAciertos / (totalAciertos + totalFallos)) * 100;
		double porcFallos = (totalFallos / (totalAciertos + totalFallos)) * 100;
		System.out.println("Porcentaje de aciertos: " + porcAprob + "%");
		System.out.println("Porcentaje de fallos: " + porcFallos + "%");
	}
}

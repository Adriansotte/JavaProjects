package practica1;

import java.util.ArrayList;
import java.util.Random;

/**
 * Se pide desarrollar un programa concurrente que cumpla las siguientes especificaciones:
 * Crea y rellena un vector de 100 números enteros, aleatorios.
 * Lanza tres procesos para analizar los datos: uno que calcula la media, otro el
 * valor máximo y mínimo, y otro la desviación típica. Ten en cuenta que, aunque
 * estos procesos comparten el vector de números enteros, únicamente lo hacen
 * para su lectura. Ninguno de ellos debe modificar ningún valor de dicho vector.
 *  Una vez que estos valores se han calculado, se informa de ellos por pantalla.
 */
public class Ejercicio3 {

	private static ArrayList<Integer> numeros;
	private static Random random;
	
	/**
	 * Pre:---
	 * Post: metodo principal el cual genera los hilos con los que vamos a trabajar
	 * 		 posteriormenet los inicia y los pausa todos a la vez para que terminen a la vez y 
	 * 		 muestra por pantalla el mensaje de fin.
	 */
	public static void main(String[] args) {
		rellenar();
		ThreadMedia media = new ThreadMedia(numeros);
		ThreadMaxMin maxMin = new ThreadMaxMin(numeros);
		ThreadTipico tipico = new ThreadTipico(numeros);
		media.start();
		maxMin.start();
		tipico.start();
		try {
			media.join();
			maxMin.join();
			tipico.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Fin");
	}
	
	/**
	 * Pre:---
	 * Post: metodo que rellena el ArrayList de manera aleatoria.
	 */
	public static void rellenar() {
		numeros = new ArrayList<>();
		random = new Random();
		for(int i = 0; i < 100; i++) {
			int aleatorio = random.nextInt(99);
			numeros.add(aleatorio);
		}
	}
}

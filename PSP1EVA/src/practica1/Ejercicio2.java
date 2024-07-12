package practica1;

import java.util.Random;

/**
 * Se pide desarrollar una nueva implementación del programa, muy parecida a los
 * mostrados en el primer apartado de la práctica. En este caso, se deben lanzar 10
 * procesos, de manera que cada uno de ellos se “duerma” un tiempo aleatorio entre 100
 * y 300 milisegundos, y escriba el mensaje correspondiente (“Soy 1”, “Soy 2”, … “Soy 10)
 * un número aleatorio de veces, entre 5 y 15.
 */
public class Ejercicio2 {

	/**
	 * Pre:---
	 * Post: metodo principal el cual genera Threads cuyo trabajo sera operar sobre una
	 * 		 una tabla realizando las operaciones pernitentes con ella.
	 */
	public static void main(String[] args) {
		Thread3[] tabla = new Thread3[10];
		Random random = new Random();
		for(int i = 0; i < tabla.length; i++) {
			Thread3 t = new Thread3(random.nextInt(11) + 5, random.nextInt(201) + 100);
			tabla[i] = t;
			t.start();
		}
		for(int i = 0; i < tabla.length; i++) {
			try {
				tabla[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Fin");	
	}
}

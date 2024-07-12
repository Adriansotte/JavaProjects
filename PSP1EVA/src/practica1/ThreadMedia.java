package practica1;

import java.util.ArrayList;

/**
 * Thread cuyp trabajo es el de calcular la media de los valores que contiene
 * el ArrayList y muestra el resultado por pantalla.
 */
public class ThreadMedia extends Thread {

	private ArrayList<Integer> numeros;
	
	public ThreadMedia(ArrayList<Integer> numeros) {
		this.numeros = numeros;
	}
	
	public void run() {
		double suma = 0;
		for(int i = 0; i < numeros.size(); i++) {
			suma += numeros.get(i);
		}
		System.out.println("Esta es la media: " + suma/numeros.size());
	}
}
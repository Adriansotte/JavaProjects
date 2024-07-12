package practica1;

import java.util.ArrayList;

/**
 * Thread cuyp trabajo es el de calcular el valor minimo y el valor maximo
 * de los valores que contiene el ArrayList y muestra el resultado por pantalla.
 */
public class ThreadMaxMin extends Thread{

	private ArrayList<Integer> numeros;
	
	public ThreadMaxMin(ArrayList<Integer> numeros) {
		this.numeros = numeros;
	}
	
	public void run() {
		int max = 0;
		int min = 100;
		for(int i = 0; i < numeros.size(); i++) {
			if(numeros.get(i) < min) {
				min = numeros.get(i);
			} else if(numeros.get(i) > max) {
				max = numeros.get(i);
			}
		}
		System.out.println("El valor minimo es: " + min + "\nEl valor maximo es: " + max);
	}
}

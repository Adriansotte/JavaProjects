package practica1;

import java.util.ArrayList;

/**
 * Thread cuyp trabajo es el de calcular la desviacion tipica de los valores que contiene
 * el ArrayList y muestra el resultado por pantalla.
 */
public class ThreadTipico extends Thread{

	private ArrayList<Integer> numeros;
	
	public ThreadTipico(ArrayList<Integer> numeros) {
		this.numeros = numeros;
	}
	
	public void run() {
        double suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        double media = suma / numeros.size();
        double sumaDiferenciasCuadrado = 0;
        for (int num : numeros) {
            double diferencia = num - media;
            sumaDiferenciasCuadrado += diferencia * diferencia;
        }
        double desviacionTipica = Math.sqrt(sumaDiferenciasCuadrado / numeros.size());
        System.out.println("La desviación tipica es: " + desviacionTipica);
	}
}

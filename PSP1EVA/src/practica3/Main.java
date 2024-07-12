package practica3;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * El objetivo de este ejercicio es programar un sistema concurrente formado por:
 * 4 procesos escritores: Cada escritor inserta 8 mensajes de texto en la cola.
 * 5 procesos lectores: Cada lector saca 6 mensajes de la cola. Después de extraer
 * su contenido muestra por la salida estándar su identificador de proceso y el texto
 * obtenido.
 */
public class Main {

	public static ColaConcurrente cola;
	public static Semaphore s1;
	
	/**
	 * Pre:
	 * Post: metodo principal en el cual se generan los ThreadLectores y los ThreadEscritoes,
	 * 		 se introducen en un array correspondiente y posteriormente se inicializan para
	 * 		 que realicen su funcion.
	 */
	public static void main(String[] args) {
		cola = new ColaConcurrente();		
		ArrayList<ThreadEscritor> bolsaEscritores = new ArrayList<>();
		ArrayList<ThreadLector> bolsaLectores = new ArrayList<>();
		// He aprovecahdo este bucle poniendo un if dentro para no tener que hacer dos bucles
		// para hacer la misma accion.
		for(int i = 0; i < 5; i++) {
			if(i < 4) {
				ThreadEscritor e = new ThreadEscritor(cola, i);
				bolsaEscritores.add(e);
				e.start();
			}
			ThreadLector l = new ThreadLector(cola, i);
			bolsaLectores.add(l);
			l.start();
		}
		try {
			// He hecho lo mismo que antes para no tener que realizar dos veces el mismo bucle.
			for(int i = 0; i < bolsaEscritores.size() || i < bolsaLectores.size(); i++) {
				if(i < bolsaEscritores.size()) {
					bolsaEscritores.get(i).join();
				}
				bolsaLectores.get(i).join();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		System.out.println(cola.size + " nodos restantes");
	}
}

package practica5;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * La entrada comienza con un número que indica cuántos casos deberán ser procesado
 * Cada caso de prueba está compuesto por cuatro números, n, s, p y k. El primero,
 * 2 ≤ n ≤ 1.000 indica el tamaño de la población que será reducida a la mitad.
 * Los dos siguientes, 1 ≤ s, p ≤ n indican las posiciones en el círculo de Iron Man
 * (el Señor Stark) y de Spiderman (Peter Parker) respectivamente. Se garantiza que
 * ambos serán diferentes. El último, 0 ≤ k ≤ 20 indica el número de personas que Thanos
 * se salta cada vez en su recorrido antes de eliminar al siguiente.
 */
public class Ejercicio8 {

	private static Scanner n;
	
	/**
	 * Pre:---
	 * Post: metodo principal donde se generan: un array que contiene la orden del
	 * 		 usuario y otro metodo donde almacena arrays donde estan las poblaciones
	 * 		 segun la orden introducida por el usuario.
	 */
	public static void main(String[] args) {
		n = new Scanner(System.in);
		int iteraciones = n.nextInt();
		n.nextLine();
		ArrayList<String[]> ordenes = new ArrayList<>();
		ArrayList<ArrayList<String>> poblaciones = new ArrayList<>();
		for(int i = 0; i < iteraciones; i++) {
			String mensaje = n.nextLine().trim();
			String[] orden = mensaje.split(" ");
			boolean comp = comprobarOrden(orden);
			if(!comp) break;
			ArrayList<String> poblacion = new ArrayList<>();
			for(int j = 1; j <= Integer.parseInt(orden[0]); j++) {
				poblacion.add("a");
			}
			poblacion.set(Integer.parseInt(orden[1]) - 1, "S");
			poblacion.set(Integer.parseInt(orden[2]) - 1, "P");
			ordenes.add(orden);
			poblaciones.add(poblacion);
		}
		if(ordenes != null) {
			hacerComprobaciones(ordenes, poblaciones);
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo principal donde segun las ordenes de cada iteracion se
	 * 		 modifican los arrayList, hasta que cumplan con las condiciones,
	 * 		 una vez cumplidas estas, se comprueba si ironman o spiderman siguen
	 * 		 en el array o no, segun la respuesta se generara devolvera un mensaje
	 * 		 distitno.
	 */
	public static void hacerComprobaciones(ArrayList<String[]> ordenes, ArrayList<ArrayList<String>> poblaciones) {
		for(int i = 0; i < ordenes.size(); i++) {
			int intervalo = Integer.parseInt(ordenes.get(i)[3]);
			while(poblaciones.get(i).size() > (Integer.parseInt(ordenes.get(i)[0])/2)) {
				if(intervalo == poblaciones.get(i).size()) intervalo = 0;
				if(intervalo > poblaciones.get(i).size()) {
					intervalo = intervalo - poblaciones.get(i).size();
					continue;
				} 
				poblaciones.get(i).remove(intervalo);
				intervalo = (Integer.parseInt(ordenes.get(i)[3]) + intervalo);
			}
			if(poblaciones.get(i).indexOf("S") == -1 && poblaciones.get(i).indexOf("P") == -1) {
				System.out.println("No hay abrazo");
			} else if(poblaciones.get(i).indexOf("S") == -1 && poblaciones.get(i).indexOf("P") != -1) {
				System.out.println("No quiero irme, Peter!");
			} else if(poblaciones.get(i).indexOf("S") != -1 && poblaciones.get(i).indexOf("P") == -1) {
				System.out.println("No quiero irme, Sr. Stark!");
			} else {
				System.out.println("No hay abrazo");
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que comprueba la orden y si la orden es correcta devuelve true,
	 * 		 sino devuelve false.
	 */
	public static boolean comprobarOrden(String[] orden) {
		if(Integer.parseInt(orden[1]) < 1 || Integer.parseInt(orden[1]) > Integer.parseInt(orden[0]) ||
				Integer.parseInt(orden[2]) < 1 || Integer.parseInt(orden[2]) > Integer.parseInt(orden[0]) ||
				Integer.parseInt(orden[3]) < 0 || Integer.parseInt(orden[3]) > 20 ||
				Integer.parseInt(orden[0]) < 2 || Integer.parseInt(orden[0]) > 1000) {
			return false;
		} else {
			return true;
		}
	}
}
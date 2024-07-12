package arrayList2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
* Implementa un programa Java que solicite al usuario
* constantemente números enteros distintos de 0 y los vaya introduciendo
* de forma dinámica en un ArrayList. Cuando el usuario escribe un 0,
* ejecutar los métodos:
* 1. calcularSuma(ArrayList&lt;Integer&gt; lista): muestra por pantalla la
* suma de todos los elementos de la lista pasada como parámetro.
* 2. calcularMedia(ArrayList&lt;Integer&gt; lista): muestra por pantalla la
* media aritmética de la lista pasada como parámetro.
* 3. esCapicua(ArrayList&lt;Integer&gt; lista) muestra por pantalla si la lista
* pasada por parámetros es capicúa.
 */
public class Ejercicio1 {
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		int solicitar = 0;
		ArrayList<Integer> numeros = new ArrayList<>();
		while(true) {
			solicitar = entrada.nextInt();
			if(solicitar != 0) {
				numeros.add(solicitar);
			} else {
				break;
			}
		}
		System.out.println(numeros);
		calcularSuma(numeros);
		calcularMedia(numeros);
		esCapicua(numeros);
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void calcularSuma(ArrayList<Integer> numeros) {
		int suma = 0;
		for(int i = 0; i < numeros.size(); i++) {
			suma += numeros.get(i);
		} System.out.println("La suma es: " + suma); 
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void calcularMedia(ArrayList<Integer> numeros) {
		double media = 0;
		for(int i = 0; i < numeros.size(); i++) {
			media += numeros.get(i);
		} System.out.println("La media es: " + media/numeros.size()); 
		
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void esCapicua(ArrayList<Integer> numeros) {
		for(int i = 0; i < numeros.size(); i++) {
			if(i >= numeros.size() - 1 - i) {
				System.out.println("Es capicua");
			} else if(numeros.get(i) != numeros.get(numeros.size() - 1 -i)) {
				System.out.println("No es capicua");
			}
		}
	}
}

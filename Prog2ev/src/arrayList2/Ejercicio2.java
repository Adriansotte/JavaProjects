package arrayList2;

import java.util.ArrayList;

/**
 * Un cine nos propone hacer una aplicación para controlar las personas (nombre
 * y edad) de la cola en los grandes estrenos de películas. Un conjunto de
 * personas espera la cola para sacar una entrada, y deberemos calcular su
 * precio dependiendo de su edad. El número total de personas que forman la cola
 * es un número aleatorio entre 0 y 50. Al finalizar el programa, se deberá
 * mostrar por pantalla la cantidad total recaudada.
 */
public class Ejercicio2 {

	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		System.out.println("Bienvenido al cine :)");
		ArrayList<Persona> personas = new ArrayList<>();
		mostrarPersonas(personas);
		System.out.println("El total es: " + mostrarPrecio(personas) + "€");
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void mostrarPersonas(ArrayList<Persona> personas) {
		for(int i = 0; i < (int)Math.floor(Math.random()*(50-0)+0); i++) {	
			Persona persona = new Persona();
			personas.add(persona);
		}
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static int mostrarPrecio(ArrayList<Persona> personas) {
		int totalPago = 0;
		for(int i = 0; i < personas.size(); i++) {
			System.out.println("Nombre: " + personas.get(i).getNombre() + " Edad: " +
					personas.get(i).getEdad() + " Pago: " + personas.get(i).calcularPago());
			totalPago += personas.get(i).calcularPago();
		} return totalPago;
	}
}

package arrayList2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * En un puesto fronterizo recogemos diariamente la información referente al
 * tránsito de personas. Para una persona nos interesa almacenar su DNI y nombre
 * completo. Se pide diseñar una aplicación que presente las siguientes
 * opciones: 1. Paso de frontera. 2. Mostrar todas las personas. 3. Búsqueda por
 * nombre. 4. Búsqueda por DNI. 5. Salir
 * Mediante la opción1 se recogen loS datos de la persona que transita a través
 * de la frontera (se añade una nueva persona al ArrayList de tránsito).
 * La opción 2 muestra la información de todas las personas que han pasado por la frontera.
 * Mediante la opción 3 se solicita un nombre por teclado y se muestra la información
 * de todas las personas cuyo nombre coincide con el introducido.
 * Y por último, en la opción 4 introducimos el DNI de una persona de la que obtendremos
 * toda su información.
 */
public class Ejercicio3 {
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void main(String[] args) {
		System.out.println("Bienvenido a aduanas :)");
		try {
			ejecutor();
		} catch(InputMismatchException e) {
			System.out.println("Caracter no valido");
			ejecutor();
		}
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void ejecutor() {
		Scanner entrada = new Scanner(System.in);
		ArrayList<Persona> personas = new ArrayList<>();
		int pregunta = 0;
		while(true) {
			menu();
			pregunta = entrada.nextInt();
			if(pregunta == 1) {
				Persona persona = new Persona();
				System.out.println("Persona aceptada: " + persona.toString()); 
				personas.add(persona);
			} else if(pregunta == 2) {
				mostrarPersonas(personas);
			} else if(pregunta == 3) {
				busquedaNombre(personas, entrada);
			} else if(pregunta == 4) {
				busquedaDNI(personas,  entrada);
			} else if(pregunta == 5) {
				System.out.println("Usted ha salido");
				break;
			} else {
				System.out.println("Numero no valido intente de nuevo.");
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void busquedaDNI(ArrayList<Persona> personas, Scanner entrada) {
		System.out.print("Introduzca el DNI que desea buscar: ");
		entrada.nextLine();
		String buscar = entrada.nextLine();
		for(int i = 0; i < personas.size(); i++) {
			if(buscar.toUpperCase().equals(personas.get(i).getDNI())) {
				System.out.println(personas.get(i).toString());
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void busquedaNombre(ArrayList<Persona> personas, Scanner entrada) {
		System.out.print("Introduzca el nombre que desea buscar: ");
		entrada.nextLine();
		String buscar = entrada.nextLine();
		for(int i = 0; i < personas.size(); i++) {
			if(personas.get(i).getNombre().toUpperCase().equals(buscar.toUpperCase())) {
				System.out.println(personas.get(i).toString());
			}
		}
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public static void mostrarPersonas(ArrayList<Persona> p) {
		for(int i = 0; i < p.size(); i++) {
			System.out.println(p.get(i).toString());
		}
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void menu() {
		System.out.println("1. Paso de frontera.");
		System.out.println("2. Mostrar todas las personas.");
		System.out.println("3. Busqueda por nombre.");
		System.out.println("4. Busqueda por DNI.");
		System.out.println("5. Salir.");
		System.out.println("Elija una opcion.(1-5)");
	}
}

package examen2EVA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio3 {
	/**
	 * Pre:---
	 * Post: metodo principal que contiene el funcionamiento del programa.
	 */
	public static void main(String[] args) {
		File documento = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\textoExamen.txt");
		String palabra = pedirPalabra("Dame una palabra: ");
		ArrayList<String> lista = compararDocumento(palabra, documento);
		mostrarLista(lista);
	}
	
	/**
	 * Pre:---
	 * Post: metodo qeue muestra por pantalla el contenido del array recibido
	 * 		 como parametro.
	 */
	public static void mostrarLista(ArrayList<String> lista) {
		System.out.println("----------------------------");
		System.out.println("Lista de letras encontradas.");
		for(int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i));
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recorre el documento enviado por parametro, y lo gestiona
	 * 		 de manera que busca palabras segun la introducida por el ususario.
	 */
	public static ArrayList<String> compararDocumento(String palabra, File documento) {
		ArrayList<String> palabras = new ArrayList<>();
		try {
			Scanner n = new Scanner(documento);
			System.out.println("----El texto----");
			while(n.hasNextLine()) {
				String linea = n.nextLine().replaceAll("[\\.:,()\"]", " ").toLowerCase().trim();
				System.out.println(linea);
				String comprobada = linea.replaceAll("\\s+", ",");
				String[] comprobar = comprobada.split(",");
				comprobarLinea(palabra, comprobar, palabras);
			}
		} catch(FileNotFoundException e) {
			System.out.println(e);
		}
		return palabras;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametros un ArrayList donde guardar la informacion
	 * 		 una palabra a comprobar, y una table donde guarda las palabras a comrpobar,
	 * 		 si concide la palabra con alguna palabra a comprobar, devuelve la palabra
	 * 	 	 que esta en la posicion siguiente de la tabla, si la palabra es la ultima,
	 * 		 no devuelve nada.
	 */
	public static void comprobarLinea(String palabra, String[] comprobar, ArrayList<String> lista) {
		for(int i = 0; i < comprobar.length; i++) {
			if(palabra.toLowerCase().equals(comprobar[i])) {
				try {
					lista.add(comprobar[i + 1]);
				} catch(IndexOutOfBoundsException e) {
					
				}
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que pide al usuario por pantalla una palabra.
	 */
	public static String pedirPalabra(String preg) {
		System.out.print(preg);
		Scanner n = new Scanner(System.in);
		String palabra = n.nextLine();
		n.close();
		return palabra;
	}
}

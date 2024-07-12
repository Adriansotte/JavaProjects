package actividad1;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Clase que crea un fichero llamado "archivo_AdrianValdivieso.txt" y pide al usuario que escriba algo en el."
 */
public class Escribir_Fichero_Plano {

	private static Scanner n;
	
	/**
	 * Pre:---
	 * Post: metodo principal el cual inicializa la variable Scanner y crea un archivo.
	 * 		 
	 */
	public static void main(String[] args) {
		n = new Scanner(System.in);
		try {
			FileWriter archivo = new FileWriter("archivo_AdrianValdivieso.txt");
			escribirArchivo();	
			archivo.close();
			System.out.println("Ya tienes  tu fichero listo!!!");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que pide al usuario un mensaje y modifica el archivo con el nuevo mensaje.
	 */
	public static void escribirArchivo() {
		System.out.print("Dime un mensaje: ");
		String mensaje = n.nextLine();
		try {
			Formatter file = new Formatter("archivo_AdrianValdivieso.txt");
			file.format(mensaje);
			file.flush();
			file.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
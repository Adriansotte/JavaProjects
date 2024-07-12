package practica5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Diseña un programa Java que, dados dos ficheros de texto (con el 
 * contenido que sea), genere un nuevo fichero llamado "nuevoFichero.txt"
 * que contenga la información de los dos ficheros pasados como parámetro.
 */
public class Ejercicio4 {

	/**
	 * Pre:---
	 * Post: metodo principal el cual recoge la informacion de dos ficheros,
	 * 		 llama a otro metodo donde se gestionaran dichos ficheros.
	 */
	public static void main(String[] args) {
		File documentoA = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\cuento.txt");
		File documentoB = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\asignaturas.txt");
		escribirFichero(documentoA, documentoB);
	}
	
	/**
	 * Pre:---
	 * Post: metodo que lee la informacion de cada fichero y dicha informacion
	 * 		 la agrega a un fichero de texto nuevo llamado "nuevo Fichero.txt".
	 */
	public static void escribirFichero(File documentoA, File documentoB) {
		try {
			Scanner nA = new Scanner(documentoA);
			Formatter fichero = new Formatter("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\"
					+ "Programacion\\ficheros\\nuevoFichero.txt");
			while(nA.hasNextLine()) {
				String linea = nA.nextLine();
				fichero.format(linea + "\n");
			}
			nA.close();
			nA = new Scanner(documentoB);
			while(nA.hasNextLine()) {
				String linea = nA.nextLine();
				fichero.format(linea + "\n");
			}
			nA.close();
			fichero.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
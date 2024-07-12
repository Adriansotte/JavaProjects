package practica3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;

/**
 * Una clase que se encarga de copiar las primeras 10 lineas y las primeras
 * 2000 lineas de un documento a otro documento. Maneteniendo el formato
 */
public class Tarea1 {
	
	/**
	 * Pre:---
	 * Post: metodo principal donde se leen los ficheros a copiar, los documentos a escribir,
	 * 		 y se realiza el Formatter de los ultimos para escribir el resultado sobre ellos.
	 */
	public static void main(String[] args) {
		File documento = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\usos-16.csv");
		File documento2 = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\usos-17.csv");
		File lineas10 = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\pruebas-10.csv");
		File lineas2000 = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\pruebas-2000.csv");
		try {
			Formatter copia10 = new Formatter(lineas10);
			Formatter copia2000 = new Formatter(lineas2000);
			copiarFichero(documento, copia10, 10);
			copiarFichero(documento2, copia2000, 2000);
			verFichero(lineas10);
			verFichero(lineas2000);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametros un File donde se encuentra la informacion
	 *   	 a copiar, un Formatter donde se pegara la informacion y una condicion que
	 *   	 servira para limitar el numero de lineas que se desea copiar en cada caso.
	 */
	public static void copiarFichero(File documento, Formatter copia, int condicion) {
		try{
			Scanner n = new Scanner(documento);
			int cont = 0;
			while(n.hasNextLine() && cont < condicion) {
				copia.format(n.nextLine() + "\n");
				copia.flush();
				cont++;
			}
			n.close();
			copia.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que muestra el fichero recibido como parametro por consola.
	 */
	public static void verFichero(File fichero){
		try{
			Scanner n2 = new Scanner(fichero);
			while(n2.hasNextLine()) {
				System.out.println(n2.nextLine());
			}
			n2.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
package examen3Evaluacion;

import java.io.File;
import java.util.Scanner;

/**
 * Queremos desarrollar un programa Java que sea capaz de analizar la información
 * de un fichero de texto. El algoritmo recibe como parámetro la dirección de un fichero de
 * texto junto a una letra del abecedario, y almacena en una base de datos formada por una
 * única tabla llamada Registro las palabras que empiezan o acaban por la [letra] indicada,
 * junto a la línea del fichero en la que aparecían.
 */
public class Ejercicio2 {

	private static Scanner n;
	private static BbddExamen base;
	
	/**
	 * Pre:---
	 * Post: metodo principal que inicia las variables globales del programa. Pide
	 * 		 al usuario una palabra y la envia como parametro al metodo ejecutor del
	 * 		 programa.
	 */
	public static void main(String[] args) {
		n = new Scanner(System.in);
		base = new BbddExamen();
		System.out.print("Dame una letra: ");
		String letra = n.nextLine();
		try {
			ejecutor(letra);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			base.close();
		}
	}
	
	/**
	 * Pre:---
	 * Post: metetodo ejecutor que lee el fichero y va comprobando palabra por
	 * 		 palabra y si concide la primera o ultima letra de la palabra con
	 * 		 la letra enviada, si concide agrega dicha palabra a la base de datos.
	 */
	public static void ejecutor(String letra) {
		try {
			int linea = 1;
			File documento = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\HablanosDelDon.txt");
			Scanner lector = new Scanner(documento);
			while(lector.hasNextLine()) {
				String frase = lector.nextLine().replaceAll("[\\.:¿?,;“”]", "").trim();
				String[] palabras = frase.split(" ");
				base.start();
				compararLetras(palabras, letra, linea);
				base.close();
				linea++;
			}
			lector.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametros una tabla con las palabras a comprobar
	 * 		 una letra y el numero de la linea en la que se encuentra. Si la palabra
	 * 		 coincide con las especificaciones es añadida a la base de datos.
	 */
	public static void compararLetras(String[] palabras, String letra, int linea) throws Exception {
		for(int i = 0; i < palabras.length; i++) {
			if(letra.equalsIgnoreCase(palabras[i].substring(0, 1)) ||
					letra.equalsIgnoreCase(palabras[i].substring(palabras[i].length() - 1, palabras[i].length()))) {
				base.addWord(letra, palabras[i], linea);	
			}
		}
	}
}
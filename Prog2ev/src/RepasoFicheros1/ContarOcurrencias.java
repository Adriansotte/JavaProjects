package RepasoFicheros1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 
 */
public class ContarOcurrencias {
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		System.out.println("----CONTADOR OCURRENCIAS----");
		File cuento = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\cuento.txt");
		ArrayList<Par> aComparar = cogerPalabras();
		Collections.sort(aComparar, new OrdenarPalabras());
		contar(aComparar, cuento);
		mostrarDatos(aComparar);
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static ArrayList<Par> cogerPalabras() {
		ArrayList<Par> palabras = new ArrayList<>();
		String[] pala = pedirPalabras("Dame las palabras que deseas buscar separadas por espacios: ");
		for(int i = 0; i < pala.length; i++) {
			Par nuevo = new Par(pala[i]);
			palabras.add(nuevo);
		}
		return palabras;
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void mostrarDatos(ArrayList<Par> c) {
		for(int i = 0; i < c.size(); i++) {
			System.out.println(c.get(i).toString());
		}
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void contar(ArrayList<Par> aComparar, File cuento) {
		try {
			Scanner n = new Scanner(cuento);
			while(n.hasNextLine()) {
				String linea = n.nextLine().replaceAll("[\\.:,«»]", "").toLowerCase();
				String[] frase = linea.split(" ");
				verificar(frase, aComparar);
			}
			n.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void verificar(String[] frase, ArrayList<Par> aComparar) {
		for(int i = 0; i < aComparar.size(); i++) {
			for(int j = 0; j < frase.length; j++) {
				if(aComparar.get(i).getPalabra().equals(frase[j])) {
					aComparar.get(i).aumentarOcurrencia();	
				}
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static String[] pedirPalabras(String preg) {
		System.out.print(preg);
		Scanner n = new Scanner(System.in);
		String pedir = n.nextLine().replaceAll("\\s+", " ").trim();
		String[] palabras = pedir.split(" ");
		n.close();
		return palabras;
	}
}
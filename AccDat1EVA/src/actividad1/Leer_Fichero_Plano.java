package actividad1;

import java.io.File;
import java.util.Scanner;

/**
 * Programa que lee un fichero.
 */
public class Leer_Fichero_Plano {

	private static Scanner n;
	
	/**
	 * Pre:---
	 * Post: metodo principal el cual inicializa el Scanner n y lee el archivo almacenado.
	 */
	public static void main(String[] args) {
		try {
			File fichero = new File("archivo_AdrianValdivieso.txt");
			n = new Scanner(fichero);
			while(n.hasNext()) {
				String frase = n.nextLine();
				System.out.println(frase);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
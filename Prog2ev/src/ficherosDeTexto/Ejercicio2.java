package ficherosDeTexto;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ejercicio2 {
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		File documento = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\personas.txt");
		Scanner n = null;
		try {
			n = new Scanner(documento);
			String frase = "";
			int numeros = 0;
			while(n.hasNextLine()) {
				frase = n.nextLine();
				String[] tabla = frase.split(",");
				String nombre = tabla[1].trim();
				String dni = tabla[0].trim().substring(0, 9);
				String ape = tabla[0].trim().substring(10, tabla[0].length());
				numeros = 60 - tabla[0].length() - tabla[1].length();
				System.out.print(nombre + " " + ape);
				for(int i = 0; i < numeros; i++) {
					System.out.print(".");
				} System.out.println(dni);		
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

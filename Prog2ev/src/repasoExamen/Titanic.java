package repasoExamen;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Titanic {
	
	public static void main(String[] args) {
		System.out.println("----Bienvenido al titanic----");
		File documento = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\titanic.csv");
		almacenarPasajeros(documento);
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void almacenarPasajeros(File documento) {
		Map<String, Integer> miPana = new HashMap<>();
		miPana.put("female", 0);
		miPana.put("male", 0);
		miPana.put("1", 0);
		miPana.put("0", 0);
		int cont = 0;
		try {
			Scanner n = new Scanner(documento);
			n.nextLine();
			while(n.hasNextLine()) {
				String fila = n.nextLine();
				String[] palabras = fila.split(",");
				miPana.put(palabras[5].toLowerCase(), miPana.get(palabras[5].toLowerCase()) + 1);
				miPana.put(palabras[1], miPana.get(palabras[1]) + 1);
				cont++;
			}
		} catch(FileNotFoundException e) {}
		System.out.println("Total de pasajeros:          " + cont);
		System.out.println("Total mujeres:               " + miPana.get("female"));
		System.out.println("Total hombres:               " + miPana.get("male"));
		System.out.println("Total de mujeresFallecidas:  " + miPana.get("1") );
		System.out.println("Total de hombresFallecidas:  " + miPana.get("0") );
	}
}

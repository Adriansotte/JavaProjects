package practica5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Dado el fichero "drivers.csv" que contiene toda la información histórica de 
 * los pilotos de Fórmula 1, muestra por pantalla el número de pilotos de cada 
 * una de las nacionalidades (ordenados de mayor a menor número de ocurrencias).
 */
public class Ejercicio2 {

	/**
	 * Pre:---
	 * Post: metodo principal el cual recoge la informacion de un fichero mediante
	 * 		 un metodo y lo almacena en un ArrayList, ordena y muestra por pantalla.
	 */
	public static void main(String[] args) {
		ArrayList<Pais> informacion = recogerInformacion();
		Collections.sort(informacion, new OrdenarPaises());
		enseñarInfo(informacion);
	}
	
	/**
	 * Pre:---
	 * Post: metodo que se utiliza para enseñar la informacion del array enviado.
	 */
	public static void enseñarInfo(ArrayList<Pais> n) {
		for(int i = 0; i < n.size(); i++) {
			System.out.println(n.get(i).toString());
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que se utiliza para recoger la informacion necesaria de un fichero
	 * 		 y almacenar dicha informacion en un ArrayList de objetos Pais.
	 */
	public static ArrayList<Pais> recogerInformacion() {
		ArrayList<Pais> lista = new ArrayList<>();
		File documento = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\drivers.csv");
		try {
			Scanner n = new Scanner(documento);
			n.nextLine();
			while(n.hasNextLine()) {
				String linea = n.nextLine().replaceAll("\"", "");
				String[] info = linea.split(",");
				//se crea o se recoge un nuevo objeto pais con el nombre del pais
				Pais nuevo = comprobarPais(info[7], lista);
				//se aumentan las ocurrencias de dicho pais.
				if(nuevo != null) {
					nuevo.aumentarOcurrencias();
				} else {
					nuevo = new Pais(info[7]);
					lista.add(nuevo);
				}
			}
			n.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual recibe como parametros un nombre y un Array de objetos
	 * 		 pais, recorre el array comprobando si el nombre coincide con el nombre
	 * 		 de algun objeto, si coincide devuelve dicho objeto, sino devuelve null.
	 */
	public static Pais comprobarPais(String nombre, ArrayList<Pais> lista) {
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNombre().equalsIgnoreCase(nombre)) {
				return lista.get(i);
			}
		}
		return null;
	}
}
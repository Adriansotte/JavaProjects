package examen2EVA;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {

	/**
	 * Pre:---
	 * Post: metodo principal que da un saludo por pantalla y contiene el funcionamiento
	 * 		 principal del programa.
	 */
	public static void main(String[] args) {
		System.out.println("----VENTAS DE VIDEOJUEGOS----");
		File documento = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\ventasVideojuegos.csv");
		ArrayList<Plataforma> lista = informacionVideojuegos(documento);
		mostrarDatos(lista);
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recive como parametro un File, lo lee y gestiona
	 * 	     las las peticiones del programa.
	 */
	public static ArrayList<Plataforma> informacionVideojuegos(File docu) {
		ArrayList<Plataforma> p = new ArrayList<>();
		try {
			Scanner n = new Scanner(docu);
			n.nextLine();
			while(n.hasNextLine()) {
				String linea = n.nextLine();
				String[] plataforma = linea.split(",");
				gestionPlataforma(p, plataforma);
			}
			n.close();
		} catch(FileNotFoundException e) {
			System.out.println(e);
		}
		return p;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que sirve para arreglar el problema de separacion
	 * 		 por comas de las distintas lineas del fichero.
	 */
	public static String comprobarNombre(String[] aComprobar) {
		if(aComprobar[2].contains("\"")) {
			return aComprobar[4];
		} else {
			return aComprobar[2];			
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que comprueba las ocurrencias de cada palabra y gestiona
	 * 		 el array de forma debida.
	 */
	public static void gestionPlataforma(ArrayList<Plataforma> p, String[] linea ) {
		if(p.size() != 0) {
			Plataforma nueva = comprobarPlataforma(p, comprobarNombre(linea));
			if(nueva == null) {
				nueva = new Plataforma(comprobarNombre(linea));
				p.add(nueva);
			} 
			nueva.aumentarApariciones();
		} else {
			Plataforma primera = new Plataforma(comprobarNombre(linea));
			primera.aumentarApariciones();
			p.add(primera);
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametro una lista con objetos plataforma y un nombre,
	 * 	 	 recorre la lista y devuelve el objeto si lo encuentra, sino devuelve null.
	 */
	public static Plataforma comprobarPlataforma(ArrayList<Plataforma> p, String nombre) {
		for(int i = 0; i < p.size(); i++) {
			if(nombre.equals(p.get(i).getNombre())) {
				return p.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que se utiliza para mostrar datos del parametro recibido.
	 */
	public static void mostrarDatos(ArrayList<Plataforma> datos) {
		for(int i = 0; i < datos.size(); i++) {
			System.out.println(datos.get(i).toString());
		}
	}
}

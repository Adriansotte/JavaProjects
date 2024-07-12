package practica5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Dado el fichero "2021_accidentalidad.csv", que almacena los accidentes de
 * tráfico ocurridos durante el año 2021 en la Comunidad De Madrid. Muestra
 * por pantalla los distintos tipos de accidentes, junto a su número de
 * ocurrencias separadas por género.
 */
public class Ejercicio5 {
	
	/**
	 * Pre:---
	 * Post: metodo principal el cual contiene un ArrayList de objetos Accidente
	 * 		 el cual llama a un metodo para recoger la informacion de un fichero
	 * 		 y mostrarla por pantalla.
	 */
	public static void main(String[] args) {
		System.out.println("----ACCIDENTALIDAD DE MADRID----");
		ArrayList<Accidente> datos = recogerDatos();
		mostrarDatos(datos);
		
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametro un array y muestra por pantalla	
	 * 		 la informacion del array.
	 */
	public static void mostrarDatos(ArrayList<Accidente> d) {
		for(int i = 0; i < d.size(); i++) {
			System.out.println(d.get(i).toString());
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que lee la informacion almacenada en un fichero,
	 * 		 crea objetos de tipo accidente donde guarda la informacion necesaria
	 * 		y los almacena en un array que se devolvera como parametro.
	 */
	public static ArrayList<Accidente> recogerDatos() {
		ArrayList<Accidente> datos = new ArrayList<>();
		File documento = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\"
				+ "Programacion\\ficheros\\2021_accidentalidad.csv");
		try {
			Scanner n = new Scanner(documento);
			n.nextLine();
			while(n.hasNextLine()) {
				String linea = n.nextLine().replaceAll(";;", ";-;");
				String[] info = linea.split(";");
				Accidente nuevo = comprobarAccidente(datos, info[6]);
				if(nuevo == null) {
					nuevo = new Accidente(info[6]);
					datos.add(nuevo);
				}
				comprobarGenero(nuevo, info[11]);
			}
			n.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return datos;
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual recibe un objeto de tipo accidente y un string el
	 * 		 cual lleva la informacion del genero, segun el caso que sea, aumenta
	 * 		 el atributo del objeto necesario.
	 */
	public static void comprobarGenero(Accidente nuevo, String genero) {
		if(genero.equalsIgnoreCase("hombre")) {
			nuevo.aumentarHombre();
		} else if(genero.equalsIgnoreCase("mujer")) {
			nuevo.aumentarMujer();
		} else {
			nuevo.aumentarDesconocido();
		}
	}
	
	/**
	 * Pre.---
	 * Post: metodo el cual dado un array de accidentes y un string con un nombre
	 * 		 recorre el array y si algun nombre coincide con el nombre pasado
	 * 		 como parametro, devuelve dicho objeto, sino devuelve null.
	 */
	public static Accidente comprobarAccidente(ArrayList<Accidente> datos, String tipo) {
		for(int i = 0; i < datos.size(); i++) {
			if(datos.get(i).getTipo().equalsIgnoreCase(tipo)) {
				return datos.get(i);
			}
		}
		return null;
	}
}
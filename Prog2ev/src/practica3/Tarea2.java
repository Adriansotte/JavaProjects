package practica3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Programa que solicita al usuario un nombre del fichero a revisar, muestra un resumen
 * del contenido del fichero en el que se indique el numero de usos totales recogidos en
 * el documento, distinguiendo cuantos de ellos se corresponden a traslados y cuantos de
 * ellos son circulares.
 */
public class Tarea2 {
	
	/**
	 * Pre:---
	 * Post: metodo principal donde introducimos el archivo a ser leido, se guarday se examina
	 * 		 mediante metodos para sacar la informacion necesaria.
	 */
	public static void main(String[] args) {
		System.out.println("----CONTAR USOS----");
		File usosBici = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\" +
			devolverRuta("Introduzca la ruta del fichero: "));
		ArrayList<UsoBici> datos = recogerDatos(usosBici);
		contarUsos(datos);
	}
	 /**
	  * Pre:---
	  * Post: metodo donde se recogen los datos del fichero y se introducen en un ArrayList.
	  */
	public static ArrayList<UsoBici> recogerDatos(File usosBici) {
		ArrayList<UsoBici> datos = new ArrayList<>();
		try {
			Scanner n = new Scanner(usosBici);
			n.nextLine();
			while(n.hasNextLine()) {
				String[] linea = n.nextLine().split(";");
				UsoBici nuevo = new UsoBici(Integer.parseInt(linea[2]), Integer.parseInt(linea[4]));
				datos.add(nuevo);
			}
			n.close();
			return datos;
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe un ArrayList donde esta la informacion del fichero en
	 * 		 cuestion, verifica la informacion y muestra por pantalla el resultado.
	 */
	public static void contarUsos(ArrayList<UsoBici> datos) {
		int traslado = 0;
		int circular = 0;
		for(int i = 0; i < datos.size(); i++) {
			if(datos.get(i).getEstacionSalida() == (datos.get(i).getEstacionDestino())) {
				circular++;
			} else {
				traslado++;
			}
		}
		mostrarDatos(traslado, circular);
	}
	
	/**
	 * Pre:---
	 * Post: metodo que sirve para mostrar los datos.
	 */
	public static void mostrarDatos(int traslado, int circular) {
		System.out.println("Numero de usos como traslado:  " + traslado);
		System.out.println("numero de usos circulares:     " + circular);
		System.out.println("Numero total de usos:          " + (traslado + circular));
	}
	
	/**
	 * Pre:---
	 * Post: metodo que sirve para preguntar al usuario por el nombre del documento.
	 */
	public static String devolverRuta(String preg) {
		System.out.print(preg);
		Scanner entrada = new Scanner(System.in);
		String nombre = entrada.next();
		entrada.close();
		return nombre;
	}
}
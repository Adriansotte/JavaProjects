package practica3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Programa que solicita al usuario la ruta de un fichero de datos de Bizi Zaragoza, y a continuacion
 * escriba en la pantalla el numero de usuarios distintos que aparecen en el fichero y un listado de
 * los 15 usuarios que mas usos han hecho del sistema segun el contenido del fichero. Para cada uno de
 * estos usuarios indicara el numero de usos entre estaciones distintas, el numero de usos entre la
 * misma estacion y el numero de usos totales. Este listado de los 15 usuarios mas activos debera 
 * aparecer ordenado de mayor a menor segun el numero de usos totales.
 */
public class Tarea3 {
	
	/**
	 * Pre:---
	 * Post: metodo principal donde se genera el documento a leer, se almacenan los datos necesarios
	 * 		 y se muestran por pantalla mediante diferentes metodos.
	 */
	public static void main(String[] args) {
		System.out.println("----USOS POR USUARIO----");
		File documento = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\" +
				devolverRuta("Dame el nombre del fichero: "));
		ArrayList<UsuarioBici> datos = recogerDatos(documento);
		Collections.sort(datos, new OrdenarUsuarios());
		mostrarDatos(datos);
	}
	
	/**
	 * Pre:---
	 * Post: metodo que se utiliza para mostrar datos del parametro recibido.
	 */
	public static void mostrarDatos(ArrayList<UsuarioBici> datos) {
		System.out.println("Numero de usuarios distintos: " + datos.size());
		System.out.println("Usuario     " + "Traslados    " + "Circular    " + "Total.");
		System.out.println("=======     " + "=========    " + "========    " + "======");
		for(int i = 0; i < 15 && i < datos.size(); i++) {
			System.out.println(datos.get(i).toString());
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametro un File de donde se sacara la informacion,
	 * 		 se comprobara mediante un metodo para luego almacenarlo en un ArrayList
	 * 		 que se devolvera.
	 */
	public static ArrayList<UsuarioBici> recogerDatos(File documento) {
		ArrayList<UsuarioBici> datos = new ArrayList<>();
		try {
			Scanner n = new Scanner(documento);
			n.nextLine();
			while(n.hasNextLine()) {
				String linea = n.nextLine();
				String[] nuevoUsuario = linea.split(";");
				gestionUsuarios(datos, nuevoUsuario);
			}
			n.close();
		} catch(FileNotFoundException e) {
			System.out.println(e);
		}
		return datos;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recive como parametro un ArrayList donde se encuentran los datos
	 * 		 referidos a los usuarios, y una tabla donde se guarda la informacion de la 
	 * 		 linea del fichero correspondiente. Se comprueba si el usuario existe y si es
	 * 		 asi, se actualizan los datos de dicho usuario dentro del ArrayList, en caso
	 * 		 contrario se crea un nuevo ususario, se actualizan sus datos y se agrega dicho
	 * 		 usuaio al ArrayList.
	 */
	public static void gestionUsuarios(ArrayList<UsuarioBici> datos, String[] nuevo) {
		if(datos.size() != 0) {
			UsuarioBici usuNuevo = comprobarUsuario(datos, nuevo[0]);
			comprobarRuta(usuNuevo, nuevo);
			if(usuNuevo == null) {
				usuNuevo = new UsuarioBici(nuevo[0]);
				datos.add(usuNuevo);
			}
		} else {
			UsuarioBici primero = new UsuarioBici(nuevo[0]);
			comprobarRuta(primero, nuevo);
			datos.add(primero);
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametro un objeto tipo UsuarioBici y una
	 * 		 tabla correspondiente a la liena del fichero. Se comprueba si la 
	 * 		 estacion de entrada es la misma que la estacion de salida y segun
	 * 	  	 el resultado se aumenta el aitributo de circular o traaslado de
	 * 		 dicho objeto.
	 */
	public static void comprobarRuta(UsuarioBici nuevo, String[] usuario) {
		if(usuario[2].equals(usuario[4])) {
			nuevo.aumentarCirculares();
		} else nuevo.aumentarTraslados();
	}
	
	/**
	 * Pre:---
	 * Post: Metodo que recibe como parametro el ArrayList de Usuarios y un String,
	 * 		 se recorre el array buscando si dicho String ya existe, si es el caso, 
	 * 		 devuelve como parametro al objeto que coincida con ese nombre, sino
	 * 		 devuelve null.
	 */
	public static UsuarioBici comprobarUsuario(ArrayList<UsuarioBici> datos, String usuario) {
		for(int i = 0; i < datos.size(); i++) {
			if(usuario.equals(datos.get(i).getUsuario())) {
				return datos.get(i);
			}
		}
		return null;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que sirve para preguntar al usuario por el nombre del documento.
	 */
	public static String devolverRuta(String preg) {
		System.out.print(preg);
		Scanner entrada = new Scanner(System.in);
		String ruta = entrada.next();
		entrada.close();
		return ruta;
	}
}
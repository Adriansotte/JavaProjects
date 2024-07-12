package binarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FciherosBinarios {
	
	/**
	 * Pre: El objeto [f] está asociado a un fichero en modo escritura de datos
	 * Post: Escribe, al final del fichero asociado a [f], los datos [producto],
	 * 		[cliente], [cantidad] y [precio] todo ellos codificados en binario.
	 */
	private static void escribir(DataOutputStream f, int producto, int cliente,
			int cantidad, double precio) {
			try {
				f.writeInt(producto);
				f.writeInt(cliente);
				f.writeInt(cantidad);
				f.writeDouble(precio);
			} catch (IOException e) {
				System.out.println("Error al escribir en el fichero");
			}
	}
	
	/**
	 * Pre: ---
	 * Post: Crea un fichero de ventas denominado [nombre] y almacena en él los
	 * 		valores definidos en la tabla de ventas. Cada venta está caracterizada
	 * 		por la cuadrápula de valores (producto, cliente, cantidad, precio).
	 */
	private static void crearFichero(String nombre) {
		try {
			/*
			 * Se crea un objbeto [DataOutputStream] al que se asocia un fichero
			 * denominado [nombre].
			 */
			DataOutputStream f = new DataOutputStream(new FileOutputStream(nombre));
			/*
			 * Se escriben los datos de cada una de las ventas en el fichero [f]
			 */
			escribir(f, 102, 14201, 7, 641.12);
			escribir(f, 403, 61734, 1, 512);
			escribir(f, 107, 9641, 25, 604.25);
			escribir(f, 302, 12603, 4, 811.135);
			/*
			 * Se libera el fichero asociado al objeto [f]
			 */
			f.close();
		} catch(FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto");
		} catch (IOException e) {
			System.out.println("Error en operación de E/S con el fichero " + nombre);
		}
	}
	
	/**
	 * Pre: ---
	 * Post: Presenta por pantalla los datos almacenados en un fichero de ventas 
	 * 		denominado [nombre]. En el caso de que no haya ningún fichero accesible con
	 * 		ese nombre informa con un mensaje de la circunstancia.
	 */
	private static void leerFichero(String nombre) {
		try {
			/*
			 * Se crea un objeto [DataInputStream] al que se asocia un fichero denominado
			 * [nombre].
			 */
			DataInputStream f = new DataInputStream(new FileInputStream(nombre));
			try {
				/*
				 * Se escriben por pantalla las dos líneas que encabezan la tabla de ventas
				 */
				System.out.println("PRODUCTO  CLIENTE  CANTIDAD  PRECIO");
				System.out.println("========  =======  ========  ======");
				while(true) {
					/*
					 * Se esriben por pantalla los datos de una de las ventas, tras
					 * haberlos leídos del fichero asociado a [f].
					 */
					int producto = f.readInt();
					int cliente = f.readInt();
					int cantidad = f.readInt();
					double precio = f.readDouble();
					System.out.printf(" %6d%10d%9d%10.2f%n", producto, cliente, cantidad, precio);
				}
				
			} catch(EOFException e) {}
			/*
			 * Se libera el fichero asociado al objeto [f]
			 */
			f.close();
		} catch(FileNotFoundException e) {
			System.out.println("El fichero " + nombre + " no ha podido ser abierto");
		} catch (IOException e) {
			System.out.println("Error en operación de E/S con el fichero " + nombre);
		}
	}
	
	/**
	 * Pre: ---
	 * Post: ejecuta el programa de prueba de escitura y lectura de un fichero binario
	 * 		que almacena ventas.
	 */
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		/*
		 * Solicitamos el path+nombre del fichero. Si existe, almacena la información
		 * seguida de la que ya estaba. Si no existe, lo crea nuevo.
		 */
		System.out.println("Indica el nombre del fichero binario: ");
		String nombre = entrada.nextLine();
		System.out.println();
		crearFichero(nombre);
		leerFichero(nombre);
		entrada.close();
	}
}

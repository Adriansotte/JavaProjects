package binarios;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PruebaBinario {

	/**
	 * Pre:---
	 * Post: preguntar lo del try catch para poner el documento.close()
	 */
	public static void main(String[] args) {
		try {
			DataInputStream documento = new DataInputStream(new FileInputStream("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\matriculas.dat"));
			while(true) {
				System.out.println(documento.readInt() + " " + documento.readInt());
			}
		} catch(FileNotFoundException e) {
			
		} catch(IOException e) {
			
		}
		
	}
}

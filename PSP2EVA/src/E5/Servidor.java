package E5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * Clase servidor la cual espera clientes para recibir sus peticiones y realizar
 * los trabajos pertinentes. Esta clase esta habilitada para recibir varios
 * clientes a la vez y gestionar sus peticiones creando Threads.
 */
public class Servidor extends Conexion { // Se hereda de conexión para hacer uso de los sockets y demás

	public ShareDataServidor1 baseDeDatos;
	
	public Servidor() throws IOException {
		super("servidor");
	}

	public void startServer() {// Método para iniciar el servidor
		try {
			baseDeDatos = new ShareDataServidor1();
			while (true) {
				System.out.println("Esperando...");
				cs = ss.accept();
				System.out.println("Cliente en línea");

				DataInputStream in = new DataInputStream(cs.getInputStream());
				DataOutputStream out = new DataOutputStream(cs.getOutputStream());
				
				ThreadServidor1 nuevo = new ThreadServidor1(in, out, cs, baseDeDatos);
				nuevo.start();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

package chatProject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase que sirve para la conexion con el servidor por parte del cliente
 */
public class ConexionCliente {

	private final int PUERTOSERVIDOR = 1234; // Puerto para que los clientes se conecten a Linda
	// public static int PUERTO_LINDA_SERVIDOR = 5678; // Puerto para que Linda se
	// conecte al servidor
	private final String HOST = "172.16.4.4"; // Host para la conexión
	protected ServerSocket ss; // Socket del servidor
	protected Socket cs; // Socket del cliente

	public ConexionCliente(String tipo) throws IOException { // Constructor
		cs = new Socket(HOST, PUERTOSERVIDOR);
	}
}

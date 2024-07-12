package chatProject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase cuya funcion sirve para generar un servudir en el puerto especificado.
 */
public class ConexionServidor {

	private final int PUERTOSERVIDOR = 1234; // Puerto para que los clientes se conecten a Linda
	// public static int PUERTO_LINDA_SERVIDOR = 5678; // Puerto para que Linda se
	// conecte al servidor
	//private final String HOST = "localhost"; // Host para la conexión
	protected ServerSocket ss; // Socket del servidor
	protected Socket cs; // Socket del cliente

	public ConexionServidor(String tipo) throws IOException {
		ss = new ServerSocket(PUERTOSERVIDOR);
	}
}

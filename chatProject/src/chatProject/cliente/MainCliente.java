package chatProject.cliente;

import java.io.IOException;

/**
 * Clase que inicia al cliente según la conexión que establece con el servidor.
 */
public class MainCliente {

	/**
	 * Pre:---
	 * Post: metodo el cual crea un cliente y lo inicializa
	 */
    public static void main(String[] args) throws IOException {
    	Cliente cli = new Cliente();
        System.out.println("Iniciando cliente\n");
        cli.startClient();
    }
}

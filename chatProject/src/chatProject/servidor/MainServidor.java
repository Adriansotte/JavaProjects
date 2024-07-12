package chatProject.servidor;

import java.io.IOException;

/**
 * Clase que inicializa el servidor
 */
public class MainServidor {

	public static void main(String[] args) throws IOException {
	      Servidor serv = new Servidor(); //Se crea el servidor

	      System.out.println("Iniciando servidor\n");
	      serv.startServer(); //Se inicia el servidor
	  }
}

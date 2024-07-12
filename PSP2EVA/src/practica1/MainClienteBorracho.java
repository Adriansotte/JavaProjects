package practica1;
import java.io.IOException;

/**
 * Clase que se utiliza para simular la actuacion de varios clientes,
 * se crean 15 threads que representa a cada usuario, asi pueden
 * actuar a la vez.
 */
public class MainClienteBorracho {
	
	/**
	 * Pre:---
	 * Post: metodo el cual crea los threads y los inicia.
	 */
	public static void main(String[] args) throws IOException {
		for(int i = 0; i < 15; i++) {
			ClienteThread cliente = new ClienteThread();
			cliente.start();
		}
	}
}




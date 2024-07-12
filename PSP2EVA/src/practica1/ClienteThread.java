package practica1;

import java.io.IOException;

/**
 * Clase que inicia un cliente para poder hacer las pruebas de 
 * varios clientes a la vez. 
 */
public class ClienteThread extends Thread{
	
	public void run() {
		try {
			ClienteBorracho cli = new ClienteBorracho();
			cli.startClient();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}

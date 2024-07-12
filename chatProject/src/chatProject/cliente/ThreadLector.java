package chatProject.cliente;

import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

import chatProject.servidor.ShareDataChats;

/**
 * Clase que implementa la operación de lectura del cliente.
 * Al recibir un mensaje comprueba si es una entrada o salida de una sala para hacer ciertas operaciones.
 */
public class ThreadLector extends Thread {

	private ObjectInputStream inCliente;
	
	private PrivateKey privateKeyCliente;
	
	public ObjectInputStream getIn() {
		return inCliente;
	}

	public void setIn(ObjectInputStream in) {
		this.inCliente = in;
	}

	public PrivateKey getPrivateKeyCliente() {
		return privateKeyCliente;
	}

	public void setPrivateKeyCliente(PrivateKey privateKeyCliente) {
		this.privateKeyCliente = privateKeyCliente;
	}

	private Cliente cliente;

	public ThreadLector(ObjectInputStream inCliente, PrivateKey privateKeyCliente, Cliente cliente) {
		this.inCliente = inCliente;
		this.privateKeyCliente = privateKeyCliente;
		this.cliente = cliente;
	}

	/**
	 * Pre:---
	 * Post: metodo el cual recoge el mensaje que recibe cliente, y lo muestra por pantalla.
	 */
	public void run() {
		try {
			while (true) {
				byte[] mensajeEncriptado = (byte[]) inCliente.readObject();
				String mensajeDelServidor = decrypt(mensajeEncriptado);
				if (mensajeDelServidor.startsWith("Entrada exitosa a la sala")) {
					String nombreSala = mensajeDelServidor.substring(mensajeDelServidor.lastIndexOf(" ") + 1);
					cliente.setSalaActual(nombreSala);
				} else if (mensajeDelServidor.startsWith("Salida exitosa de la sala")){
					cliente.setSalaActual(null);
				}
				System.out.println(mensajeDelServidor);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pre: --
	 * Post: Método que desencripta el mensaje recibido por el cliente
	 */
	public String decrypt(byte[] encryptedMessage) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, this.privateKeyCliente);
        return new String(cipher.doFinal(encryptedMessage));
    }
	
}

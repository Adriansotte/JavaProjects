package chatProject.cliente;

import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

import javax.crypto.Cipher;

import chatProject.servidor.ShareDataChats;

/**
 * Clase la cual gestiona todas las peticiones que envia el cliente al servidor,
 * es un hilo el cual se encarga de enviar todos los mensajes por parte del cliente.
 */
public class ThreadEscritor extends Thread{

	public ObjectOutputStream escribir;
	
	private PublicKey publicKeyServidor;

	private Scanner entrada;
	
	public ObjectOutputStream getEscribir() {
		return escribir;
	}

	public void setEscribir(ObjectOutputStream escribir) {
		this.escribir = escribir;
	}

	public PublicKey getPrivateKeyServidor() {
		return publicKeyServidor;
	}

	public void setPrivateKeyServidor(PublicKey publicKeyServidor) {
		this.publicKeyServidor = publicKeyServidor;
	}

	public Scanner getEntrada() {
		return entrada;
	}

	public void setEntrada(Scanner entrada) {
		this.entrada = entrada;
	}

	private Cliente cliente;

	public ThreadEscritor(ObjectOutputStream escribir, PublicKey publicKeyServidor, Cliente cliente) {
		this.escribir = escribir;
		this.publicKeyServidor = publicKeyServidor;
		this.entrada = new Scanner(System.in);
		this.cliente = cliente;
	}
	
	/**
	 * Pre:---
	 * Post: metodo principal el cual se encarga de enviar todos los mensajes al servidor
	 * 		 mediante un bucle infinito.
	 */
	public void run() {
		try {
			System.out.println("(opciones) para ver opciones");
			while(true) {
				Thread.sleep(100);
				System.out.println("----------------------------------------------------");
				String mensaje = recogerMensaje();
				escribir.writeObject(encrypt(mensaje));
    		}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual recoge el mensaje del cliente, se asegura de que las condiciones en las que
	 * 		 se recoge el mensaje sea la mas optima y devuelve el mensaje como parametro.
	 */
	public String recogerMensaje() {
		if ( cliente.getSalaActual() != null ) {
			System.out.print("[" + cliente.nombreCliente + "] : " + "[" + cliente.getSalaActual() + "] > ");
			String mensaje = entrada.nextLine();
			if(mensaje.length() > 140){
				return "NO SE PERMITEN MENSAJES DE MÁS DE 140 CARÁCTERES";
			}
			return "mensaje" + " " + cliente.getSalaActual() + " :" + mensaje;
		} else {
			System.out.print("[" + cliente.nombreCliente + "] > ");
			String peticion = entrada.nextLine();
			if(peticion.length() > 140){
				return "NO SE PERMITEN MENSAJES DE MÁS DE 140 CARÁCTERES";
			}
			return peticion;
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual encripta el mensaje que recibe como parametro y
	 * 		 devuelve una cadena de bytes.
	 */
	public byte[] encrypt(String message) throws Exception {
	    Cipher cipher = Cipher.getInstance("RSA");
	    cipher.init(Cipher.ENCRYPT_MODE, this.publicKeyServidor);
	    return cipher.doFinal(message.getBytes());
	}
	 
}

package chatProject.cliente;

import java.io.*;
import java.util.Scanner;
import java.security.*;
import javax.crypto.*;

import chatProject.ConexionCliente;

/**
 * Método que utiliza el cliente para poder ingresar al chat, enviar
 * mensajes y recibir. 
 */
public class Cliente extends ConexionCliente{

	public ThreadEscritor escritor;
	public ThreadLector lector;
	public String nombreCliente = "Adrián";
	private PrivateKey privateKey;
    private PublicKey publicKey;
    
    private PublicKey publicKeyServidor;

	private ObjectOutputStream out;

	private volatile String salaActual = null;

	public void setSalaActual(String sala) {
		this.salaActual = sala;
	}

	public String getSalaActual() {
		return salaActual;
	}
	
	public Cliente() throws IOException {
        super("cliente");
    }
	
	/**
	 * Pre:---
	 * Post: método principal el cual inicializa al cliente, genera las claves privadas
	 * 		 y publicas. Intercambia sus claves con el servidor.
	 */
	public void startClient() {
		try {
			out = new ObjectOutputStream(cs.getOutputStream());
    		ObjectInputStream in = new ObjectInputStream(cs.getInputStream());
    		this.publicKeyServidor = (PublicKey) in.readObject();
    		generarClaves();
			out.writeObject(publicKey);
			out.writeObject(nombreCliente);
            escritor = new ThreadEscritor(out, publicKeyServidor, this);
            lector = new ThreadLector(in, privateKey, this);
            lector.start();
			escritor.start();
		} catch(Exception e) {}
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual genera las claves para asignarselas al cliente mediante encriptacion
	 * 		 RSA.
	 */
	public void generarClaves() {
		KeyPairGenerator keyGen;
		try {
			keyGen = KeyPairGenerator.getInstance("RSA");
			keyGen.initialize(2048);
			KeyPair pair = keyGen.generateKeyPair();
			this.privateKey = pair.getPrivate();
			this.publicKey = pair.getPublic();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
}
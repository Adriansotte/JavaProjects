package chatProject.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;

import chatProject.ConexionServidor;

/**
 * Clase que configura el servidor y crea un ThreadServidor donde gestionmos las peticiones de los clientes
 */
public class Servidor extends ConexionServidor {

	public ShareDataChats chats = new ShareDataChats();
	
	public PrivateKey privateKeyServidor;
	
	public PublicKey publicKeyServidor;

	private PublicKey publicKeyCliente;

	private String nombreCliente;
	
	public Servidor() throws IOException {
    	super("servidor");
    }
	
	/**
	 * Pre: --
	 * Post: Método que inicia el servidor y manda al cliente a su ThreadServidor correspondiente
	 */
	public void startServer() {
        try {
        	while(true) {
        		System.out.println("Esperando...");
        		cs = ss.accept();
        		System.	out.println("Cliente en línea");
        		generarClaves();
        		
        		ObjectInputStream servidorIn = new ObjectInputStream(cs.getInputStream());
        		
        		ObjectOutputStream servidorOut = new ObjectOutputStream(cs.getOutputStream());

        		servidorOut.writeObject(publicKeyServidor);

				publicKeyCliente = (PublicKey) servidorIn.readObject();
				nombreCliente = (String) servidorIn.readObject();

        		ThreadServidor nuevo = new ThreadServidor(servidorOut, servidorIn, cs, chats, privateKeyServidor, publicKeyServidor, publicKeyCliente, nombreCliente);
        		nuevo.start();
        		
        	}     
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	/**
	 * Pre: --
	 * Post: Método que genera las claves para encriptar los mensajes entre usuario y servidor
	 */
	public void generarClaves() {
		KeyPairGenerator keyGen;
		try {
			keyGen = KeyPairGenerator.getInstance("RSA");
			keyGen.initialize(2048);
			KeyPair pair = keyGen.generateKeyPair();
			this.privateKeyServidor = pair.getPrivate();
			this.publicKeyServidor = pair.getPublic();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
}

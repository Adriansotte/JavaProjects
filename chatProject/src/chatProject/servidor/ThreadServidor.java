package chatProject.servidor;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.PrivateKey;
import java.security.PublicKey;

import javax.crypto.Cipher;

/**
 * Parte del servidor que gestiona las peticiones del cliente
 */
public class ThreadServidor extends Thread {

	ObjectOutputStream servidorOut;
	
	ObjectInputStream servidorIn;
	
	private Socket cs;

	public ShareDataChats chats;

	public PerfilChat perfil;

	private PrivateKey privateKeyServidor;

	private PublicKey publicKeyServidor;

	private PublicKey publicKeyCliente;

	private String nombreCliente;

	public ObjectOutputStream getServidorOut() {
		return servidorOut;
	}

	public void setServidorOut(ObjectOutputStream servidorOut) {
		this.servidorOut = servidorOut;
	}

	public ObjectInputStream getServidorIn() {
		return servidorIn;
	}

	public void setServidorIn(ObjectInputStream servidorIn) {
		this.servidorIn = servidorIn;
	}

	public Socket getCs() {
		return cs;
	}

	public void setCs(Socket cs) {
		this.cs = cs;
	}

	public ShareDataChats getChats() {
		return chats;
	}

	public void setChats(ShareDataChats chats) {
		this.chats = chats;
	}

	public PerfilChat getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilChat perfil) {
		this.perfil = perfil;
	}

	public PrivateKey getPrivateKeyServidor() {
		return privateKeyServidor;
	}

	public void setPrivateKeyServidor(PrivateKey privateKeyServidor) {
		this.privateKeyServidor = privateKeyServidor;
	}

	public PublicKey getPublicKeyServidor() {
		return publicKeyServidor;
	}

	public void setPublicKeyServidor(PublicKey publicKeyServidor) {
		this.publicKeyServidor = publicKeyServidor;
	}

	public PublicKey getPublicKeyCliente() {
		return publicKeyCliente;
	}

	public void setPublicKeyCliente(PublicKey publicKeyCliente) {
		this.publicKeyCliente = publicKeyCliente;
	}

	public ThreadServidor(ObjectOutputStream servidorOut, ObjectInputStream servidorIn, Socket cs, ShareDataChats chats,
						  PrivateKey privateKeyServidor, PublicKey publicKeyServidor, PublicKey publicKeyCliente, String nombreCliente) {
		this.servidorOut = servidorOut;
		this.servidorIn = servidorIn;
		this.cs = cs;
		this.chats = chats;
		this.perfil = new PerfilChat(servidorOut, publicKeyCliente, nombreCliente);
		this.privateKeyServidor = privateKeyServidor;
		this.publicKeyServidor = publicKeyServidor;
		this.publicKeyCliente = publicKeyCliente;
		this.nombreCliente = nombreCliente;
	}

	/**
	 * Pre: --
	 * Post: Método que inicia ThreadServidor y gestiona y se comunica con el cliente
	 */
	public void run() {
		try {
			
			perfil = new PerfilChat(servidorOut, publicKeyCliente, nombreCliente);

			System.out.println("INFORMACIÓN DEL PERFIL: " + perfil.getNombre());
			
			while (true) {
				byte[] mensajeEncriptado = (byte[]) servidorIn.readObject();
				
				String mensajeDesencriptado = decrypt(mensajeEncriptado);
				
				String[] mensajeSeparado = mensajeDesencriptado.split(" ");

				String mensajeStatus = "";
				if (mensajeSeparado[0].equalsIgnoreCase("salir")) {
					break;
				} else if (mensajeSeparado[0].equalsIgnoreCase("crear")) {
                    if (mensajeSeparado.length == 2) {
                        mensajeStatus += chats.crearSala(mensajeSeparado[1], "");
                    } else if (mensajeSeparado.length == 3) {
						mensajeStatus += chats.crearSala(mensajeSeparado[1], mensajeSeparado[2]);
                    }
					servidorOut.writeObject(encrypt(mensajeStatus));
                } else if (mensajeSeparado[0].equalsIgnoreCase("MOSTRAR")) {
					servidorOut.writeObject(encrypt(chats.mostrarSalas()));
				} else if (mensajeSeparado[0].equalsIgnoreCase("DESC")) {
					break;
				} else if (mensajeSeparado[0].equalsIgnoreCase("opciones")) {
					servidorOut.writeObject(encrypt(opciones()));
				} else if (mensajeSeparado[0].equalsIgnoreCase("entrar")) {
					if (mensajeSeparado.length == 2) {
						mensajeStatus += chats.entrarSala(mensajeSeparado[1], "", perfil);
					} else if (mensajeSeparado.length == 3) {
						mensajeStatus += chats.entrarSala(mensajeSeparado[1], mensajeSeparado[2], perfil);
					}
					servidorOut.writeObject(encrypt(mensajeStatus));
				} else if (mensajeSeparado[0].equalsIgnoreCase("mensaje")){
					String[] ordenSeparada = mensajeDesencriptado.split(":");
					if(!ordenSeparada[1].equals("/disconnect")){
						chats.enviarMensaje(chats.buscarSalaChatPorNombre(mensajeSeparado[1]), ordenSeparada[1], perfil);
					} else if (ordenSeparada[1].equals("NO SE PERMITEN MENSAJES DE MÁS DE 140 CARÁCTERES")) {
						mensajeStatus += "NO SE PERMITEN MENSAJES DE MÁS DE 140 CARÁCTERES";
						servidorOut.writeObject(encrypt(mensajeStatus));
					} else {
						mensajeStatus += chats.salirSala(mensajeSeparado[1], perfil);
						servidorOut.writeObject(encrypt(mensajeStatus));
					}
				} else if (mensajeDesencriptado.equals("NO SE PERMITEN MENSAJES DE MÁS DE 140 CARÁCTERES")) {
					mensajeStatus += "NO SE PERMITEN MENSAJES DE MÁS DE 140 CARÁCTERES";
					servidorOut.writeObject(encrypt(mensajeStatus));
				}
			}
			cs.close();

		} catch (Exception e) {

		}
	}

	/**
	 * Pre: --
	 * Post: Método que muestra el menu de opciones disponible en nuestro servidor
	 */
	public String opciones() {
		String mensajeOpciones = ("Entrar Sala (entrar (nombre de la sala) (contraseña de sala))\n");
		mensajeOpciones += ("Crear Sala (crear (nombre de la sala) (contraseña de sala))\n");
		mensajeOpciones += ("Salir de sala (/disconnect)\n");
		mensajeOpciones += ("Mostrar salas (Mostrar)\n");

		return mensajeOpciones;
	}
	
	/**
	 * Pre: --
	 * Post: Método que encripta el mensaje que se le manda al cliente
	 */
	 public byte[] encrypt(String message) throws Exception {
	        Cipher cipher = Cipher.getInstance("RSA");
	        cipher.init(Cipher.ENCRYPT_MODE, this.publicKeyCliente);
	        return cipher.doFinal(message.getBytes());
	    }
	
	 /**
	 * Pre: --
	 * Post: Método que desencripta el mensaje recibido por el cliente
	 */
	public String decrypt(byte[] encryptedMessage) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, this.privateKeyServidor);
        return new String(cipher.doFinal(encryptedMessage));
    }
	
}

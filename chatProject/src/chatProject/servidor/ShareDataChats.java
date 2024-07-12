package chatProject.servidor;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.util.ArrayList;

import javax.crypto.Cipher;

import java.security.SecureRandom;
import java.util.Random;

/**
 * Clase que gestiona las operaciones disponibles en una sala de chat.
 * Permite crear salas de chat, buscarlas, mostrarlas, entrar y salir de ellas,
 * además de enviar mensajes entre los integrantes.
 */
public class ShareDataChats {

	public ArrayList<SalaChat> chats;

	public ArrayList<SalaChat> getChats() {
		return chats;
	}

	public void setChats(ArrayList<SalaChat> chats) {
		this.chats = chats;
	}

	public ShareDataChats() {
		this.chats = new ArrayList<>();
	}

	/**
	 * Crea una nueva sala de chat con un nombre y una contraseña opcional.
	 *
	 * pre: nombre no debe ser nulo. contrasena puede ser nula o vacía para indicar que no se desea contraseña.
	 * post: devuelve un mensaje indicando el éxito de la operación o un error si una sala con el mismo nombre ya existe.
	 *       Crea la sala con contraseña si se recibe el parámetro contrasena.
	 */
	public synchronized String crearSala(String nombre, String contrasena) throws Exception {
		String mensajeStatus = "";
		SalaChat nuevaSala = null;

		String nombreCompleto = nombre + generadorAlfanumericoRandom();
		try {
			for (SalaChat sala : chats) {
				if (sala.getNombreSala().equalsIgnoreCase(nombreCompleto)) {
					mensajeStatus += "ERROR: Una sala con ese nombre ya existe.";
					return mensajeStatus;
				}
			}

			if(contrasena.isEmpty()) {
				nuevaSala = new SalaChat(nombreCompleto);
			} else {
				nuevaSala = new SalaChat(nombreCompleto, hashContrasena(contrasena));
			}
			chats.add(nuevaSala);
			mensajeStatus += "SALA " + nuevaSala.getNombreSala() + " CREADA CON ÉXITO";
		} catch ( Error e ) {
			mensajeStatus += "ERROR AL CREAR LA SALA: " + e;
		}
		return mensajeStatus;
	}

	/**
	 * Busca una sala de chat por su nombre.
	 *
	 * pre: orden no debe ser nulo.
	 * post: devuelve la sala que coincide con el nombre dado o null si no existe tal sala.
	 */
	public SalaChat buscarChat(String orden) {
		for(int i = 0; i < chats.size(); i++) {
			if(chats.get(i).getNombreSala().equalsIgnoreCase(orden)) {
				return chats.get(i);
			}
		}
		return null;
	}

	/**
	 * Lista todas las salas creadas mostrando su estado de protección.
	 *
	 * pre: ---
	 * post: devuelve una cadena de texto con la lista de todas las salas y su estado (PROTEGIDA/LIBRE).
	 */
	public String mostrarSalas(){
		String mensajeMostrarSalas = "";
		for(SalaChat sala : chats){
			if(!sala.getPassSala().isEmpty()){
				mensajeMostrarSalas += sala.getNombreSala() + " PROTEGIDA\n";
			} else {
				mensajeMostrarSalas += sala.getNombreSala() + " LIBRE\n";
			}
		}
		return mensajeMostrarSalas;
	}

	/**
	 * Permite a un usuario entrar a una sala dado el nombre de la sala, la contraseña (si es necesaria) y el perfil del usuario.
	 *
	 * pre: nombreSala y perfilChat no deben ser nulos. contrasena puede ser nula si la sala no está protegida.
	 * post: devuelve un mensaje indicando el resultado de la operación. Agrega al usuario a la sala si cumple con los requisitos.
	 */
	public String entrarSala(String nombreSala, String contrasena, PerfilChat perfilChat) throws Exception{
		SalaChat salaChat = buscarChat(nombreSala);
		String mensajeStatus = "";
		if (salaChat == null) {
			return "ERROR: La sala no existe.";
		}

		if (!salaChat.getPassSala().isEmpty()) {
			if(salaChat.getPassSala().equals(hashContrasena(contrasena))) {
				salaChat.anadirIntegrante(perfilChat);
				mensajeStatus = "Entrada exitosa a la sala " + nombreSala;
				enviarMensaje(salaChat, perfilChat.getNombre() + " se ha unido a la sala.", perfilChat);
			} else {
				mensajeStatus = "Contraseña incorrecta para la sala " + nombreSala;
			}
		} else {
			salaChat.anadirIntegrante(perfilChat);
			mensajeStatus = "Entrada exitosa a la sala " + nombreSala;
			enviarMensaje(salaChat, perfilChat.getNombre() + " se ha unido a la sala.", perfilChat);
		}

		return mensajeStatus;
	}

	/**
	 * Envía un mensaje a todos los integrantes de una sala.
	 *
	 * pre: sala y perfilChat no deben ser nulos. mensaje no debe ser nulo.
	 * post: envía el mensaje encriptado a todos los integrantes de la sala excepto al remitente.
	 */
	public void enviarMensaje(SalaChat sala, String mensaje, PerfilChat perfilChat) throws Exception {
		try {
			for(PerfilChat integrante : sala.getIntegrantes()) {
				if(!integrante.getNombre().equals(perfilChat.getNombre())){
					System.out.println("VOY A ");
					String mensajeSinEncriptar = "(" + perfilChat.getNombre() + ") " + mensaje;
					integrante.getClienteOut().writeObject(encrypt(mensajeSinEncriptar, integrante.getPublicKeyCliente()));
					System.out.println(encrypt(mensajeSinEncriptar, integrante.getPublicKeyCliente()));
				}
			}
		} catch (Error | IOException e) {

		}
	}

	/**
	 * Busca una sala de chat por su nombre.
	 *
	 * pre: nombreSala no debe ser nulo.
	 * post: devuelve la sala que coincide con el nombre dado o null si no existe tal sala.
	 */
	public SalaChat buscarSalaChatPorNombre(String nombreSala) {
		for (SalaChat sala : chats) {
			if (sala.getNombreSala().equalsIgnoreCase(nombreSala)) {
				return sala;
			}
		}
		return null;
	}

	/**
	 * Permite a un usuario salir de una sala de chat.
	 *
	 * pre: nombreSala y perfilChat no deben ser nulos.
	 * post: devuelve un mensaje de éxito y elimina al usuario de la lista de integrantes de la sala.
	 */
	public String salirSala(String nombreSala, PerfilChat perfilChat) throws InterruptedException {
		SalaChat salaChat = buscarChat(nombreSala);
		String mensajeStatus = "";
		
		mensajeStatus += "Salida exitosa de la sala";
		salaChat.quitarIntegrante(perfilChat);
		return mensajeStatus;
	}
	
	 // Este método hashContrasena toma una contraseña en forma de String, calcula su hash usando SHA-256, 
    // convierte el hash a un String.
    
    public String hashContrasena(String password) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hash = md.digest(password.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte b : hash) {
            sb.append(String.format("%02x", b));
        }
        String contrasenaHash = (sb.toString());
        return contrasenaHash;
    }

	// Método para encriptar mensajes
	 public byte[] encrypt(String message, PublicKey publicKey) throws Exception {
	        Cipher cipher = Cipher.getInstance("RSA");
	        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
	        return cipher.doFinal(message.getBytes());
	}

	// Método para añadir el # al nombre de la sala
	public String generadorAlfanumericoRandom(){
		String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
		String CHAR_UPPER = CHAR_LOWER.toUpperCase();
		String NUMBER = "0123456789";

		final String DATA_FOR_RANDOM_STRING = CHAR_LOWER + CHAR_UPPER + NUMBER;
		SecureRandom random = new SecureRandom();

		StringBuilder codigoAlfanumerico = new StringBuilder(6);
		codigoAlfanumerico.append("#");

		for (int i = 0; i < 6; i++) {
			int rndCharAt = random.nextInt(DATA_FOR_RANDOM_STRING.length());
			char rndChar = DATA_FOR_RANDOM_STRING.charAt(rndCharAt);

			codigoAlfanumerico.append(rndChar);
		}
		return codigoAlfanumerico.toString();
	}
}

package chatProject.servidor;

import java.io.ObjectOutputStream;
import java.security.PublicKey;

/**
 * Clase que define el objeto PerfilChat
 */
public class PerfilChat {

	public String nombreCliente;
	
	public ObjectOutputStream clienteOut;

	public PublicKey publicKeyCliente;

	public String getNombre() {
		return nombreCliente;
	}

	public void setNombre(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public ObjectOutputStream getClienteOut() {
		return clienteOut;
	}

	public void setClienteOut(ObjectOutputStream clienteOut) {
		this.clienteOut = clienteOut;
	}

	public PublicKey getPublicKeyCliente() {
		return publicKeyCliente;
	}

	public void setPublicKeyCliente(PublicKey publicKeyCliente) {
		this.publicKeyCliente = publicKeyCliente;
	}

	public PerfilChat(ObjectOutputStream clienteOut, PublicKey publicKeyCliente, String nombreCliente) {
		this.nombreCliente = nombreCliente;
		this.clienteOut = clienteOut;
		this.publicKeyCliente = publicKeyCliente;
	}
	
}

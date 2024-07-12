package chatProject.servidor;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

/**
 * Representa una sala de chat en un servidor, permitiendo la creación y gestión de salas con o sin contraseña.
 * Permite añadir y quitar integrantes de la sala.
 */
public class SalaChat {

	public ArrayList<PerfilChat> integrantes;
	
	public String nombreSala;
	
	public String passSala;

	public ArrayList<PerfilChat> getIntegrantes() {
		return integrantes;
	}

	public void setIntegrantes(ArrayList<PerfilChat> integrantes) {
		this.integrantes = integrantes;
	}

	public String getNombreSala() {
		return nombreSala;
	}

	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}

	public String getPassSala() {
		return passSala;
	}

	public void setPassSala(String passSala) {
		this.passSala = passSala;
	}

	public Semaphore s1 = new Semaphore(1);

	/**
	 * Constructor de la sala con contraseña.
	 *
	 * pre: nombreSala y passSala no deben ser null.
	 * post: crea una sala con el nombre y contraseña proporcionados. La lista de integrantes se inicializa vacía.
	 */
	public SalaChat(String nombreSala, String passSala) {
		this.nombreSala = nombreSala;
		this.passSala = passSala;
		this.integrantes = new ArrayList<>();
	}

	/**
	 * Constructor de la sala sin contraseña.
	 *
	 * pre: nombreSala no debe ser null.
	 * post: crea una sala con el nombre proporcionado y sin contraseña. La lista de integrantes se inicializa vacía.
	 */
	public SalaChat(String nombreSala) {
		this.nombreSala = nombreSala;
		this.passSala = "";
		this.integrantes = new ArrayList<>();
	}

	/**
	 * Añade un integrante a la sala.
	 *
	 * pre: perfilChat no debe ser null. Debe haber disponibilidad en el semáforo para ejecutar la operación.
	 * post: el perfilChat proporcionado se añade a la lista de integrantes de la sala.
	 */
	public void anadirIntegrante(PerfilChat perfilChat) throws InterruptedException {
		s1.acquire();
		integrantes.add(perfilChat);
		s1.release();
	}

	/**
	 * Quita un integrante de la sala.
	 *
	 * pre: perfilChat no debe ser null y debe estar en la lista de integrantes. Debe haber disponibilidad en el semáforo para ejecutar la operación.
	 * post: el perfilChat proporcionado se quita de la lista de integrantes de la sala.
	 */
	public void quitarIntegrante(PerfilChat perfilChat) throws InterruptedException {
		s1.acquire();
		integrantes.remove(perfilChat);
		s1.release();
	}
}

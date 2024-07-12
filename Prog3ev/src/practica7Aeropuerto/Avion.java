package practica7Aeropuerto;

import java.util.ArrayList;

/**
 * Metodo que simula un avion, el cual se identifica con un numero y tiene
 * su ArrayList de objetos de tipo Pasajero.
 */
public class Avion {

	private int numero;
	private ArrayList<Pasajero> pasajeros;
	
	public Avion(int numero) {
		this.numero = numero;
		this.pasajeros = new ArrayList<>();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public ArrayList<Pasajero> getPasajeros() {
		return pasajeros;
	}

	public void setPasajeros(ArrayList<Pasajero> pasajeros) {
		this.pasajeros = pasajeros;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recorre todo el ArrayList de pasajeros y muestra su informacion.
	 */
	public void showInfo() {
		System.out.println("El avion con el numero: " + this.numero + "\nTiene los siguientes pasajeros: ");
		for(int i = 0; i < pasajeros.size(); i++) {
			System.out.println(pasajeros.get(i).toString());
		}
	}
}
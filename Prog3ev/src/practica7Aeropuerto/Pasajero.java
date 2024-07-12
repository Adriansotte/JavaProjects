package practica7Aeropuerto;

/**
 * Clase que representa a un pasajero de un avion, se identifica por el dni
 * el nombre y el numero del avion al que se dirige.
 */
public class Pasajero {

	private String dni;
	private String nombre;
	private int numeroAvion;
	
	public Pasajero(String dni, String nombre, int numeroAvion) {
		this.dni = dni;
		this.nombre = nombre;
		this.numeroAvion = numeroAvion;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumeroAvion() {
		return numeroAvion;
	}

	public void setNumeroAvion(int numeroAvion) {
		this.numeroAvion = numeroAvion;
	}
	
	@Override
	public String toString() {
		return "\tNombre: " + this.nombre + "\tDni: " + this.dni + "\tNumero vuelo: " + this.numeroAvion;
	}
}
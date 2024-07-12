package practica6JuegoDeRol;

/**
 * Clase que recoge la informacion del objeto de tipo jugador.
 * El cual como atributos tiene otros objetos creados en este paquete, 
 * quejunto a ellos representa el objeto con el cual el jugador va a
 * reccorer la historia de nuestro juego.
 */
public class Jugador {

	private String nombre;
	private Tipo tipo;
	private Arma arma;
	private Remate remate;
	private int contRemate;
	
	public Jugador(String nombre, Tipo tipo, Arma arma, Remate remate) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.arma = arma;
		this.remate = remate;
	}
	
	public Jugador(String nombre, Tipo tipo, Arma arma, Remate remate, int contRemate) {
		this.nombre = nombre;
		this.tipo = tipo;
		this.arma = arma;
		this.remate = remate;
		this.contRemate = contRemate;
	}

	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Tipo getTipo() {
		return tipo;
	}
	
	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
	
	public Arma getArma() {
		return arma;
	}
	
	public void setArma(Arma arma) {
		this.arma = arma;
	}
	
	public Remate getRemate() {
		return remate;
	}
	
	public void setRemate(Remate remate) {
		this.remate = remate;
	}
	
	public int getContRemate() {
		return contRemate;
	}
	
	public void setContRemate(int contRemate) {
		this.contRemate = contRemate;
	}	
	
	/**
	 * Pre:---
	 * Post: metodo que aumenta en 1 el atributo de remate.
	 */
	public void aumentarRemate() {
		contRemate += 1;
	}
	
	@Override
	public String toString() {
		return "\tNombre: " + nombre + "\n\tTipo: " + tipo.toString() + "\n\tArma: " + 
				arma.toString() + "\n\tRemate: " + remate.toString();
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual muestra por pantalla informacion sobre el remate del personaje.
	 */
	public void mostrarRemate() {
		System.out.println(nombre + " intenta hacer un " + getRemate().getRemate() + 
				" que hara como maximo " + getRemate().getDaño() + " de daño.");
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual muestra por pantalla informacion sobre la vida del personaje.
	 */
	public void mostrarVida() {
		System.out.println(nombre + ": " + tipo.getVida() + " HP");
	}
}

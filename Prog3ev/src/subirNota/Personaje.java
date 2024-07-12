package subirNota;

/**
 * Clase que representa al jugador promedio que se va a posicionar en el tablero.
 */
public class Personaje {

	protected String nombre;
	protected int vida;
	protected int daño;
	protected String color;

	public Personaje(String nombre, int vida, int daño, String color) {
		this.nombre = nombre;
		this.vida = vida;
		this.daño = daño;
		this.color = color;
	}
	
	public Personaje(String nombre) {
		this.nombre = nombre;
		this.vida = 0;
		this.daño = 0;
		this.color = "verde";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getDaño() {
		return daño;
	}

	public void setDaño(int daño) {
		this.daño = daño;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}	
	
	@Override
	public String toString() {
		return "Nombre: " + nombre + " Vida: " + vida + " Daño: " + daño + " Color: " + color;
	}
}

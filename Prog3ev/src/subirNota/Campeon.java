package subirNota;

/**
 * Clase que representa a un personaje jugable dentro del tablero.
 * Esta clase es una herencia de la clase Personaje.
 */
public class Campeon extends Personaje {

	private int nivel;
	private int defensa;
	
	public Campeon(String nombre, int vida, int daño, String color, int defensa) {
		super(nombre, vida, daño, color);
		this.nivel = 1;
		this.defensa = defensa;
	}
	
	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que aumenta el nivel del personaje y con ello sus atributos.
	 */
	public void aumentarNivel() {
		if(this.nivel < 10) {
			this.nivel += 1;
			this.daño += 10;
			this.defensa += 10;
		} else {
			System.out.println("Nivel maximo alcanzado!!!");
		}
	}
}

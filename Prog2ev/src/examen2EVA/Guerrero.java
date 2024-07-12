package examen2EVA;

/**
 * Clase que hereda de jugador donde se describe un rol que 
 * puede desempeñar la claase padre.
 */
public class Guerrero extends Jugador{

	public Guerrero(String nombre, int mana, int daño) {
		super(nombre, mana, daño);	
		
	}

	@Override
	public int ataqueBasico() {
		return this.daño * (int) Math.floor(Math.random()*(10-0)+0);
	}

	@Override
	public int ataqueEspecial() {
		this.mana -= 20;
		return this.daño * (int) Math.floor(Math.random()*(20-10)+0);
	}
		
}

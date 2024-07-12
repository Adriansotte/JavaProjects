package examen2EVA;

/**
 * Clase que hereda de la cclase Jugador que describe el rol de
 * mago que puede adoptar la clase padre.
 */
public class Mago extends Jugador{

	public Mago(String nombre, int mana, int daño) {
		super(nombre, mana, daño);
	}

	@Override
	public int ataqueBasico() {
		return this.daño * (int) Math.floor(Math.random()*(5-0)+0);
	}

	@Override
	public int ataqueEspecial() {
		this.mana -= 50;
		return this.daño * (int) Math.floor(Math.random()*(30-20)+0);
	}

	
}

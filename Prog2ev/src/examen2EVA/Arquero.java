package examen2EVA;

/**
 * Clase que hereda de la clase Jugador que describe el rol de
 * mago que puede adoptar la clase padre.
 */
public class Arquero extends Jugador{

	public Arquero(String nombre, int mana, int daño) {
		super(nombre, mana, daño);
	}

	@Override
	public int ataqueBasico() {
		return this.daño * (int) Math.floor(Math.random()*(20-1)+0);
	}

	@Override
	public int ataqueEspecial() {
		this.mana -= 20;
		return this.daño * (int) Math.floor(Math.random()*(25-5)+0);
	}

}

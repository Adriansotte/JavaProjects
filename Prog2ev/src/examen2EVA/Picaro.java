package examen2EVA;

/**
 * Clase que hereda de la clase Jugador que describe el rol de
 * Picaro que puede adoptar la clase padre.
 */
public class Picaro extends Jugador{

	public Picaro(String nombre, int mana, int daño) {
		super(nombre, mana, daño);
	}

	@Override
	public int ataqueBasico() {
		return this.daño * (int) Math.floor(Math.random()*(20-0)+0);
	}

	@Override
	public int ataqueEspecial() {
		this.mana -= 10;
		return this.daño * (int) Math.floor(Math.random()*(20-10)+0);
	}

}

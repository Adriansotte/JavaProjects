package examen2EVA;

/**
 * Clase enemigo que hereda de la calse Jugador, esta clase
 * describe a un enemigo junto con sus propiedades y sus metodos.
 */
public class Enemigo extends Jugador{

	public Enemigo(String nombre, int mana, int daño) {
		super(nombre, mana, daño);
		this.vida = 500;
	}

	@Override
	public int ataqueBasico() {
		return this.daño * (int) Math.floor(Math.random()*(20-1)+0);
	}

	@Override
	public int ataqueEspecial() {
		this.mana -= 40;
		return this.daño * (int) Math.floor(Math.random()*(40-20)+0);
	}

}

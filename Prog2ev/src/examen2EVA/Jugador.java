package examen2EVA;

import java.util.ArrayList;

/**
 * clase madre jugador que contiene los atributos necesarios
 * para desarrollar un juego de roll.
 */
public class Jugador implements TiposAtaques{

	protected String nombre;
	protected int vida;
	protected int mana;
	protected int daño;
	protected ArrayList<Pocion> pociones;
	
	public Jugador(String nombre, int mana, int daño) {
		this.nombre = nombre;
		this.vida = 100;
		this.mana = mana;
		this.daño = daño;
		this.pociones = new ArrayList<Pocion>();
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
		this.vida -= vida;
	}
	
	public int getMana() {
		return mana;
	}
	
	public void setMana(int mana) {
		this.mana = mana;
	}
	
	public int getDaño() {
		return daño;
	}
	
	public void setDaño(int daño) {
		this.daño = daño;
	}
	
	public ArrayList<Pocion> getPociones() {
		return pociones;
	}
	
	public void setPociones(ArrayList<Pocion> pociones) {
		this.pociones = pociones;
	}

	public String toString() {
		return "nombre: " + nombre + " Vida: " + vida + " Mana: " + mana + " Daño: " + daño + 
				" pociones: " + pociones;
	}

	@Override
	public int ataqueBasico() {
		return 0;
	}

	@Override
	public int ataqueEspecial() {
		return 0;
	}
	
}

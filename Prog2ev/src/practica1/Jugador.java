package practica1;

/**
 * <h2>Clase que representa a un objeto Jugador<h2> 
 * El cual contiene los atrbutos de: nombre, dorsal, goles, tarjetas
 * rojas, tarjetas amarillas y expulsiones.
 * @author Adrian Valdivieso Paredes
 * @version 1.0 Fecha: 19/05/2023
 */
public class Jugador implements Comparable<Jugador>{
	private String nombre;
	private int dorsal;
	private int goles;
	private int tarjetaRoja;
	private int tarjetaAmarilla;
	private int expulsiones;
	
	public Jugador(String nombre, int dorsal) {
		this.nombre = nombre;
		this.dorsal = dorsal;
		this.goles = (int) Math.floor(Math.random()*(200-0)+0);
		this.tarjetaRoja = (int) Math.floor(Math.random()*(200-0)+0);
		this.tarjetaAmarilla = (int) Math.floor(Math.random()*(200-0)+0);
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getDorsal() {
		return dorsal;
	}
	
	public int getGoles() {
		return goles;
	}
	
	public int getTarjetaRoja() {
		return tarjetaRoja;
	}
	
	public int getTarjetaAmarilla() {
		return tarjetaAmarilla;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	
	public void setGoles(int goles) {
		this.goles = goles;
	}
	
	public void setTarjetaRoja(int tarjetaRoja) {
		this.tarjetaRoja = tarjetaRoja;
	}
	
	public void setTarjetaAmarilla(int tarjetaAmarilla) {
		this.tarjetaAmarilla = tarjetaAmarilla;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que calcula las expulsiones del jugador segun las
	 * 		 tarjetaas amarillas y rojas que tiene.
	 */
	public int getExpulsiones() {
		this.expulsiones = getTarjetaRoja() + (getTarjetaAmarilla()/2);
		return expulsiones;
		
	}
	/**
	 * Pre: ---
	 * Post: metodo que sobreescribe el metodo override compareTo.
	 */
	@Override
	public int compareTo(Jugador o) {
		return 0;
	}
	
	/**
	 * Pre: ---
	 * Post: metodo que sobreescribe el metodo toString.
	 */
	@Override
	public String toString() {
		return "Nombre jugador: "+ getNombre() + " Dorsal: " + getDorsal() +
				" Goles: " + getGoles() + " Tarjetas rojas: " + getTarjetaRoja() +
				" Tarjetas amarillas: " + getTarjetaAmarilla() + " Expulsiones: " +
				getExpulsiones();
	}
}

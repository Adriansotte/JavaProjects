package practica1;

import java.util.ArrayList;

/**
 * <h2>Clase que representa a un equipo<h2> 
 * Los cuales pertenecen a una Liga que tiene como atributos:
 * nombre, estadio, fundacion, puntos, partidos ganados, partidos
 * perdidos, partidos empatados, goles del equipo y un ArrayList de sus jugadores.
 * @author Adrian Valdivieso Paredes
 * @version 1.0 Fecha: 19/05/2023
 */
public class Equipo implements Comparable<Equipo> {
	private String nombre;
	private String estadio;
	private int fundacion;
	private ArrayList<Jugador> jugadores;
	private int puntos;
	private int parGanados;
	private int parPerdidos;
	private int parEmpatados;
	private int golesEquipo;
	
	public Equipo(String nombre, String estadio) {
		this.nombre = nombre;
		this.estadio = estadio;
		this.fundacion = (int) Math.floor(Math.random()*(2000-1900)+0);;
		this.jugadores = new ArrayList<>();
		this.puntos = (int) Math.floor(Math.random()*(50-0)+0);
		this.parGanados = (int) Math.floor(Math.random()*(50-0)+0);
		this.parPerdidos = (int) Math.floor(Math.random()*(50-0)+0);
		this.parEmpatados = (int) Math.floor(Math.random()*(50-0)+0);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEstadio() {
		return estadio;
	}

	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}

	public int getFundacion() {
		return fundacion;
	}

	public void setFundacion(int fundacion) {
		this.fundacion = fundacion;
	}

	public ArrayList<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getParGanados() {
		return parGanados;
	}

	public void setParGanados(int parGanados) {
		this.parGanados = parGanados;
	}

	public int getParPerdidos() {
		return parPerdidos;
	}

	public void setParPerdidos(int parPerdidos) {
		this.parPerdidos = parPerdidos;
	}

	public int getParEmpatados() {
		return parEmpatados;
	}
	
	public void setParEmpatados(int parEmpatados) {
		this.parEmpatados = parEmpatados;
	}
	
	/**
	 * Pre: ---
	 * Post: metodo que contabiliza los goles del equipo sumando
	 * 		 todos los goles de cada jugador.
	 */
	public int getGoles() {
		this.golesEquipo = 0;
		for(int i = 0; i < jugadores.size(); i++) {
			golesEquipo += jugadores.get(i).getGoles();
		} return golesEquipo;
	}
	
	/**
	 * Pre: ---
	 * Post: sobreescribe el metodo compareTo.
	 */
	@Override
	public int compareTo(Equipo o) {
		return 0;
	}
	
	/**
	 * Pre: ---
	 * Post: sobreescribe el metodo toString.
	 */
	@Override
	public String toString() {
		return "Nombre equipo: "+ getNombre() + " Estadio: " + getEstadio() +
				" Año fundacion: " + getFundacion() + " Puntos: " + getPuntos() +
				" Victorias: " + getParEmpatados() + " Derrotas: " + getParPerdidos() +
				" Empates: " + getParEmpatados();
	}
}
package practica1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <h2>Clase que representa una liga de futbol<h2> 
 * Con sus equipos y jugadores correspondientes. Consta dos atributos: nombre(String)
 * y clasificacion clasificacion(ArrayList)
 * @author Adrian Valdivieso Paredes
 * @version 1.0 Fecha: 19/05/2023
 */
public class Liga {
	private String nombre;
	private ArrayList<Equipo> clasificacion;
	
	public Liga(String nombre) {
		this.nombre = nombre;
		this.clasificacion = new ArrayList<>();
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public ArrayList<Equipo> getClasificacion() {
		return clasificacion;
	}
	
	public void setClasificacion(ArrayList<Equipo> clasificacion) {
		this.clasificacion = clasificacion;
	}
	/**
	 * Pre: ---
	 * Post: ordena la clasificación del objeto Liga mediante la
	 * 		 clase Collections.
	 */
	public void ordenarEquipos() {
		Collections.sort(clasificacion, new CompararEquipos());
		mostrarClasificacion();
	}
	/**
	 * Pre: ---
	 * Post: muestra la clasificación una vez es ordenada por el
	 * 		 método ordenarEquipos().
	 */
	public void mostrarClasificacion() {
		System.out.println("------------------------CLASIFICACION-----------------------------");
		for(int i = 0; i < getClasificacion().size() ; i++) {
			System.out.println("Equipo: " + getClasificacion().get(i).getNombre() + 
					" -> Puntos: " +getClasificacion().get(i).getPuntos() +
					" - Victorias: " + getClasificacion().get(i).getParGanados() +
					" - Derrotas: " + getClasificacion().get(i).getParPerdidos() +
					" - Empates: " + getClasificacion().get(i).getParEmpatados() +
					" - Goles: " + getClasificacion().get(i).getGoles());
		} System.out.println("-------------------------------------------------------------------");
	}
	
	/**Pre: ---
	 * Post: ordena los equipos según el atributo de golesEquipo
	 * 		 de cada objeto equipo mediante la clase Collections
	 * 		 y llama a la clase mostrarEquiposGol().
	 */
	public void equiposGoleadores() {
		Collections.sort(clasificacion, new MaxGolEquipo());
		mostrarEquiposGol();
	}
	
	/**Pre: ---
	 * Post: muestra los 3 equipos mas goleadores una vez han sido
	 * 		 ordenados en el metodo equiposGoleadores().
	 */
	public void mostrarEquiposGol() {
		System.out.println("-----------------EQUIPOS GOLEADORES------------------------");
		for(int i = 0; i < 3; i++) {
			System.out.println("Equipo: " + getClasificacion().get(i).getNombre() + 
					" -> Goles: " + getClasificacion().get(i).getGoles());
		} System.out.println("-----------------------------------------------------------");
	}
	
	/**
	 * Pre: ---
	 * Post: este metodo crea un nuevo ArrayList donde se introducen
	 * 		 todos los objetos Jugador de cada equipo, ademas recibe
	 * 		 como parámetro un boolean, el cual si es True ordena dicho
	 * 		 ArrayList según los goles de cada jugador y se es False ordena
	 * 		 el ArrayList según las expulsiones de cada jugador, ambos
	 * 		 llaman posteriormente al metodo mostrarJugadores().
	 * @param seleccion
	 */
	public void maxJugadores(boolean seleccion) {
		ArrayList<Jugador> max = new ArrayList<>();
		for(int i = 0; i < getClasificacion().size(); i++) {
			max.addAll(getClasificacion().get(i).getJugadores());
		}
		if(seleccion) {			
			Collections.sort(max, new JugadorMax());
			mostrarJugadores(max, true);
		} else {
			Collections.sort(max, new MaxExpulsiones());
			mostrarJugadores(max, false);
		}
	}
	
	/**
	 * Pre: ---
	 * Post: metodo que recibe como parámetro un boolean y un ArrrayList, el
	 * 		 cual si es true muestra por pantalla los 5 goleadores, o sino muestra
	 * 		 por pantalla a los 5 con mas expulsiones.
	 * @param max
	 * @param seleccion
	 */
	public void mostrarJugadores(ArrayList<Jugador> max, boolean seleccion) {
		System.out.println("--------------------TOP JUGADORES-------------------------");
		if(seleccion) {	
			for(int i = 0; i < 5; i++) {
				System.out.println("Nombre: " + max.get(i).getNombre() + " - Goles: " +
						max.get(i).getGoles());
			}
		} else {
			for(int i = 0; i < 5; i++) {
				System.out.println("Nombre: " + max.get(i).getNombre() + " - Expulsiones: " +
						max.get(i).getExpulsiones());
			}
		} System.out.println("----------------------------------------------------------");
	}
	
	/**
	 * Pre: ---
	 * Post: sobreescribe el metodo toString.
	 */
	@Override
	public String toString() {
		return "Nombre Liga: "+ getNombre();
	}
}
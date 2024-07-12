package examen2EVA;

public class Plataforma {

	private String nombre;
	private int apariciones;
	
	public Plataforma(String nombre) {
		this.nombre = nombre;
		this.apariciones = 0;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public int getApariciones() {
		return apariciones;
	}
	
	public void setApariciones(int apariciones) {
		this.apariciones = apariciones;
	}
	
	public void aumentarApariciones() {
		this.apariciones += 1;
	}
	
	public String toString() {
		return "Consola: " + nombre + " Apariciones:" + apariciones;
	}
}

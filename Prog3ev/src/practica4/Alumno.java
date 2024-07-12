package practica4;

import java.util.ArrayList;

/**
 * Clase que representa a un alumno el cual contiene atributos identificativos
 * mas un atributo ArrayList donde contiene todas las asignaturas donde esta 
 * matriculado.
 */
public class Alumno {

	private int nip;
	private String nombre;
	private String apellido;
	private ArrayList<Asignatura> asignaturas;

	public Alumno(int nip, String nombre, String apellido) {
		this.nip = nip;
		this.nombre = nombre;
		this.apellido = apellido;
		this.asignaturas = new ArrayList<>();
	}

	public int getNip() {
		return nip;
	}

	public void setNip(int nip) {
		this.nip = nip;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public ArrayList<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que devuelve la informacion necesaria del alumno.
	 */
	@Override
	public String toString() {
		return nip + " " +  nombre + " " + apellido;
	}
}

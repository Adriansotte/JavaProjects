package practica4;

/**
 * Clase que contiene los atributos necesarios para poder relacionar
 * el codigo de un alumno con el codigo de una asignatura, asi sabemos	
 * a que asignatura se ha matriculado cada alumno. 
 */
public class Matricula {

	private int codAlumno;
	private int codAsig;
	
	public Matricula(int codAlumno, int codAsig) {
		this.codAlumno = codAlumno;
		this.codAsig = codAsig;
	}

	public int getCodAlumno() {
		return codAlumno;
	}

	public void setCodAlumno(int codAlumno) {
		this.codAlumno = codAlumno;
	}

	public int getCodAsig() {
		return codAsig;
	}

	public void setCodAsig(int codAsig) {
		this.codAsig = codAsig;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que devuelve como parametro la informacion necesaria de la
	 * 		 matricula.
	 */
	@Override
	public String toString() {
		return "Alumno: " + codAlumno + " Asignatura: " + codAsig;
	}
}

package herencias;

public class Estudiante extends Persona{

	private int nota;
	private int codigo;
	
	public Estudiante(String nombre, int edad, int nota, int codigo) {
		super(nombre, edad);
		this.nota = nota;
		this.codigo = codigo;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public void mostrarDatos() {
		System.out.println("nombre: " + this.nombre + 
				" edad: " + this.edad +
				" nota: " + this.nota +
				" codigo: " + this.codigo);
	}
	
}

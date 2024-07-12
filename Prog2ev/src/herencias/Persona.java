package herencias;

public class Persona {

	protected String nombre;
	protected int edad;
	protected int altura;
	protected int peso;
	
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
		this.altura = 170;
		this.peso = 70;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	
}

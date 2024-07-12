package Tarea1;

public class Persona {
	private String nombre;
	private int edad;
	private String[] dni;
	private String sexo;
	private double peso;
	private double altura;
	
	public Persona() {}
		
	public Persona(String nombre, int edad, String sexo) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		this.peso = 0;
		this.altura = 0;
	}
	
	public Persona(String nombre, int edad, String sexo, double peso,
			double altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.dni = generaDNI();
		this.sexo = sexo;
		this.peso = peso;
		this.altura = altura;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getEdad() {
		return edad;
	}
	
	public String getSexo() {
		return sexo;
	}
	
	public double getPeso() {
		return peso;
	}
	
	public double getAltura() {
		return altura;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void setEdad(int edad) {
		this.edad = edad;
	}
	
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setPeso(double peso) {
		this.peso = peso;
	} 
	
	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	public int calcularIMC(double peso, double altura) {
		double op = (peso/altura * altura);
		if(op < 20) {
			return -1;
		} else if(op > 25) {
			return 1;
		} return 0;
	}
	
	public boolean esMayorDeEdad(int edad) {
		if(edad >= 18) {
			System.out.println("Mayor de edad.");
			return true;
		} 
		System.out.println("Menor de edad.");
		return false;
	}
	
	private String comprobarSexo(String sexo) {
		if(sexo.toUpperCase().equals("H") || sexo.toUpperCase().equals("F")) {
			System.out.println(sexo);
			return sexo;
		} 
		sexo = "H";
		System.out.println(sexo);
		return sexo;
	}
	
	public String[] generaDNI() {
		String[] DNI = new String[9];
		for(int i = 0; i < 8; i++) {
			int numero = (int) Math.floor(Math.random()*(9-0)+0);
			DNI[i] = Integer.toString(numero);
		} return DNI;
	}
}

package arrayList2;

public class Persona {

	private String nombre;
	private String apellido;
	private int edad;
	private String DNI;
	
	public Persona() {
		this.nombre = darNombre();
		this.apellido = darApellido();
		this.edad = (int)Math.floor(Math.random()*50-0)+0;
		this.DNI = calcularDNI();
	}
	
	public Persona(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}
	
	public Persona(String nombre, String apellido) {
		this.nombre = nombre;
		this.apellido = apellido;
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
	
	public String getDNI() {
		return DNI;
	}

	public void setDNI(String DNI) {
		this.DNI = DNI;
	}
	
	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public String darNombre() {
		String[] nombre = new String[] { "Hugo", "Mateo", "Martin", "Lucas", "Leo",
				"Daniel", "Alejandro", "Adrian", "Manuel", "Andres", "Jesus", "Marcelo",
				"Ivan", "Fran", "Alex", "David", "Matias", "Dwayne", "Carlos", "Antonio",
				"Maverick", "Elvis", "Diego", "Alan", "Marcos", "Juan", "Pablo", "Guillermo",
				"Rigo", "Joseph", "Fernando", "Raul", "Cuasi", "Kratos", "Atreus", "Mimir",
				"Odin", "Thor", "Loki", "Logan", "Miles"};
		return nombre[(int)Math.floor(Math.random()*(nombre.length-0)+0)];
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	public String darApellido() {
		String[] apellido = new String[] { "Fernandez", "Perez", "Alvarez", "Todea", "Chiquero",
				"Messi", "Dominguez", "Lozano", "Vergara", "Diaz", "Prieto", "Ronaldo",
				"Abril", "Mayo", "Junio", "Julio", "Agosto", "Luna", "Pereira", "Gutierrez",
				"Sanz", "Guzman", "Solis", "Harper", "Aurelio", "Chiapella", "Gomez", "Olave",
				"Carrasco", "Estrella", "Fuentes"};
		return apellido[(int)Math.floor(Math.random()*(apellido.length-0)+0)];
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public int calcularPago() {
		int pago = 0;
		if(this.edad > 0) {
			if(this.edad > 0 && this.edad <= 10) {
				pago = 1;
			} else if(this.edad > 10 && this.edad <= 17) {
				pago = 25;
			} else if(this.edad >= 18) {
				pago = 35;
			}
		} return pago;
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public String calcularDNI() {
		int numero = (int)Math.floor(Math.random()*(99999999-10000000)+0);
		String letra = devolverLetra(numero);
		String DNI = Integer.toString(numero) + letra;
		return DNI;
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public String devolverLetra(int numero) {
		String[] letras = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K",
				"L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
		return letras[numero % 22];
	}
	
	/**
	 * Pre: ---
	 * Post:
	 */
	@Override
	public String toString() {
		return "Nombre: " + nombre + " || Apellido: " + apellido + " || DNI: " + DNI;
	}
}

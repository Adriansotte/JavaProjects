package prueba;

public class Pasajero {
private String nombre;
private int edad;

public Pasajero(String nombre) {
	this.nombre = nombre;
	this.edad = (int) Math.floor(Math.random()*(20-0)+0);
	
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

}

package starWars;

import java.util.Random;

public class Droide {

	private String nombre;
	private int energia;
	
	public Droide(String nombre) {
		Random random = new Random();
		this.nombre = nombre;
		if(nombre.equalsIgnoreCase("SW348")) {
			this.energia = random.nextInt(51);			
		} else if(nombre.equalsIgnoreCase("SW447")) {
			this.energia = random.nextInt(101);
		} else if(nombre.equalsIgnoreCase("SW4421")) {
			this.energia = random.nextInt(51) + 100;
		} else {
			this.energia = -1;
		}
		/**
		 * En este ejemplo, hemos utilizado random.nextInt(51) para generar un número 
		 * aleatorio en el rango de 0 a 50. Luego, sumamos 100 al resultado para obtener 
		 * el número final en el rango deseado de 100 a 150. Recuerda que el límite superior
		 * en el método nextInt() es exclusivo, por lo que utilizamos 51 en lugar de 151.
		 */
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEnergia() {
		return energia;
	}

	public void setEnergia(int energia) {
		this.energia = energia;
	}
	
	@Override
	public String toString() {
		return "Droide: " + this.nombre + " Energia: " + this.energia;
	}
}

package repasoFinal1evaluacion;

public class Ejercicio14 {
	public static void main(String[] args) {
		String[] tabla = {"Holaa", "Adioss", "Hasta luego", 
				"Esto es una prueba", "Mas pruebass", "Holaa", "Adioss", "Hasta luego"};
		for(int i = 0; i < tabla.length; i++) {
			for(int j = i + 1; j < tabla.length; j++) {
				if(tabla[i].equals(tabla[j])) {
					System.out.println("El elemento \"" + tabla[i] + "\" está duplicado");
					break;
				}
			}
		}
	}
}

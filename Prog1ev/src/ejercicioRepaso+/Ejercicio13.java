package repasoFinal1evaluacion;

public class Ejercicio13 {
	public static void main(String[] args) {
		String[] tabla = {"Holaa", "Adioss", "Hasta luego", 
				"Esto es una prueba", "Mas pruebass"};
		String[] tabla2= {"Hola", "Adios", "Hasta luego", 
				"Esto es una prueba", "Mas pruebas"};
		for(int i = 0; i < tabla.length; i++) {
			for(int j = 0; j < tabla2.length; j++) {
				if(tabla[i].equals(tabla2[j])) {
					System.out.println("El elemento \"" + tabla[i] + "\" es común");
					break;
				}
			}
		}
	}
}

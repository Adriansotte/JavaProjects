package repasoFinal1evaluacion;

public class Ejercicio15 {
	public static void main(String[] args) {
		int[] tabla = {1, 2, 3, 4, 5, 10, 12, 14, 15, 19, 4, 5, 10, 12};
		for(int i = 0; i < tabla.length; i++) {
			for(int j = i + 1; j < tabla.length; j++) {
				if(tabla[i] == tabla[j]) {
					System.out.println("El elemento \"" + tabla[i] + "\" está duplicado");
					break;
				}
			}
		}
	}
}

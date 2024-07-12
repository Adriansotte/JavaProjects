package repasoFinal1evaluacion;

public class Ejercicio12 {
	public static void main(String[] args) {
		int[] tabla = {1, 2, 3, 4, 5, 10, 12, 14, 15, 19};
		int[] tabla2= {1, 2, 3, 4, 5, 11, 13, 14, 16, 20};
		for(int i = 0; i < tabla.length; i++) {
			for(int j = 0; j < tabla2.length; j++) {
				if(tabla[i] == tabla2[j]) {
					System.out.println("El elemento " + tabla[i] + " es común");
					break;
				}
			}
		}
	}
}

package repasoFinal1evaluacion;

public class Ejercicio17 {
	public static void main(String[] args) {
		int[] tabla = {1, 40, 3, 4, 5, 10, 12, 14, 15, 19, 4, 5, 10, 200};
		if(tabla.length > 1) {
			int mayorDistancia = Math.abs(Math.abs(tabla[0]) - Math.abs(tabla[1]));
			int menorDistancia = Math.abs(Math.abs(tabla[0]) - Math.abs(tabla[1]));
			int indexMayor = 0;
			int indexMenor = 0;
			for(int i = 1; i < tabla.length - 1; i++) {
				if(Math.abs(Math.abs(tabla[i]) - Math.abs(tabla[i + 1])) > mayorDistancia) {
					indexMayor = i;
					mayorDistancia = Math.abs(Math.abs(tabla[i]) - Math.abs(tabla[i + 1]));
				} else if(Math.abs(Math.abs(tabla[i]) - Math.abs(tabla[i + 1])) < menorDistancia) {
					indexMenor = i;
					menorDistancia = Math.abs(Math.abs(tabla[i]) - Math.abs(tabla[i + 1]));
				}
			}
			System.out.println("Mayor distancia entre el par {" + tabla[indexMayor] + 
					", " + tabla[indexMayor + 1] + "]");
			System.out.println("Menor distancia entre el par {" + tabla[indexMenor] + 
					", " + tabla[indexMenor + 1] + "]");
		} else {
			System.out.println("No hay números suficientes para ejecutar el algoritmo");
		}
	}
}

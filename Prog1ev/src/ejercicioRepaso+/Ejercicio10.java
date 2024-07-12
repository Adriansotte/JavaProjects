package repasoFinal1evaluacion;

public class Ejercicio10 {
	public static void main(String[] args) {
		int numeroPermutaciones = 0;
		for(int i = 1; i <= 4; i++) {
			for(int j = 1; j <= 4; j++) {
				for(int k = 1; k <= 4; k++) {
					System.out.println(i + "" + j + "" + k);
					numeroPermutaciones++;
				}
			}
		}
		System.out.println("Número total de permutaciones de 3 dígitos = " + numeroPermutaciones);
	}
}

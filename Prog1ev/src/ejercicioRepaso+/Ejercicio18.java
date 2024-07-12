package repasoFinal1evaluacion;

public class Ejercicio18 {
	public static void main(String[] args) {
		int[] tabla = {1, 2, 3, 4, 5, 10, 12, 14, 15, 19};
		int[] tablaPartida1 = new int[5];
		int[] tablaPartida2 = new int[5];
		for(int i = 0; i < tabla.length; i++) {
			if(i <= 4) {
				tablaPartida1[i] = tabla[i];
			} else {
				tablaPartida2[i - 5] = tabla[i];
			}
		}
		System.out.print("La primera tabla contiene los elementos: {");
		for(int i = 0; i < tablaPartida1.length; i++) {
			if(i < tablaPartida1.length - 1) {
				System.out.print(tablaPartida1[i] + ", ");
			} else {
				System.out.println(tablaPartida1[i] + "}");
			}
		}
		System.out.print("La segunda tabla contiene los elementos: {");
		for(int i = 0; i < tablaPartida2.length; i++) {
			if(i < tablaPartida2.length - 1) {
				System.out.print(tablaPartida2[i] + ", ");
			} else {
				System.out.print(tablaPartida2[i] + "}");
			}
		}
	}
}

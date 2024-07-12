package repasoFinal1evaluacion;

public class Ejercicio19 {
	public static void main(String[] args) {
		String[] tabla = {"Holaa", "Adioss", "Hasta luego", 
				"Jajajajaj", "Hasta luego", "Adioss", "Holaa"};
		boolean esInversa = true;
		for(int i = 0; i < tabla.length; i++) {
			int j = tabla.length - 1 - i;
			if(j > i) {
				if(!tabla[i].equals(tabla[j])) {
					esInversa = false;
					break;
				}
			} else {
				break;
			}
		}
		System.out.println("¿Es inversa la tabla? -> " + esInversa);
	}
}

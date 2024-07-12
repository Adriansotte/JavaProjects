package ejerciciosRepaso;

import java.util.Arrays;
import java.util.Scanner;

public class Reto {
	private static boolean pijote(String n) {
		if (contieneTodas(n)) {
			String[] t = n.split("");
			Arrays.sort(t);
			int contador = 1;
			for (int j = 0; j < t.length; j++) {
				if (t[j].equals(t[j + 1]))
					contador++;
				else
					break;
			}
			// System.out.println("Contador = " + contador);
			int i = contador;
			while (true) {
				System.out.println(i);
				if (contador + i == t.length)
					return true;
				else if (contador + i > t.length)
					return false;
				if (!t[i].equals(t[i + contador - 1]) || t[i + contador].equals(t[i]))
					return false;
				i += contador;
			}
		}
		return false;
	}

	private static boolean contieneTodas(String n) {
		String[] numeros = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		for (String numero : numeros) {
			if (!n.contains(numero))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		long inicio = System.currentTimeMillis();
		String n = "00112233445566778899";
		System.out.println(pijote(n));
		long fin = System.currentTimeMillis();
		double tiempo = (double) ((fin - inicio));
		System.out.println(tiempo);
	}
}
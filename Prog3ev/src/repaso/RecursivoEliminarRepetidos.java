package repaso;

public class RecursivoEliminarRepetidos {

	public static void main(String[] args) {
		String n = "aabbbcdddd";
		String[] letra = n.split("");
		borrarRepetidos(letra);
	}

	public static void borrarRepetidos(String[] n) {
		borrarRepetidos(n, 0);
	}

	private static void borrarRepetidos(String[] n, int i) {
		if (i == n.length - 1) {
			mostrar(n);
		} else if(n[i].equalsIgnoreCase(n[i + 1] )) {
			n[i] = "";
			borrarRepetidos(n, i + 1);
		} else {
			borrarRepetidos(n, i + 1);
		}
	}

	public static void mostrar(String[] n) {
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i]);
		}
	}
}

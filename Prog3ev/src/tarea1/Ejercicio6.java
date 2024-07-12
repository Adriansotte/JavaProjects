package tarea1;

public class Ejercicio6 {

	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		System.out.println(getN(2));
	}
	
	public static int getN(int m) {
		return getN(m, 0, 1);
	}
	
	private static int getN(int m, int suma, int n) {
		if(suma > m) return n - 1;
		else return getN(m, suma + n, n + 1);
	}
}

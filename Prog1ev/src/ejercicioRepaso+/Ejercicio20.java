package repasoFinal1evaluacion;

public class Ejercicio20 {
	public static int max(int[][] a) {
		int max = a[0][0];
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				if(a[i][j] > max) {
					max = a[i][j];
				}
			}
		} return max;
	}
	
	public static int rowSum(int[][] a, int x) {
		int suma = 0;
		for(int j = 0; j < a[x].length; j++) {
			suma = suma + a[x][j];
		} return suma;
	}
	
	public static int columnSum(int[][] a, int x) {
		int suma = 0;
		for(int i = 0; i < a.length; i++) {
			suma += a[i][x];
		} return suma;
	}
	
	public static int[] allRowSums(int[][] a) {
		int[] sumaFilas = new int[a.length];
		for(int i = 0; i < a.length; i++) {
			int suma = 0;
			for(int j = 0; j < a[i].length; j++) {
				suma += a[i][j];
			}
			sumaFilas[i] = suma;
		} return sumaFilas;
	}
	
	public static boolean isRowMagic(int[][] a) {
		int[] sumaFilas = allRowSums(a);
		int suma = sumaFilas[0];
		for(int i = 1; i < sumaFilas.length; i++) {
			if(suma != sumaFilas[i]) {
				return false;
			}
		} return true;
	}
	
	public static int[] allColumnsSums(int[][] a) {
		int[] sumaColumnas = new int[a[0].length];
		for(int j = 0; j < a[0].length; j++) {
			int suma = 0;
			for(int i = 0; i < a.length; i++) {
				suma += a[i][j];
			}
			sumaColumnas[j] = suma;
		} return sumaColumnas;
	}
	
	public static boolean isColumnMagic(int[][] a) {
		int[] sumaFilas = allColumnsSums(a);
		int suma = sumaFilas[0];
		for(int i = 1; i < sumaFilas.length; i++) {
			if(suma != sumaFilas[i]) {
				return false;
			}
		} return true;
	}
	
	public static void main(String[] args) {
		int[][] tabla = {{4, 4, 4, 4}, {4, 4, 4, 4}, 
				{4, 4, 4, 4}, {4, 4, 4, 4}};
		System.out.println("Valor máximo de la tabla = " + max(tabla));
		System.out.println("Suma de la fila 1 = " + rowSum(tabla, 1));
		System.out.println("Suma de la columna 2 = " + columnSum(tabla, 2));
		System.out.println("Suma de todas las filas:" );
		int[] sumaFilas = allRowSums(tabla);
		for(int i = 0; i < sumaFilas.length; i++) {
			System.out.println("\tsumaFilas[" + i + "] = " + sumaFilas[i]);
		}
		System.out.println("¿Filas mágicas? = " + isRowMagic(tabla));
		System.out.println("¿Columnas mágicas? = " + isColumnMagic(tabla));
	}
}

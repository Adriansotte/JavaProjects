package practica5;

public class Prueba {

	public static void main(String[] args) {
		int[][] nueva = new int[][] {{1,2},{1,2,3,4}};
		System.out.println(nueva.length);
		System.out.println(nueva[1].length);
		System.out.println(nueva[0].length);
		System.out.println("------------");
		
		int[][] tabla = new int[][] {{3,2,9}, {4,3,2}, {10,2,9}};
		mandarFila(tabla[1]);
		int[] columna = new int[tabla.length] ;
		for(int i = 0; i < tabla[1].length; i++) {
			columna[i] = tabla[2][i];
			System.out.print(columna[i]);
		}System.out.println("");
		mandarColumna(columna);
	}
	public static void mandarFila(int[] fila) {
		ordenar(fila);
		for(int i = 0; i < fila.length; i++) {
			System.out.println(fila[i]);
		}
	}
	
	public static void mandarColumna(int[] fila) {
		ordenar(fila);
		for(int i = 0; i < fila.length; i++) {
			System.out.println(fila[i]);
		}
	}
	
	public static void ordenar(int[] n) {
		 for(int i = 0; i < n.length; i++) {
	         for (int j = i + 1; j < n.length; j++) {
	            if(n[i] > n[j]) {
	               int temp = n[i];
	               n[i] = n[j];
	               n[j] = temp;
	            }
	         }
	      }
	}
}

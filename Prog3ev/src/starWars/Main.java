package starWars;

import java.util.Random;
import java.util.Scanner;

public class Main {

	private static Droide[][] tablero;
	private static Scanner n;
	private static Random r;
	
	public static void main(String[] args) {
		n = new Scanner(System.in);
		r = new Random();
		System.out.println("dime las columnas (6 - 8)");
		int filas = n.nextInt();
		System.out.println("dime los drones ( 6 - 29)");
		int droides = n.nextInt();
		tablero = crearTablero(filas, droides);
		simulador();
	}
	
	public static void simulador() {
		int destruidos = 0;
		int aciertos = 0;
		int disparos = 0;
		int fallos = 0;
		int criticos = 0;
		while(comprobarDrones()) {
			Droide n = tablero[r.nextInt(tablero.length)][r.nextInt(tablero[0].length)];
			if(n != null && n.getEnergia() > 0) {
				int acierto = r.nextInt(99);
				if(acierto < 15) {
					n.setEnergia(n.getEnergia() - 15);
					criticos++;
				} else {
					n.setEnergia(n.getEnergia() - 1);
				}
				if(n.getEnergia() <= 0) {
					System.out.println("El droide: " + n.getNombre() + " ha sido destruido.");
					destruidos++;
				}
				aciertos++;
			} else {
				fallos++;
			}
			disparos++;
		}
		System.out.println("Aciertos: " + aciertos);
		System.out.println("Fallos: " + fallos);
		System.out.println("Disparos: " + disparos);
		System.out.println("Criticos: " + criticos);
		System.out.println("Destruidos: " + destruidos);
	}
	
	public static boolean comprobarDrones() {
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				Droide n = tablero[i][j];
				if(n != null && n.getEnergia() > 0) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static void mostrarTablero() {
		for(int i = 0; i < tablero.length; i++) {
			for(int j = 0; j < tablero[i].length; j++) {
				System.out.println(tablero[i][j]);
			}
		}
	}
	
	public static Droide[][] crearTablero(int filas, int droides) {
		Droide[][] tablero = new Droide[r.nextInt(4) + 6][filas];
		int numero = 0;
		while(droides != numero) {
			int probabilidad = r.nextInt(100);
			Droide droide = null;
			if(probabilidad < 30) {
				droide = new Droide("SW348");
			} else if(probabilidad >= 30 && probabilidad < 50) {
				droide = new Droide("SW4421");
			} else if(probabilidad >= 50 && probabilidad < 100){
				droide = new Droide("SW447");
			} else {
				droide = new Droide("error");	
			}
			int aleatorioFilas = r.nextInt(tablero.length);
			int aleatorioColumnas = r.nextInt(tablero[0].length);
			Droide comp = tablero[aleatorioFilas][aleatorioColumnas];
			if(comp == null) {
				tablero[aleatorioFilas][aleatorioColumnas] = droide;
				numero++;
			}
			/**
			 *  int numRows = matrix.length; // Tamaño de las filas
        		int numCols = matrix[0].length; // Tamaño de las columnas
        		System.out.println("Número de filas: " + numRows);
        		System.out.println("Número de columnas: " + numCols);
			 */
		}
		return tablero;
	}
}

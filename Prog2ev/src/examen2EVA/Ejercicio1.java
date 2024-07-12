package examen2EVA;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {
	/**
	 * Pre:---
	 * Post:
	 */
	public static void main(String[] args) {
		Scanner n = new Scanner(System.in);
		System.out.println("----Bienvenido a Final Fantasy----");
		ArrayList<Jugador> lista = personajes();
		while(true) {
			int personaje = preguntarNumero("Que personaje deseas usar (1-4)", n, 5);
			System.out.println(personaje);
			mostrarOpciones();
			int eleccion = preguntarNumero("¿Que deseas hacer? (1-3)", n, 3);
			System.out.println(eleccion);
			if(eleccion == 1) {
				ataqueBasico(lista.get(personaje), lista.get(0));
			} else if(eleccion == 2) {
				ataqueEspecial(lista.get(personaje), lista.get(0));
			} else {
				
			}
			int turnoEnemigo = (int) Math.floor(Math.random()*(2-1)+0);
			int elegirAtacante = (int) Math.floor(Math.random()*(10-0)+0);
			if(turnoEnemigo < 1) {
				ataqueBasico(lista.get(0), lista.get(elegirAtacante));
			} else {
				ataqueEspecial(lista.get(0), lista.get(elegirAtacante));
			}
			System.out.println("Fin del turno.");
			boolean comprobar = comprobarTurno(lista);
			if(!comprobar) {
				System.out.println("---------FIN DEL JUEGO----------");
				break;
			}
			System.out.println("----------------------------------");
			mostrarPersonajes(lista);
		}
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static boolean comprobarTurno(ArrayList<Jugador> lista) {
		if(lista.get(0).getVida() < 0) {
			return false;
		} else {
			for(int i = 1; i < lista.size(); i++) {
				if(lista.get(i).getVida() > 0) {
					return true;
				}
			} return false;
		}
	}

	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void mostrarOpciones() {
		System.out.println("1. Ataque basico");
		System.out.println("2. Ataque especial");
		System.out.println("3. Ver Pociones");
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void ataqueBasico(Jugador atacante, Jugador defensor) {
		if(defensor.getVida() > 0 && atacante.getVida() > 0 && atacante.getMana() > 0) {
			int calcularDaño = atacante.ataqueBasico();
			defensor.setVida(calcularDaño);
			System.out.println("El personaje: " + atacante.getNombre() + " ha inflingido: " + calcularDaño +
					" a: " + defensor.getNombre());
			System.out.println("Vida restante de: " + defensor.getNombre() + "= " + defensor.getVida());
		} else {
			System.out.println("El atacante escogido esta muerto ya!!!");
		}
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void ataqueEspecial(Jugador atacante, Jugador defensor) {
		if(defensor.getVida() > 0 && atacante.getVida() > 0 && atacante.getMana() > 0) {
			int calcularDaño = atacante.ataqueEspecial();
			if(atacante.getMana() > calcularDaño) {
				defensor.setVida(calcularDaño);
				System.out.println("El personaje: " + atacante.getNombre() + " ha inflingido: " + calcularDaño +
						" a: " + defensor.getNombre());
				System.out.println("Vida restante de: " + defensor.getNombre() + "= " + defensor.getVida());				
			}
		} else {
			System.out.println("El atacante escogido esta muerto ya!!!");
		}
		
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static int preguntarNumero(String preg, Scanner n, int i) {
		int numero = 0;
		while(true) {
			try {
				System.out.print(preg);
				numero = n.nextInt();
				if(numero > 0 && numero < i) {
					n.nextLine();
					return numero;
				}
				else System.out.println("Numero no valido");
			} catch(InputMismatchException e) {
				System.out.println("No reconocido");
				n.nextLine();
			}
		} 
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static ArrayList<Jugador> personajes() {
		ArrayList<Jugador> lista = new ArrayList<>();
		Guerrero guerrero = new Guerrero("Guerrero", 100, 10);
		Mago mago = new Mago("Mago", 200, 10);
		Picaro picaro = new Picaro("Picaro", 200, 10);
		Arquero arquero = new Arquero("Arquero", 200, 10);
		Enemigo enemigo = new Enemigo("Enemigo", 500, 20);
		lista.add(enemigo);
		lista.add(guerrero);
		lista.add(picaro);
		lista.add(arquero);
		lista.add(mago);
		mostrarPersonajes(lista);
		return lista;
	}
	
	/**
	 * Pre:---
	 * Post:
	 */
	public static void mostrarPersonajes(ArrayList<Jugador> lista) {
		for(int i = 1; i < lista.size(); i++) {
			System.out.println(i + "-> " + lista.get(i).toString());
		}
	}
}

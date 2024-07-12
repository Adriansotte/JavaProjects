package practica6JuegoDeRol;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * Programa que simula un juego basado en situaciones y elecciones basado 
 * en la lucha libre WWE. Este pprograma tambien se une con su propia base
 * de datos en la cual mediante consultas realizamos la historia de este
 * juego. Al principio el jugador tiene un menu para su eleccion, podra
 * seleccionar o crear un personaje y con dicho personaje jugar contra 
 * otro anteriormente creado, al final del juego se calcula su puntuacion
 * y si el usuario quiere puede guardar su progreso o su personaje. 
 */
public class Main {
	
	//Declaramos las variables que vamos a utilizar en todo el codigo.
	private static Scanner n;
	private static DataBase wwe;
	private static Jugador jugador;
	private static Jugador enemigo;
	private static Situacion situacion;
	
	/**
	 * Pre:---
	 * Post: metodo principal donde se muestra el menu al usuario y se le solicita
	 * 		 un string para elegir un modo, cada if nos lleva a un metodo distinto.
	 * 		 Se inicializan las variables globales que se van a utilizar en el programa.
	 */
	public static void main(String[] args) throws Exception {
		n = new Scanner(System.in);
		try {
			wwe = new DataBase();
			System.out.println("------------WWE 2K24------------");
			while(true) {
				menuPrincipal();
				String eleccionMenu = pedirOrden("Elige una opcion: ");
				if(eleccionMenu.equalsIgnoreCase("JUGAR")) {
					wwe.start();
					menuJugar();
					int jugadoresDisponibles = wwe.getSizePlayers();
					jugador = recogerJugador();
					enemigo = wwe.getPlayer((int)(Math.random() * jugadoresDisponibles + 1));
					mostrarLuchadores();
					int puntuacion = historia();
					guardarPersonaje();
					guardarRanking(puntuacion);
					wwe.close();
				} else if(eleccionMenu.equalsIgnoreCase("VER")) {
					wwe.start();
					wwe.getRanking();
					wwe.close();
				} else if(eleccionMenu.equalsIgnoreCase("NUEVO")) {
					wwe.start();
					agregarIdeas();
					wwe.close();
				} else if(eleccionMenu.equalsIgnoreCase("SALIR")) {
					break;
				} else {
					System.out.println("Opcion no valida, vuelve a intenrarlo");
				}
			}
		} catch(Exception e) {
			System.out.println("Error en la base de datos.");
		} finally {
			wwe.close();
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual sirve para dar opciones al usuario con las que 
	 * 		 puede agregar objetos a la base de datos segun el tipo que elige.
	 */
	public static void agregarIdeas() throws SQLException {
		while(true) {
			menuIdeas();
			String idea = pedirOrden("¿Que deseas crear? ");
			if(idea.equalsIgnoreCase("ARMA")) {
				String arma = pedirOrden("Dime el nombre del arma: ");
				int daño = solicitarNumero("Dime el daño del arma: ");
				wwe.addWeapon(arma, daño);
				break;
			} else if(idea.equalsIgnoreCase("TIPO")) {
				String tipo = pedirOrden("Dime el nombre del tipo: ");
				int vida = solicitarNumero("Dime la cantidad de vida: ");
				wwe.addType(tipo, vida);
				break;
			} else if(idea.equalsIgnoreCase("SITUACION")) {
				String situacion = pedirOrden("Dime en que situacion nos posicionamos: ");
				String eleccion1 = pedirOrden("Dime cual seria la primera eleccion: ");
				String resultado1 = pedirOrden("Dime cual seria el resultdado de dicha eleccion: ");
				int daño1 = solicitarNumero("Dime cual es el daño (Positivo si es daño para el enemigo, negativo"
						+ " si es daño para el jugador!) ");
				String eleccion2 = pedirOrden("Dime cual seria la segunda eleccion: ");
				String resultado2 = pedirOrden("Dime cual seria el resultdado de dicha eleccion: ");
				int daño2 = solicitarNumero("Dime cual es el daño (Positivo si es daño para el enemigo, negativo"
						+ " si es daño para el jugador!) ");
				wwe.addSituation(situacion, eleccion1, resultado1, daño1, eleccion2, resultado2, daño2);
				break;
			} else if(idea.equalsIgnoreCase("REMATE")) {
				String remate = pedirOrden("Dime el nombre del remate: ");
				int inflinge = solicitarNumero("Dime el daño que hace: ");
				wwe.addFinisher(remate, inflinge);
				break;
			} else {
				System.out.println("Orden no reconocida, introducela de nuevo por favor.");
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo principal donde muestra las opciones que tiene el usuario para agregar ideas.
	 */
	public static void menuIdeas() {
		System.out.println("--> Nueva arma. [Arma]");
		System.out.println("--> Nuevo tipo de luchador. [Tipo]");
		System.out.println("--> Nueva situacion. [Situacion]");
		System.out.println("--> Nuevo Remate. [Remate]");
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual dado el nombre del jugagor y su puntuacion
	 * 		 obtenida durante la historia, agrega informacion a la base de
	 * 		 datos donde el ranking
	 */
	public static void guardarRanking(int puntuacion) throws SQLException, InterruptedException {
		while(true) {
			String ranking = pedirOrden("¿Quieres guardar tu progreso en el ranking? Si/No ");
			if(ranking.equalsIgnoreCase("SI")) {
				wwe.addRanking(jugador.getNombre(), puntuacion);
				System.out.println("Tu progreso ha sido guardado en el ranking.");
				break;
			} else if(ranking.equalsIgnoreCase("NO")) {
				System.out.println("No se ha añadido al ranking.");
				break;
			} else {
				System.out.println("Respuesta no reconocida, intentalo de nuevo.");
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual mediante una pregunta al usuario guarda o noo
	 * 		 el personaje con el cual ah jugado el juego.
	 */
	public static void guardarPersonaje() throws SQLException {
		while(true) {
			String pregunta = pedirOrden("¿Quieres guardar a tu personaje? (Si has escogido un "
					+ "personaje existente no guardes personaje) Si/No ");
			if(pregunta.equalsIgnoreCase("SI")) {
				wwe.addPlayer(jugador.getNombre(), jugador.getTipo(), jugador.getArma(), 
						jugador.getRemate(), (int)(Math.random() * 4 + 0));
				break;
			} else if(pregunta.equalsIgnoreCase("NO")) {
				System.out.println("No se ha guardado el personaje, por lo tanto no se guardara.");
				break;
			} else {
				System.out.println("Orden no reconocida, intentelo de nuevo");
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que muestra la informacion de las dos variables globales a las cuales
	 * 		 se les ha dado un vlor anteriormente.
	 */
	public static void mostrarLuchadores() throws InterruptedException {
		System.out.println("En su camino hacia el ring:\n" + jugador.toString());
		TimeUnit.SECONDS.sleep(3);
		System.out.println("Se va a enfrentar a:\n" + enemigo.toString());
	}
	
	/**
	 * Pre:---
	 * Post: metodo en el cual se desarrolla la historia principal del juego,
	 * 		 se calcula primero el numero de situaciondes disponibles para luego
	 * 		 elegir una de ellas al azar. Se inicializa una variable donde se 
	 * 		 almacenara la puntuacion. En cada iteracion se declara una variable
	 * 		 tipo situacion en la cual esta la informacion necesaria para que segun
	 * 		 la respuesta del usuario se desencadene una respuesta u otra.
	 * 		 Al final del bucle se calcula la puntuacion y se devuelve.
	 */
	public static int historia() throws SQLException, InterruptedException {
		int numeroSitu = wwe.getSizeSituations();
		int puntuacion = 0;
		TimeUnit.SECONDS.sleep(3);
		System.out.println("------------------PREPARATE!!!----------------------");
		while(jugador.getTipo().getVida() > 0 && enemigo.getTipo().getVida() > 0) {
			TimeUnit.SECONDS.sleep(2);
			if(jugador.getContRemate() % 10 == 0 || enemigo.getContRemate() % 10 == 0) {
				if(jugador.getContRemate() % 10 == 0) situacionRemate(jugador, enemigo);
				if(enemigo.getContRemate() % 10 == 0) situacionRemate(enemigo, jugador);
			} else {
				situacion = wwe.getSituation((int)(Math.random() * numeroSitu + 1));
				System.out.println(situacion.toString());
				gestionarSituacion();
			}
			jugador.aumentarRemate();
			enemigo.aumentarRemate();
			comprobarVida();
			TimeUnit.SECONDS.sleep(1);
			jugador.mostrarVida();
			TimeUnit.SECONDS.sleep(1);
			enemigo.mostrarVida();
			puntuacion++;
			System.out.println("-------------------------------------------------");
		}
		puntuacion = calcularPuntuacion(puntuacion);
		System.out.println("Esta es tu puntuacion = " + puntuacion);
		return puntuacion;
	}	
	
	/**
	 * Pre:---
	 * Post: metodo que calcula la puntuacion final del usuario, si el rival ha ganado
	 * 		 se le suma a la puntuacion actual 10 puntos adicionales y la vida dividida 
	 * 		 entre 100. Si el usuario ha perdido se le resta 10 puntos a la puntuacion final.
	 */
	public static int calcularPuntuacion(int puntuacion) {
		if(jugador.getTipo().getVida() > 0) {
			puntuacion += 10 + (jugador.getTipo().getVida()/100);
		} else {
			puntuacion -= 10;
		}
		return puntuacion;
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual comprueba la vida de ambos jugadores, si es negativa
	 * 		 alguna de las dos se llama a un metodo llamado cuenta de tres.
	 */
	public static void comprobarVida() throws InterruptedException {
		if(jugador.getTipo().getVida() <= 0) {
			jugador.getTipo().setVida(0);
			cuentaDeTres(enemigo, jugador);
		} if(enemigo.getTipo().getVida() <= 0) {
			enemigo.getTipo().setVida(0);
			cuentaDeTres(jugador, enemigo);
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual pide al usuario una eleccion segun las opciones que 
	 * 		 le da el objeto situacion, muestra cada una de las opciones disponibles
	 * 		 y resta vida a uno de los dos objetos Jugador afectados. Si la respuesta
	 * 		 del usuario no coincide con ninguna opcion, se vuelve a preguntar al usuario.
	 */
	public static void gestionarSituacion() throws InterruptedException {
		while(true) {
			TimeUnit.SECONDS.sleep(1);
			String eleccion = pedirOrden("¿Que eliges? ");
			TimeUnit.SECONDS.sleep(1);
			if(eleccion.equalsIgnoreCase(situacion.getEleccion1())) {
				System.out.println(situacion.getResultado1());
				TimeUnit.SECONDS.sleep(1);
				if(situacion.getDaño1() > 0) {
					System.out.println(enemigo.getNombre() + " pierde " + 
							situacion.getDaño1() + " puntos de vida.");
					enemigo.getTipo().reducirVida(-situacion.getDaño1());
					break;
				} else if(situacion.getDaño1() < 0) {
					System.out.println(jugador.getNombre() + " pierde " + 
							(situacion.getDaño1()*(-1)) + " puntos de vida.");
					jugador.getTipo().reducirVida(situacion.getDaño1());
					break;
				} else {
					System.out.println("Nadie pierde vida.");
					break;
				} 
			} else if(eleccion.equalsIgnoreCase(situacion.getEleccion2())) {
				System.out.println(situacion.getResultado2());
				TimeUnit.SECONDS.sleep(1);
				if(situacion.getDaño2() > 0) {
					System.out.println(enemigo.getNombre() + " pierde " + 
							situacion.getDaño2() + " puntos de vida.");
					enemigo.getTipo().reducirVida(-situacion.getDaño2());
					break;
				} else if(situacion.getDaño2() < 0) {
					System.out.println(jugador.getNombre() + " pierde " + 
							(situacion.getDaño2()*(-1)) + " puntos de vida.");
					jugador.getTipo().reducirVida(situacion.getDaño2());
					break;
				} else {
					System.out.println("Nadie pierde vida.");
					break;
				}
			} else {
				System.out.println("Opcion no reconocida, intentalo de nuevo.");
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual simula una cuenta de 3 de la wwe que mediante un bucle
	 * 		 muestra por pantalla el numero de la cuenta en la que esta. Con una probabilidad	
	 * 		 de que llegue a tres o no. Si llega a 3 el jugador abatido pierde y se acaba la partida
	 * 		 sino el jugador abatido recupera 2500 puntos de vida.
	 */
	public static void cuentaDeTres(Jugador cubridor, Jugador abatido) throws InterruptedException {
		TimeUnit.SECONDS.sleep(2);
		System.out.println(abatido.getNombre() +" ha caido tendido en la lona, " + 
				cubridor.getNombre() + " intenta la cuenta de tres!!!");
		int suerte = (int)(Math.random() * 100 + 1);
		System.out.println(suerte + " numero de la suerte en la cuenta");
		for(int i = 1; i <= 3; i++) {
			TimeUnit.SECONDS.sleep(2);
			if(i < 3) {
				System.out.println(i + "...");
			} else if(i == 3 && suerte < 30) {
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println("3!!! TENEMOS UN GANADOR!!! " + cubridor.getNombre() + 
						" ha ganado el combate ");
			} else {
				System.out.println("...");
				TimeUnit.SECONDS.sleep(1);
				System.out.println(abatido.getNombre() + " HA LOGRADO SALIR DE LA CUENTA DE TRES!!!, "
						+ "Y RECUPERA 2500 DE VIDA");
				abatido.getTipo().reducirVida(2500);
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametro dos objetos de tipo Jugador, un atacante
	 * 		 y un defensor. Mediante un numero aleatorio se calcula la probabilidad
	 * 	  	 de que el atacante conecte el ataque, si es asi el defensor pierde vida del
	 * 		 remate menos la cantidad de daño que hace su arma.
	 * 		 si el defensor consigue escapar no pierde vida.
	 */
	public static void situacionRemate(Jugador atacante, Jugador defensor) throws InterruptedException {
		int suerte = (int)(Math.random() * 100 + 1);
		System.out.println("Parece que vamos a ver algun remate!!!");
		TimeUnit.SECONDS.sleep(2);
		if(atacante.getContRemate() % 10 == 0) {
			atacante.mostrarRemate();
			TimeUnit.SECONDS.sleep(2);
			if(suerte < 50) {
				System.out.println(atacante.getNombre() + " consigue ejecutar su remate, "
						+ "por lo tanto hace " + (-atacante.getRemate().getDaño() + 
						defensor.getArma().getDaño()) + " de daño.");
				defensor.getTipo().reducirVida((-atacante.getRemate().getDaño() + defensor.
						getArma().getDaño()));
			} else {
				System.out.println(defensor.getNombre() + " ha conseguido evadir el remate!!!");
			}
		} 
	}
	
	/*
	 * Pre:---
	 * Post: metodo que mediante una consulta nuestra base de datos crea un objeto
	 * 		 Jugador, o si el usuario prefiere crear un nuevo jugador nos lleva
	 * 		 al metodo que va a crear al personaje.
	 */
	public static Jugador recogerJugador() throws SQLException {
		Jugador playerOne = null;
		while(playerOne == null) {
			String eleccionJugar = pedirOrden("Elige una opcion: ");
			if(eleccionJugar.equalsIgnoreCase("EXISTENTE")) {
				playerOne = comprobarPersonaje();
				return playerOne;
			} else if(eleccionJugar.equalsIgnoreCase("NUEVO")) {
				playerOne = crearPersonaje();
				return playerOne;
			} else {
				System.out.println("Comando no correcto");
			}
		}
		return playerOne;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que enseña los personajes disponibles para el usuario
	 * 		 el usuario elige uno y lo devuelve como parametro.
	 * 		 Si el resultado de la consulta es negativo se vuelve a preguntar
	 * 		 al usuario hasta que la select devuelva un resultado no nulo.
	 */
	public static Jugador comprobarPersonaje() throws SQLException {
		wwe.showPlayers();
		Jugador player = null;
		while(true) {
			String eleccion = pedirOrden("Escoge un nombre: ");
			player = wwe.getPlayer(eleccion);
			if(player != null) {
				return player;
			} else {
				System.out.println("El nombre introducido no es correcto, introducelo de nuevo.");
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que pide al usuario las caractiristicas del personaje
	 * 		 que quiere crear. Para el tipo, arma y remate llama a otro metodo
	 * 		 que devuelve el tipo correspondiente para luego crear un objeto de tipo Jugador 
	 * 		 para luego devolverlo.
	 */
	public static Jugador crearPersonaje() throws SQLException {
		String nombre = pedirOrden("Dame un nombre: ");
		Tipo tipo = comprobarTipo();
		Arma arma = comprobarArma();
		Remate remate = comprobarRemate();
		int contadorRemate = (int) (Math.random() * 3 + 1);
		Jugador nuevo = new Jugador(nombre, tipo, arma, remate, contadorRemate);
		return nuevo;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que enseña los remates disponibles para el usuario
	 * 		 el usuario elige uno y lo devuelve como parametro.
	 * 		 Si el resultado de la consulta es negativo se vuelve a preguntar
	 * 		 al usuario hasta que la select devuelva un resultado no nulo. 
	 */
	public static Remate comprobarRemate() throws SQLException {
		wwe.showFinisher();
		Remate remate = null;
		while(true) {
			String ordenRemate = pedirOrden("Escoge una remate: ");
			remate = wwe.getFinisher(ordenRemate);
			if(remate != null) {
				return remate;
			} else {
				System.out.println("Eleccion incorrecta, intentalo de nuevo.");
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que enseña los tipos disponibles para el usuario
	 * 		 el usuario elige uno y lo devuelve como parametro.
	 * 		 Si el resultado de la consulta es negativo se vuelve a preguntar
	 * 		 al usuario hasta que la select devuelva un resultado no nulo.
	 */
	public static Tipo comprobarTipo() throws SQLException {
		wwe.showType();
		Tipo tipo = null;
		while(true) {
			String ordenTipo = pedirOrden("Dime de que tipo quieres que sea: ");
			tipo = wwe.getType(ordenTipo);
			if(tipo != null) {
				return tipo;
			} else {
				System.out.println("Eleccion incorrecta, intentalo de nuevo.");
			}
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo que enseña las armas disponibles para el usuario
	 * 		 el usuario elige uno y lo devuelve como parametro.
	 * 		 Si el resultado de la consulta es negativo se vuelve a preguntar
	 * 		 al usuario hasta que la select devuelva un resultado no nulo.
	 */
	public static Arma comprobarArma() throws SQLException {
		wwe.showWeapons();
		Arma arma = null;
		while(true) {
			String ordenArma = pedirOrden("Escoge una arma: ");
			arma = wwe.getWeapon(ordenArma);
			if(arma != null) {
				return arma;
			} else {
				System.out.println("Eleccion incorrecta, intentalo de nuevo.");
			}
		}
	}
	
	/**	
	 * Pre:---
	 * Post: menu que muestra las opciones al usuario si en en la opcion jugar.
	 */
	public static void menuJugar() {
		System.out.println("--> Jugar con personaje existente [Existente]");
		System.out.println("--> Crear nuevo personaje [Nuevo]");
	}
	
	/**
	 * Pre:---
	 * Post: metodo principal que pide al usuario un String mediante un mensaje
	 * 		 que recibe como parametro.
	 */
	public static String pedirOrden(String preg) {
		System.out.print(preg);
		String orden = n.nextLine().trim();
		return orden;
	}
	
	/**
	 * Pre:---
	 * Post: metodo donde se muestran las opciones que tiene el usuario a elegir.
	 */
	public static void menuPrincipal() {
		System.out.println("--> Jugar [Jugar]");
		System.out.println("--> Introducir elementos [Nuevo]");
		System.out.println("--> Ver Ranking [Ver]");
		System.out.println("--> Salir [Salir]");
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametros un Scanner y un mensaje a mostrar por
	 * 		 pantalla para soliictar al usuario un numero, devuelve un numero entero.
	 */
	public static int solicitarNumero(String preg) {
		int numero = 0;
		while(true) {
			try {
				System.out.print(preg);
				numero = n.nextInt();
				if(numero <= 0 && preg.contains("jugador!")) {
					n.nextLine();
					return numero;
				} else if(numero > 0 && numero < 10000) {
					n.nextLine();
					return numero;
				} else {
					System.out.println("Numero no valido");
				}
			} catch(InputMismatchException e) {
				System.out.println("No reconocido");
				n.nextLine();
			}
		}  
	}
}
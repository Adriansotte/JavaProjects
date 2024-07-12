package practica6JuegoDeRol;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase por la cual ahcemos la conexion a la base de datos de nuestro juego de 
 * rol, contiene todos los metodos como para: consultar, agregar registros de 
 * las diferentes tabla de la base de datos. 
 *
 */
public class DataBase {

	/*
	 * Almacenamos la conexión con nuestra bd en un objeto de tipo Connection. La
	 * abrimos cuando queremos empezar a operar con la BD y siempre debemos cerrarla
	 * al finalizar.
	 */
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	
	/*
	 * Almacena el resultado de las consultas en un dato de tipo ResultSet, que
	 * tiene sus propios métodos para trabajar con las tablas y columnas.
	 */
	private ResultSet resultSet = null;

	/*
	 * Almacenamos los datos de conexión con nuestra BD.
	 */
	final private String host = "localhost:3306/juegoRol";
	final private String user = "root";
	final private String passwd = "";

	/**
	 * Pre:---
	 * Post: metodo que recibe como parametros la informacion necesaria para guardar en la base de
	 * 		 datos un objeto de tipo Jugador en la tabla Personaje
	 */
	public void addPlayer(String nombre, Tipo type, Arma weapon, Remate finisher, int contRemate) throws SQLException {
		preparedStatement = connect
				.prepareStatement("insert into personaje(nombre, codTipo, codArma, codRemate, medidorRemate) values (?, ?, ?, ?, ?)");
		preparedStatement.setString(1, nombre);
		preparedStatement.setInt(2, type.getCodTipo());
		preparedStatement.setInt(3, weapon.getCodArma());
		preparedStatement.setInt(4, finisher.getCodRemate());
		preparedStatement.setInt(5, contRemate);
		preparedStatement.executeUpdate();
		System.out.println("Personaje añadido con exito!!!");
	}
	
	/**
	 * Pre:---
	 * Post: metodo que hace una consulta a la base de datos y recoge los datos
	 * 		 de la tabla Personaje
	 */
	public void showPlayers() throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT * from personaje");
		resultSet = preparedStatement.executeQuery();
		writePlayers(resultSet);
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe un parametro con el cual hace una consulta a la base 
	 * 		 de datos y recoge el personaje que concida con el nombre enviado
	 * 		 si no hay ningun dato con ese nombre devuelve null.
	 */
	public Jugador getPlayer(String nombre) throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT * from personaje where nombre = ?");
		preparedStatement.setString(1, nombre);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			String name = resultSet.getString(2);
			int type = resultSet.getInt(3);
			int weapon = resultSet.getInt(4);
			int finisher = resultSet.getInt(5);
			int medidorRemate = resultSet.getInt(6);
			Tipo tipo = getType(type);
			Arma arma = getWeapon(weapon);
			Remate remate = getFinisher(finisher);
			Jugador nuevo = new Jugador(name, tipo, arma, remate, medidorRemate);
			return nuevo;
		}
		return null;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que hace una consulta a la base de datos y mediante un id recibido
	 * 		 como parametro, que devuelve los datos necesarios para luego crear un objeto
	 * 		 de tipo Jugador, recorre el resultado de la consulta y crea el Jugador para
	 * 		 luego devolverlo, si Resulset es nulo devuelve null.
	 */
	public Jugador getPlayer(int id) throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT * from personaje where id = ?");
		preparedStatement.setInt(1, id);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			String name = resultSet.getString(2);
			int type = resultSet.getInt(3);
			int weapon = resultSet.getInt(4);
			int finisher = resultSet.getInt(5);
			int medidorRemate = resultSet.getInt(6);
			Tipo tipo = getType(type);
			Arma arma = getWeapon(weapon);
			Remate remate = getFinisher(finisher);
			Jugador nuevo = new Jugador(name, tipo, arma, remate, medidorRemate);
			return nuevo;
		}
		return null;
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual recoge todos los registros de la tabla Arma.
	 */
	public void showWeapons() throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT * from arma");
		resultSet = preparedStatement.executeQuery();
		writeWeapon(resultSet);
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual recibe como parametro un tipo int, que recorrera la tabla arma	
	 * 		 y si algun parametro coincide con el parametro recibido, lo devolvera, sino devolvera
	 * 		 null.
	 */
	public Arma getWeapon(int codArma) throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT * from arma where codArma = ?");
		preparedStatement.setInt(1, codArma);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			Arma nueva = new Arma(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
			return nueva;
		}
		return null;
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual recibe como parametro un tipo String, que recorrera la tabla arma	
	 * 		 y si algun parametro coincide con el parametro recibido, lo devolvera, sino devolvera
	 * 		 null.
	 */
	public Arma getWeapon(String arma) throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT * from arma where arma = ?");
		preparedStatement.setString(1, arma);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			Arma nueva = new Arma(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
			return nueva;
		}
		return null;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe como parametros la informacion necesaria para agregar 
	 * 		 registros a la tabla Arma de la base de datos.
	 */
	public void addWeapon(String weapon, int damage) throws SQLException {
		preparedStatement = connect
				.prepareStatement("insert into arma(arma, daño) values (?, ?)");
		preparedStatement.setString(1, weapon);
		preparedStatement.setInt(2, damage);
		preparedStatement.executeUpdate();
		System.out.println("Arma añadida con exito!!!");
	}
	
	/**
	 * Pre:---
	 * Post: metodo que muestra la informacion de la tabla tipo.
	 */
	public void showType() throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT * from tipo");
		resultSet = preparedStatement.executeQuery();
		writeType(resultSet);
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual recibe como parametro de tipo int, y busca en la tabla de
	 * 		 Tipo el registro que coincida con el parametro, si existe lo devuelve, sino
	 * 		 devuelve null.
	 */
	public Tipo getType(int codTipo) throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT * from tipo where codTipo = ?");
		preparedStatement.setInt(1, codTipo);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			Tipo nuevo = new Tipo(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
			return nuevo;
		}
		return null;
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual recibe como parametro de tipo String, y busca en la tabla de
	 * 		 Tipo el registro que coincida con el parametro, si existe lo devuelve, sino
	 * 		 devuelve null.
	 */
	public Tipo getType(String nombre) throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT * from tipo where tipo = ?");
		preparedStatement.setString(1, nombre);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			Tipo nuevo = new Tipo(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
			return nuevo;
		}
		return null;
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual recibe los datos necesarios para agregar registros en la
	 * 		 tabla Tipo de la base de datos.
	 */
	public void addType(String type, int health) throws SQLException {
		preparedStatement = connect
				.prepareStatement("insert into tipo(tipo, vida) values (?, ?)");
		preparedStatement.setString(1, type);
		preparedStatement.setInt(2, health);
		preparedStatement.executeUpdate();
		System.out.println("Tipo añadido con exito!!!");
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual muestra toda la informacion de la tabla remate.
	 */
	public void showFinisher() throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT * from remate");
		resultSet = preparedStatement.executeQuery();
		writeFinisher(resultSet);
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual mediante un parametro recibido de tipo int, busca en la tabla
	 * 		 de Remate el registro cuyo nombre coincida con el mencionado. Si no encuentra nada
	 * 		 devuelve null.
	 */
	public Remate getFinisher(int codRemate) throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT * from remate where codRemate = ?");
		preparedStatement.setInt(1, codRemate);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			Remate nuevo = new Remate(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
			return nuevo;
		}
		return null;
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual mediante un parametro recibido de tipo String, busca en la tabla
	 * 		 de Remate el registro cuyo nombre coincida con el mencionado. Si no encuentra nada
	 * 		 devuelve null.
	 */
	public Remate getFinisher(String remate) throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT * from remate where remate = ?");
		preparedStatement.setString(1, remate);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			Remate nuevo = new Remate(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3));
			return nuevo;
		}
		return null;
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual recibe como parametros la informacion necesaria
	 * 		 para añadir registros en la tabla de Remate de la base de datos.
	 */
	public void addFinisher(String finisher, int damage) throws SQLException {
		preparedStatement = connect
				.prepareStatement("insert into remate(remate, daño) values (?, ?)");
		preparedStatement.setString(1, finisher);
		preparedStatement.setInt(2, damage);
		preparedStatement.executeUpdate();
		System.out.println("Tipo añadido con exito!!!");
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual muestra toda la infomacion de la tabla situacion.
	 */
	public void showSituations() throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT * from situacion");
		resultSet = preparedStatement.executeQuery();
		writeSituations(resultSet);
	}
	
	/**
	 * Pre:---
	 * Post: metodo que recibe una variable tipo int, y realiza una consulta a la
	 * 		 tabla Situacion de la base de datos que busca una situacion con dicho id,
	 * 		 si lo encuentra crea una variable de tipo Situacion y le devuelve, sino
	 * 		 devuelve null.
	 */
	public Situacion getSituation(int codSituation) throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT * from situacion where codSituacion = ?");
		preparedStatement.setInt(1, codSituation);
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			Situacion nueva = new Situacion(resultSet.getString(2), resultSet.getString(3), resultSet.getString(4),
					resultSet.getInt(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8));
			return nueva;
		}
		return null;
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual recibe como paramtetros los datos necesarios para añadir 
	 * 		 un registro a la tabla de situacion de la base de datos.
	 */
	public void addSituation(String situation, String choice1, String result1, int damage1, 
			String choice2, String result2, int damage2) throws SQLException {
		preparedStatement = connect
				.prepareStatement("insert into situacion(situacion, eleccion1, resultado1, daño1, "
						+ "eleccion2, resultado2, daño2) values (?, ?, ?, ?, ?, ?, ?)");
		preparedStatement.setString(1, situation);
		preparedStatement.setString(2, choice1);
		preparedStatement.setString(3, result1);
		preparedStatement.setInt(4, damage1);
		preparedStatement.setString(5, choice2);
		preparedStatement.setString(6, result2);
		preparedStatement.setInt(7, damage2);
		preparedStatement.executeUpdate();
		System.out.println("Situacion añadida con exito!!!");
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual devuelve los datos de la tabla Ranking. Ordenandolos de mayor a menor.
	 */
	public void getRanking() throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT * FROM	ranking	 ORDER BY puntuacion DESC");
		resultSet = preparedStatement.executeQuery();
		writeRanking(resultSet);
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual agrega registros a la tabla de Ranking de la base de datos.
	 */
	public void addRanking(String jugador,  int puntuacion) throws SQLException {
		preparedStatement = connect
				.prepareStatement("insert into ranking(nombre, puntuacion) values (?, ?)");
		preparedStatement.setString(1, jugador);
		preparedStatement.setInt(2, puntuacion);
		preparedStatement.executeUpdate();
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual inicia la consexion con la base de datos.
	 */
	public void start() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "?" + "user=" + user + "&password=" + passwd);
			statement = connect.createStatement();
		} catch (Exception e) {
			throw e;
		} 
	}

	/**
	 * Pre: --- 
	 * Post: muestra por pantalla el nombre de la tabla sobre la que se ha
	 * ejecutado la consulta, seguido de todas sus columnas.
	 */
	public void writeMetaData(ResultSet resultSet) throws SQLException {
		System.out.println("The columns in the table are: ");
		System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
		for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
			System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
		}
	}

	/**
	 * Pre: --- 
	 * Post: muestra por pantalla el contenido almacenado en [resultSet].
	 */
	private void writePlayers(ResultSet resultSet) throws SQLException {
		System.out.println("Personajes disponibles: ");
		System.out.println("-----------------------------------");
		while(resultSet.next()) {
			String nombre = resultSet.getString(2);
			System.out.println("\tNombre: " + nombre);
			System.out.println("-----------------------------------");
		}
	}
	
	/**
	 * Pre: --- 
	 * Post: muestra por pantalla el contenido almacenado en [resultSet].
	 */
	private void writeWeapon(ResultSet resultSet) throws SQLException {
		while(resultSet.next()) {
			String arma = resultSet.getString(2);
			int daño = resultSet.getInt(3);
			System.out.println("\tArma: " + arma);
			System.out.println("\tDaño: " + daño);
			System.out.println("-----------------------------------");
		}
	}

	/**
	 * Pre: --- 
	 * Post: muestra por pantalla el contenido almacenado en [resultSet].
	 */
	private void writeType(ResultSet resultSet) throws SQLException {
		while(resultSet.next()) {
			String tipo = resultSet.getString(2);
			int vida = resultSet.getInt(3);
			System.out.println("\tTipo: " + tipo);
			System.out.println("\tVida: " + vida);
			System.out.println("-----------------------------------");
		}
	}
	
	/**
	 * Pre: --- 
	 * Post: muestra por pantalla el contenido almacenado en [resultSet].
	 */
	private void writeFinisher(ResultSet resultSet) throws SQLException {
		while(resultSet.next()) {
			String remate = resultSet.getString(2);
			int daño = resultSet.getInt(3);
			System.out.println("\tRemate: " + remate);
			System.out.println("\tDaño: " + daño);
			System.out.println("-----------------------------------");
		}
	}
	
	/**
	 * Pre: --- 
	 * Post: muestra por pantalla el contenido almacenado en [resultSet].
	 */
	private void writeRanking(ResultSet resultSet) throws SQLException {
		while(resultSet.next()) {
			String nombre = resultSet.getString(2);
			int puntuacion = resultSet.getInt(3);
			System.out.println("\tJugador: " + nombre + " \tPuntuacion: " + puntuacion);
		}
	}
	
	/**
	 * Pre: --- 
	 * Post: muestra por pantalla el contenido almacenado en [resultSet].
	 */
	private void writeSituations(ResultSet resultSet) throws SQLException {
		while(resultSet.next()) {
			int id = resultSet.getInt(1);
			String situacion = resultSet.getString(2);
			String eleccion1 = resultSet.getString(3);
			String resultado1 = resultSet.getString(4);
			int daño1 = resultSet.getInt(5);
			String eleccion2 = resultSet.getString(6);
			String resultado2 = resultSet.getString(7);
			int daño2 = resultSet.getInt(8);
			System.out.println("\tid: " + id);
			System.out.println("\tSituacion: " + situacion);
			System.out.println("\tEleccion 1: " + eleccion1);
			System.out.println("\tResultado 1: " + resultado1);
			System.out.println("\tDaño 1: " + daño1);
			System.out.println("\tEleccion 2: " + eleccion2);
			System.out.println("\tResultado 2: " + resultado2);
			System.out.println("\tDaño 2: " + daño2);
			System.out.println("-----------------------------------");
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual cuenta la cantidad de registros que hay en la tabla Situacion.
	 */
	public int getSizeSituations() throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT count(codSituacion) FROM situacion;");
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			int size = resultSet.getInt(1);
			return size;
		}
		return 0;
	}
	
	/**
	 * Pre:---
	 * Post: metodo que realiza una consulta a nuestra base de datos y devuelve el tamano
	 * 		 de la tabla Jugadores.
	 */
	public int getSizePlayers() throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT count(id) FROM personaje;");
		resultSet = preparedStatement.executeQuery();
		while(resultSet.next()) {
			int size = resultSet.getInt(1);
			return size;
		}
		return 0;
	}
	
	/**
	 * Pre: --- 
	 * Post: cerramos todas las conexiones abiertas, el resultSet y el
	 * 		 statement. Si no se cierran correctamente, puede ocurrir que las consultas no
	 * 		 devuelvan el resultado esperado. Además, si dejamos muchas conexiones a la BD
	 * 		 abiertas podemos llegar a saturarla y no aceptará más conexiones.
	 */
	public void close() {
		try {
			if(resultSet != null) {
				resultSet.close();
			}
			if(statement != null) {
				statement.close();
			}
			if(connect != null) {
				connect.close();
			}
		} catch(Exception e) {}
	}
}

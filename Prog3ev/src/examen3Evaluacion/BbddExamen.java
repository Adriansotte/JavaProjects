package examen3Evaluacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Clase que representa una base de datos, contiene los metodos
 * necesarios para el inicio, adicion de elementos y el cierre de 
 * conexion con la base de datos del ejercicio.
 */
public class BbddExamen {

	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	final private String host = "localhost:3306/examen_programacion";
	final private String user = "root";
	final private String passwd = "";
	
	/**
	 * Pre:---
	 * Post: metodo que añade a la base de datos los datos que recibe como parametro.
	 */
	public void addWord(String letra, String palabra, int linea) throws SQLException {
		preparedStatement = connect
				.prepareStatement("insert into examen(letra, palabra, linea) values (?, ?, ?)");
		preparedStatement.setString(1, letra);
		preparedStatement.setString(2, palabra);
		preparedStatement.setInt(3, linea);
		preparedStatement.executeUpdate();
	}
	
	/**
	 * Pre:---
	 * Post: metodo que inicia la conexion con la base de datos.
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
	 * Post: metodo que cierra la conexion con la base de datos.
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

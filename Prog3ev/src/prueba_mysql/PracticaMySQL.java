package prueba_mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PracticaMySQL {

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
	final private String host = "localhost:3306/ejercicio1";
	final private String user = "root";
	final private String passwd = "";

	public void addUser(String nombre, int numero) throws SQLException {
		preparedStatement = connect
				.prepareStatement("insert into ejercicio1(nombre, numero) values (?, ?)");
		/*
		 * Cada uno de los "?" de la consulta indica que ahí se sitúa un parámetro que
		 * todavía no se ha añadido. Para poder hacerlo, ejecutamos las consultas set
		 * con la posición del parametro que estamos colocando y su valor. LAS
		 * POSICIONES EMPIEZAN DESDE 1!.
		 */
		//preparedStatement.setInt(1, this.idGlobal);
		preparedStatement.setString(1, nombre);
		preparedStatement.setInt(2, numero);
		// preparedStatement.setDate(4, new java.sql.Date(2009, 12, 11));
		System.out.println("QUERY ---> insert into ejercicio1(nombre, numero)");
		preparedStatement.executeUpdate();
	}
	
	public void updateUser(String nombre, int numero) throws SQLException {
		preparedStatement = connect
				.prepareStatement("update ejercicio1 set numero = ? where nombre = ?");
		preparedStatement.setInt(1, numero);
		preparedStatement.setString(2, nombre);
		System.out.println("QUERY ---> update ejercicio1 set numero = ? where nombre = ?");
		preparedStatement.executeUpdate();
		writeMetaData(resultSet);
	}
	
	public void showUsers() throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT * from ejercicio1");
		System.out.println("QUERY ---> select * from ejercicio1");
		resultSet = preparedStatement.executeQuery();
		writeResultSet(resultSet);
	}
	
	public void removeUser(String nombre) throws SQLException {
		preparedStatement = connect
			   .prepareStatement("delete from ejercicio1 where nombre= ?");
	    preparedStatement.setString(1, nombre);
	    preparedStatement.executeUpdate();	
	    System.out.println("QUERY ---> delete from user where");
	    writeResultSet(resultSet);
	}
	
	public void readDataBase() throws Exception {
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
	private void writeResultSet(ResultSet resultSet) throws SQLException {
		/*
		 * Mientras resultSet contenga más usuarios, seguimos avanzando de manera
		 * similar a los ficheros de texto.
		 */
		while(resultSet.next()) {
			/*
			 * Podemos seleccionar la columna de la que queremos leer el dato poniendo su
			 * nombre, o también indicando su número de columna... siempre empezando desde
			 * 1! EJ: resultSet.getSTring(2);
			 */
			int id = resultSet.getInt(1);
			String nombre = resultSet.getString(2);
			int numero = resultSet.getInt(3);
			System.out.println("\tid: " + id);
			System.out.println("\tNombre: " + nombre);
			System.out.println("\tNumero: " + numero);
		}
	}

	/**
	 * Pre: --- 
	 * Post: cerramos todas las conexiones abiertas, el resultSet y el
	 * statement. Si no se cierran correctamente, puede ocurrir que las consultas no
	 * devuelvan el resultado esperado. Además, si dejamos muchas conexiones a la BD
	 * abiertas podemos llegar a saturarla y no aceptará más conexiones.
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
		} catch(Exception e) {
		}
	}
}
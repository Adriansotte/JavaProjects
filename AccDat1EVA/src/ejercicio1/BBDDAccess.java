package ejercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
 
/**
 * Clase que representa una conexion con una base de datos. En esta clase,
 * se realizan las distintas operaciones como: insert, uptate, select y delete
 * de la tabla Cliente de la base de datos.
 */
public class BBDDAccess {
	
	/*
	 * Almacenamos la conexión con nuestra bd en un objeto de tipo Connection.
	 */
	private Connection connect = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	
	/*
	 * Almacena el resultado de las consultas en un dato de tipo ResultSet
	 */
	private ResultSet resultSet = null;

	/*
	 * Almacenamos los datos de conexión con nuestra BD.
	 */
	final private String host = "localhost:3306/examen";
	final private String user = "root";
	final private String passwd = "";

	/**
	 * Pre:---
	 * Post: metodo que realiza una insercion en la tabla Cliente de la base de datos
	 * 		 segun los datos recibidos como parametros.
	 * @param DNI
	 * @param nombre
	 * @param telefono
	 * @param direccion
	 * @throws SQLException
	 */
	public void agregarDatos(String DNI, String nombre, String telefono, String direccion) throws SQLException {
		preparedStatement = connect
				.prepareStatement("insert into cliente(DNI, nombre, telefono, direccion) values (?, ?, ?, ?)");
		preparedStatement.setString(1, DNI);
		preparedStatement.setString(2, nombre);
		preparedStatement.setString(3, "+34 " + telefono);
		preparedStatement.setString(4, direccion);
		preparedStatement.executeUpdate();
		System.out.println("Operacion realizada.");
	}
	
	/**
	 * Pre:---
	 * Post: metodo que realiza un update en la tabla Cliente de la base de datos segun
	 * 		 los parametros recibidos.
	 * @param nombre
	 * @param telefono
	 * @throws SQLException
	 */
	public void actualizarUsuario(String nombre, String telefono) throws SQLException {
		preparedStatement = connect
				.prepareStatement("update cliente set telefono = ? where nombre = ?");
		preparedStatement.setString(1, telefono);
		preparedStatement.setString(2, nombre);
		preparedStatement.executeUpdate();
		System.out.println("Operacion realizada.");
	}
	
	/**
	 * Pre:---
	 * Post: metodo que hace una consulta a la tabla Cliente y enseña los datos de
	 * 		 la tabla.
	 * @throws SQLException
	 */
	public void enseñarInformacion() throws SQLException {
		preparedStatement = connect.prepareStatement("SELECT * from cliente");
		resultSet = preparedStatement.executeQuery();
		writeResultSet(resultSet);
	}
	
	/**
	 * Pre:---
	 * Post: metodo que realiza un Delete en la tabla Cliente segun el parametro
	 * 		 recibido.
	 * @param nombre
	 * @throws SQLException
	 */
	public void eliminarUsuario(String nombre) throws SQLException {
		preparedStatement = connect
			   .prepareStatement("delete from cliente where nombre= ?");
	    preparedStatement.setString(1, nombre);
	    preparedStatement.executeUpdate();
	    System.out.println("Operacion realizada.");
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual inicia la consexion con la base de datos.
	 * @throws Exception
	 */
	public void iniciarConexion() throws Exception {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager
					.getConnection("jdbc:mysql://" + host + "?" + "user=" + user + "&password=" + passwd);
			statement = connect.createStatement();
			// Hacemos que el autocommit este en false para que si hay algun error, no me guarde la informacion.
			connect.setAutoCommit(false);
		} catch (Exception e) {
			throw e;
		} 
	}

	/**
	 * Pre: --- 
	 * Post: muestra por pantalla el contenido almacenado en [resultSet].
	 * @param resultSet
	 * @throws SQLException
	 */
	private void writeResultSet(ResultSet resultSet) throws SQLException {
		while(resultSet.next()) {
			String DNI = resultSet.getString(1);
			String nombre = resultSet.getString(2);
			String telefono = resultSet.getString(3);
			String direccion = resultSet.getString(4);
			System.out.println("\tDNI: " + DNI);
			System.out.println("\tNombre: " + nombre);
			System.out.println("\tNumero: " + telefono);
			System.out.println("\tDireccion: " + direccion);
		}
	}
	
	public void rollback() {
		try {
			connect.rollback();
		} catch(SQLException e) {
			e.printStackTrace();
		}
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
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
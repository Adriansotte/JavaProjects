package practica4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Programa que se encarga de la gestion de un colegio, donde podremos
 * listar, añadir, eliminar las matriculas en una asignatura de un alumno
 * en especifico o en el caso de listar, podremos listar todos los alumnos
 * de una asignatura o todas las asignaturas de un alumno, siguiendo unos
 * criterios de ordenacion que se especifican el el propio menu del programa. 
 */
public class Main {

	/**
	 * Pre:--- 
	 * Post: metodo principal donde se recogen los datos necesarios de los
	 * 		 ficheros en ArrayList y se llama al ejecutor del programa donde se mandan los
	 * 		 ArrayList.
	 */
	public static void main(String[] args) {
		System.out.println("---GESTOR DE MATRICULAS---");
		ArrayList<Alumno> listaAlumnos = recogerAlumnos();
		ArrayList<Asignatura> listaAsignaturas = recogerAsignaturas();
		ArrayList<Matricula> matriculas = recogerMatricula();
		juntarInformacion(listaAlumnos, listaAsignaturas, matriculas);
		mostrar(matriculas);
		ejecutor(listaAlumnos, listaAsignaturas, matriculas);
	}
	
	public static void mostrar(ArrayList<Matricula> m) {
		for(int i = 0; i < m.size(); i++) {
			System.out.println(m.get(i));
		}
	}
	
	/**
	 * Pre:--- 
	 * Post: metodo ejecutor el cual hace la funcion de menu para que el
	 * 		 usuario interactue. Recoge la orden del usuario mediante un metodo y segun la
	 * 		 orden hace una accion u otra.
	 */
	public static void ejecutor(ArrayList<Alumno> listaAlumnos, ArrayList<Asignatura> listaAsignaturas,
			ArrayList<Matricula> matriculas) {
		Scanner n = new Scanner(System.in);
		while(true) {
			try {
				menu();
				String[] orden = pedirOrden(n);
				if(orden[0].equalsIgnoreCase("matriculas")) {
					System.out.println("La cantidad de matriculas es: " + matriculas.size());
				} else if(orden[0].equalsIgnoreCase("asignaturas")) {
					asignaturasAlumno(orden, listaAlumnos);
				} else if(orden[0].equalsIgnoreCase("alumnos")) {
					alumnoAsignaturas(orden, listaAlumnos);
				} else if(orden[0].equalsIgnoreCase("eliminar")) {
					eliminarNip(orden, listaAlumnos, listaAsignaturas);
				} else if(orden[0].equalsIgnoreCase("matricular")) {
					matricularAsig(orden, listaAlumnos, listaAsignaturas);
				} else if(orden[0].equalsIgnoreCase("guardar")) {
					ArrayList<Matricula> lista = crearMatriculas(listaAlumnos);
					matriculas = lista;
					modificarDat(lista);
					System.out.println("Modificado con exito");
				} else if(orden[0].equalsIgnoreCase("salir")) {
					break;
				} else {
					System.out.println("Orden no reconocida, pruebe de nuevo.");
				}
			} catch(NumberFormatException e) {
				System.out.println("Fallo en la orden");
			} catch(InputMismatchException e) {
				System.out.println("Fallo en la orden");
			} catch(NullPointerException e) {
				System.out.println("Fallo en la orden");
			} catch(IndexOutOfBoundsException e) {
				System.out.println("Fallo en la orden");
			}
		}
		n.close();
	}

	/**
	 * Pre:--- 
	 * Post: metodo que recibe un ArrayList de objetos alumno, y se encarga de recopilar
	 * 		 en un arraylist distinto formado de objetos matricula, utilizando el nip del
	 * 	 	 alumno y el codigo de la asignatura para hacer elobjeto matricula y almacenarlo.
	 */
	public static ArrayList<Matricula> crearMatriculas(ArrayList<Alumno> listaAlumnos) {
		ArrayList<Matricula> matriculas = new ArrayList<>();
		for(int i = 0; i < listaAlumnos.size(); i++) {
			Alumno alumno = listaAlumnos.get(i);
			for(int j = 0; j < alumno.getAsignaturas().size(); j++) {
				Asignatura asignatura = alumno.getAsignaturas().get(j);
				Matricula matricula = new Matricula(alumno.getNip(), asignatura.getCodAsig());
				matriculas.add(matricula);
			}
		}
		return matriculas;
	}

	/**
	 * Pre:--- 
	 * Post: metodo que recibe como parametro una tabla donde estan las ordenes introducidas
	 * 		 por el usuario y un ArrayList de objetos Alumno, Recoge todas las asignaturas
	 * 		 del alumno y segun la orden la ordena alfabetica o numericamente.
	 */
	public static void asignaturasAlumno(String[] orden, ArrayList<Alumno> listaAlumnos) {
		Alumno alumno = null;
		if(orden.length == 3) {
			alumno = devolverAlumno(listaAlumnos, Integer.parseInt(orden[orden.length - 2]));
		} else {
			alumno = devolverAlumno(listaAlumnos, Integer.parseInt(orden[orden.length - 1]));
		}
		ArrayList<Asignatura> asignaturasAlumno = alumno.getAsignaturas();
		if(alumno != null && orden.length == 3 && orden[orden.length - 1].equalsIgnoreCase("a")) {
			Collections.sort(asignaturasAlumno, new AsignaturaAlfabeticamente());
			System.out.println("Asignaturas del alumno/a: " + alumno.getNombre() + " " + alumno.getApellido());
			mostrarListaAsignaturas(asignaturasAlumno);
		} else if(alumno != null && (orden[orden.length - 1].equalsIgnoreCase("c")
				|| orden.length == 2)) {
			Collections.sort(asignaturasAlumno, new AsignaturaNumericamente());
			System.out.println("Asignaturas del alumno/a: " + alumno.getNombre() + " " + alumno.getApellido());
			mostrarListaAsignaturas(asignaturasAlumno);
		} else {
			System.out.println("Alumno no encontrado/ Ordenacion no especificada");
		}
	}

	/**
	 * Pre:--- 
	 * Post: metodo que recibe una tabla donde viene especificada la orden, y partir de la
	 * 		 orden se geneara una lista de alumnos la cual siguiento la orden se ordenara
	 * 		 numericamente o alfabeticamente y se mostrara por pantalla.
	 */
	public static void alumnoAsignaturas(String[] orden, ArrayList<Alumno> listaAlumnos) {
		ArrayList<Alumno> lista = null;
		if(orden.length == 3) {
			lista = recopilarAlumnos(listaAlumnos, Integer.parseInt(orden[orden.length - 2]));
		} else {
			lista = recopilarAlumnos(listaAlumnos, Integer.parseInt(orden[orden.length - 1]));
		}
		if(lista.size() != 0 && orden[orden.length - 1].equalsIgnoreCase("a")) {
			Collections.sort(lista, new AlumnosAlfabeticamente());
			mostrarListaAlumnos(lista);
		} else if(lista.size() != 0 && (orden[orden.length - 1].equalsIgnoreCase("n") || orden.length == 2)) {
			Collections.sort(lista, new AlumnosNumericamente());
			mostrarListaAlumnos(lista);
		} else {
			System.out.println("Asignatura no encontrada/ Orden no reconocida");
		}
	}

	/**
	 * Pre:--- 
	 * Post: metodo que recibe como parametros una tabla de String en la cual esta la orden
	 * 		 a ejecutar y una lista de alumnos. Recorre la lista de alumnos e invoca al
	 * 		 alumno de la orden, y segun especifique la orden borra todas o solo las 
	 * 		 asignaturas especificadas para el alumno.
	 */
	public static void eliminarNip(String[] orden, ArrayList<Alumno> listaAlumnos,
			ArrayList<Asignatura> listaAsignaturas) {
		Alumno aBorrar = devolverAlumno(listaAlumnos, Integer.parseInt(orden[1]));
		if(aBorrar != null && orden.length > 2) {
			ArrayList<Asignatura> asignaturas = recopilarAsignaturas(listaAsignaturas, orden);
			aBorrar.getAsignaturas().removeAll(asignaturas);				
			System.out.println("Se han quitado las matriculas especificadas del alumno");
		} else if(aBorrar != null && orden.length == 2) {
			aBorrar.getAsignaturas().removeAll(aBorrar.getAsignaturas());
			System.out.println("Se han quitado todas las matriculas del alumno");
		} else {
			System.out.println("Asignatura no encontrada/ Orden no reconocida");
		}
	}

	/**
	 * Pre:--- 
	 * Post: metodo que recibe como parametro una ooden y un arrayList de objetos alumno
	 * 		 y otro de objetos asignatura, se encarga de añadir las asignaturas especificadas
	 * 		 en la orden al nip del alumno especificado en la orden.
	 */
	public static void matricularAsig(String[] orden, ArrayList<Alumno> listaAlumnos,
			ArrayList<Asignatura> listaAsignaturas) {
		Alumno aMatricular = devolverAlumno(listaAlumnos, Integer.parseInt(orden[1]));
		if(aMatricular != null && orden.length > 2) {
			ArrayList<Asignatura> asignaturas = recopilarAsignaturas(listaAsignaturas, orden);
			if(asignaturas.size() == 0) {
				System.out.println("No se han reconocido los codigos.");
			} else {
				aMatricular.getAsignaturas().addAll(asignaturas);
				gestionarDuplicados(aMatricular.getAsignaturas());
				mostrarListaAsignaturas(aMatricular.getAsignaturas());
			}
		} else {
			System.out.println("Orden no ejecutada");
		}
	}

	/**
	 * Pre:--- 
	 * Post: metodo que recibe como parametro una lista de objetos asignatura
	 * 		 y se encarga de eliminar los duplicados de la lista.
	 */
	public static void gestionarDuplicados(ArrayList<Asignatura> lista) {
		for(int i = 0; i < lista.size(); i++) {
			for (int j = 0; j < lista.size(); j++) {
				if(lista.get(i).getCodAsig() == lista.get(j).getCodAsig() && i != j) {
					lista.remove(i);
				}
			}
		}
	}

	/**
	 * Pre:--- 
	 	 * Post: metodo que recible como parametros una lista de alumnos y una tabla con un codigo
	 * 		 entonces recorre la tabla, agregando a la lista todas aquellos alumnos las cuales
	 * 		 coincidan con el codigo enviado.
	 */
	public static ArrayList<Alumno> recopilarAlumnos(ArrayList<Alumno> listaAlumnos, int codigo) {
		ArrayList<Alumno> lista = new ArrayList<>();
		for(int i = 0; i < listaAlumnos.size(); i++) {
			Alumno aComprobar = comprobarAlumno(listaAlumnos.get(i), codigo);
			if(aComprobar != null) {
				lista.add(aComprobar);
			}
		}
		return lista;
	}

	/**
	 * Pre:---
	 * Post: metodo que recible como parametros una lista de asignaturas y una tabla con un codigo
	 * 		 entonces recorre la tabla, agregando a la lista todas aquellas asignaturas las cuales
	 * 		 coincidan con el codigo enviado.
	 */
	public static ArrayList<Asignatura> recopilarAsignaturas(ArrayList<Asignatura> listaAsignaturas, String[] codigo) {
		ArrayList<Asignatura> lista = new ArrayList<>();
		for(int i = 2; i < codigo.length; i++) {
			Asignatura nueva = devolverAsignatura(listaAsignaturas, Integer.parseInt(codigo[i]));
			if(nueva != null) {
				lista.add(nueva);
			}
		}
		return lista;
	}

	/**
	 * Pre:--- 
	 * Post: metodo que recibe como parametro un objeto alumno y un codigo,
	 * 		 se encarga de revisar en la lista de asignaturas del alumno si
	 * 	 	 alguna asignatura coincide con el codigo enviado, y si es asi
	 * 		 devuelve el alumno sino devuelve null.
	 */
	public static Alumno comprobarAlumno(Alumno n, int codigo) {
		for(int i = 0; i < n.getAsignaturas().size(); i++) {
			if(n.getAsignaturas().get(i).getCodAsig() == codigo) {
				return n;
			}
		}
		return null;
	}

	/**
	 * Pre:--- 
	 * Post: metodo que pide por pantalla al usuario los datos necesarios
	 * 		 para la seleccion del menu. Devielve una tabla de String
	 */
	public static String[] pedirOrden(Scanner n) {
		System.out.print("Orden -> ");
		String pregunta = n.nextLine().trim().toLowerCase();
		String[] orden = pregunta.split(" ");
		return orden;
	}

	/**
	 * Pre:--- 
	 * Post: metodo que recibe como parametros tres ArrayList, uno de alumnos otro de
	 * 		 asignaturas y otro de matriculas. Se encarga de añadir a los alumnos todas
	 * 		 las asignaturas en las cuales tienen matricula segun el fichero .csv
	 */
	public static void juntarInformacion(ArrayList<Alumno> listaAlumnos, ArrayList<Asignatura> listaAsignaturas,
			ArrayList<Matricula> matriculas) {
		for(int i = 0; i < matriculas.size(); i++) {
			Alumno alumno = devolverAlumno(listaAlumnos, matriculas.get(i).getCodAlumno());
			Asignatura asignatura = devolverAsignatura(listaAsignaturas, matriculas.get(i).getCodAsig());
			alumno.getAsignaturas().add(asignatura);
		}
	}

	/**
	 * Pre:--- 
	 * Post: metodo que recibe un ArrayList de alumnos y un codigo, se encarga de buscar
	 * 		 en la lista de alumnos un alumno que coincida con el nip enviado y lo devuelve,
	 * 		 si el nip no coincide devuelve null.
	 */
	public static Alumno devolverAlumno(ArrayList<Alumno> lista, int nip) {
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getNip() == nip) {
				return lista.get(i);
			}
		}
		return null;
	}

	/**
	 * Pre:--- 
	 * Post: metodo que recibe un ArrayList de asignaturas y un codigo, se encarga de buscar
	 * 		 en la lista de asignaturas una asignatura que coincida con el codigo enviado y
	 * 		 la devuelve, si el codigo no coincide devuelve null.
	 */
	public static Asignatura devolverAsignatura(ArrayList<Asignatura> lista, int codAsig) {
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getCodAsig() == codAsig) {
				return lista.get(i);
			}
		}
		return null;
	}

	/**
	 * Pre:--- 
	 * Post: metodo el cual recibe un ArrayList de alumnos y muestra por pantalla el contenido.
	 */
	public static void mostrarListaAlumnos(ArrayList<Alumno> n) {
		for(int i = 0; i < n.size(); i++) {
			System.out.println(n.get(i).toString());
		}
	}

	/**
	 * Pre:--- 
	 * Post: metodo el cual recibe un ArrayList de asignaturas y muestra por pantalla el contenido.
	 */
	public static void mostrarListaAsignaturas(ArrayList<Asignatura> n) {
		for(int i = 0; i < n.size(); i++) {
			System.out.println(n.get(i).toString());
		}
	}

	/**
	 * Pre:--- 
	 * Post: metodo que devuelve un Arraylist de Asignaturas, cuya informacion
	 * 		 recoge del fichero corresponiente.
	 */
	public static ArrayList<Asignatura> recogerAsignaturas() {
		ArrayList<Asignatura> listaAsignaturas = new ArrayList<>();
		File documento = new File(
				"C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\asignaturas.txt");
		try {
			Scanner n = new Scanner(documento);
			while(n.hasNextLine()) {
				String linea = n.nextLine();
				String[] info = linea.split(" ");
				String nombre = recogerNombre(info);
				Asignatura nueva = new Asignatura(Integer.parseInt(info[0]), info[1], info[2], info[3], nombre);
				listaAsignaturas.add(nueva);
			}
			n.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaAsignaturas;
	}

	/**
	 * Pre:--- 
	 * Post: metodo que recibe como parametro una tabla de string la cual
	 * 		 contiene la informacion de cada asignatura, crea una variable a la que
	 * 		 concatenara el nombre a partir de una posicion de la tabla, y devuelve el
	 * 		 nombre.
	 */
	public static String recogerNombre(String[] info) {
		String nombre = "";
		for(int i = 4; i < info.length; i++) {
			nombre += info[i] + " ";
		}
		return nombre;
	}

	/**
	 * Pre:--- 
	 * Post: metodo que devuelve un Arraylist de alumnos, cuya informacion
	 * 		 recoge del fichero .csv corresponiente.
	 */
	public static ArrayList<Alumno> recogerAlumnos() {
		ArrayList<Alumno> listaAlumnos = new ArrayList<>();
		File documento = new File("C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\alumnos.csv");
		try {
			Scanner n = new Scanner(documento);
			n.nextLine();
			while(n.hasNextLine()) {
				String linea = n.nextLine();
				String[] palabras = linea.split(";");
				Alumno nuevo = new Alumno(Integer.parseInt(palabras[0]), palabras[2], palabras[1]);
				listaAlumnos.add(nuevo);
			}
			n.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaAlumnos;
	}

	/**
	 * Pre:--- 
	 * Post: metodo que lee el fichero .dat que contiene la informacion de las matriculas
	 * 		 de cada alumno y guarda la informacion en un ArrayList que almacena objetos
	 * 		 de tipo Matricula.
	 */
	public static ArrayList<Matricula> recogerMatricula() {
		ArrayList<Matricula> listaMatriculas = new ArrayList<>();
		try {
			DataInputStream documento = new DataInputStream(new FileInputStream(
					"C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\matriculas.dat"));
			try {
				while(true) {
					Matricula nueva = new Matricula(documento.readInt(), documento.readInt());
					listaMatriculas.add(nueva);
				}
			} catch(IOException e) {}
			documento.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return listaMatriculas;
	}

	/**
	 * Pre:--- 
	 * Post: metodo que recibe como parametro un ArrayList de objetos matricula
	 * 		 y escribe el documento .dat donde almacenamos todas las matriculas
	 * 		 de los alumnos.
	 */
	public static void modificarDat(ArrayList<Matricula> lista) {
		try {
			DataOutputStream documento = new DataOutputStream(new FileOutputStream(
					"C:\\Users\\Adri\\OneDrive\\Documentos\\Clase\\Programacion\\ficheros\\matriculas.dat"));
			for(int i = 0; i < lista.size(); i++) {
				try {
					documento.writeInt(lista.get(i).getCodAlumno());
					documento.writeInt(lista.get(i).getCodAsig());
				} catch(IOException e) {
					System.out.println("Error al escribir en el fichero");
				}
			}
			documento.close();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Pre:--- 
	 * Post: metodo el cual muestra al usuario el menu con sus opciones
	 */
	public static void menu() {
		System.out.println("-> Matriculas");
		System.out.println("-> Asignaturas nip [A | C]");
		System.out.println("-> Alumnos codigo [A | N]");
		System.out.println("-> Eliminar nip { codigo }");
		System.out.println("-> Matricular nip codigo { codigo }");
		System.out.println("-> Guardar");
		System.out.println("-> Salir");
	}
}
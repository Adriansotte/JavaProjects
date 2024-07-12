package practica1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Clase cliente la cual hace el rol de Cliente, el cual manda peticiones al servidor. 
 */
public class Cliente extends Conexion {
    
	private Scanner entrada;
	private ArrayList<String> ordenes;
	private int numPlazas;
	
	public Cliente() throws IOException {
    	super("cliente");
    }

    public void startClient() {
        try {
        	numPlazas = 0;
        	DataInputStream in = new DataInputStream(cs.getInputStream());
            DataOutputStream out = new DataOutputStream(cs.getOutputStream());
            String mensaje = in.readUTF();
            System.out.println(mensaje);
            ordenes = rellenarOrdenes();
            entrada = new Scanner(System.in);
            String nombre = "Adrian";
            out.writeUTF(nombre);
            while(true) {
            	String cadena = pedirOrden("Para reservar escribe un mensaje con el formato: \"RESERVAR:2C\" ");
            	out.writeUTF(cadena);
            	String estadoPlaza = in.readUTF();
            	System.out.println(estadoPlaza);
            	if(estadoPlaza.substring(0, 9).equalsIgnoreCase("RESERVADA")) {
            		numPlazas++;
            	}
            	String comprobacionPlazas = in.readUTF();
            	if(comprobacionPlazas.equalsIgnoreCase("VUELO COMPLETO.")) {
            		System.out.println("Plazas reservadas => " + numPlazas);
            		break;
            	} else {
            		System.out.println(comprobacionPlazas);
            	}
            }
            cs.close();
        } catch (Exception e) {
            System.out.println("hola");
        	System.out.println(e.getMessage());
        }
    }
    
    /**
     * Pre:---
     * Post: metodo el cual pide un mensaje al usuario por consola, este mensaje sera
     * 		 revisado en metodos posteriores, garantizando un mensaje adecuado para mandar
     * 		 al servidor.
     */
    public String pedirOrden(String mensaje) {
    	while(true) {
    		System.out.println(mensaje);
    		String pregunta = entrada.nextLine();
    		if(comprobaciones(pregunta)) {
    			return pregunta.substring(pregunta.length() - 2, pregunta.length()).toUpperCase();
    		} else {
    			System.out.println("El formato de la solicitud no es valido");
    		}
    		
    	}
    }
    
    /**
     * Pre:---
     * Post: metodo que gestiona el mensaje del usuario, para poder enviarlo al servidor de manera
     * 		 correcta y eficiente.
     */
    public Boolean comprobaciones(String mensaje) {
    	String[] division = mensaje.split(":");
    	if(division.length != 2) {
    		System.out.println("No es del tamaño adecuado");
    		return false;
    	} else if(!division[0].toUpperCase().equalsIgnoreCase("RESERVAR")) {
    		System.out.println("No pasa las segundas pruebas");
    		System.out.println(division[0] + " " + division[1]);
    		return false;
    	} else if(comprobarOrdenes(division[1]) == false) {
    		System.out.println("No pasa las terceras pruebas" );
    		System.out.println(division[0] + " " + division[1]);
    		return false;
    	} else {
    		return true;
    	}
    }
    
    /**
     * Pre:---
     * Post: Metodo que comprueba el parametro recibido, si coincide con algun
     * 		 codigo de la lista, devuelve true, sino devuelve false.
     */
    public Boolean comprobarOrdenes(String orden) {
    	for(int i = 0; i < ordenes.size(); i++) {
    		if(orden.equalsIgnoreCase(ordenes.get(i))) {
    			return true;
    		}
    	}
    	return false;
    }
    
    /**
     * Pre:---
     * Post: metodo que rellena el array de asionetos, poniendo los codigos de 
     * 		 cada asiento.
     */
    public ArrayList<String> rellenarOrdenes() {
    	ArrayList<String> tabla = new ArrayList<>();
    	tabla.add("1A");
    	tabla.add("1B");
    	tabla.add("1C");
    	tabla.add("1D");
    	tabla.add("2A");
    	tabla.add("2B");
    	tabla.add("2C");
    	tabla.add("2D");
    	tabla.add("3A");
    	tabla.add("3B");
    	tabla.add("3C");
    	tabla.add("3D");
    	tabla.add("4A");
    	tabla.add("4B");
    	tabla.add("4C");
    	tabla.add("4D");
    	return tabla;
    }
}

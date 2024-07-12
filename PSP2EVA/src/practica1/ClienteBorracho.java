package practica1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Clase cliente la cual se utiliza para comprobarl el correcto funcionamiento
 * de los semaforos implementados en el programa, haciendo que se pongan a prueba
 * las funcionalidades de reservar asiento.
 */
public class ClienteBorracho extends Conexion {
    
	private ArrayList<String> ordenes;
	private int numPlazas;
	private Random random;
	
	public ClienteBorracho() throws IOException {
    	super("cliente");
    }

    public void startClient() {
        try {
        	random = new Random();
        	numPlazas = 0;
        	DataInputStream in = new DataInputStream(cs.getInputStream());
            DataOutputStream out = new DataOutputStream(cs.getOutputStream());
            String mensaje = in.readUTF();
            System.out.println(mensaje);
            ordenes = rellenarOrdenes();
            String nombre = "Borracho";
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
        	System.out.println(e.getMessage());
        }
    }
    
    /**
     * Pre:---
     * Post: metodo que devuelve un codigo aleatorio del Array de codigos.
     */
    public String pedirOrden(String mensaje) {
    	return ordenes.get(random.nextInt(ordenes.size()));
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

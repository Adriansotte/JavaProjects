package Final.Cliente;

import Final.ConexionCL;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends ConexionCL {

    private Scanner entrada;
    private ArrayList<String> opciones;

    public Cliente() throws IOException {
        super("cliente");
    }

    public void startClient() {//Método para iniciar el cliente
        try {
            // Canal para recibir mensajes (entrada)
            DataInputStream in = new DataInputStream(cs.getInputStream());
            // Canal para enviar mensajes (salida)
            DataOutputStream out = new DataOutputStream(cs.getOutputStream());

            entrada = new Scanner(System.in);
            opciones = prepararOpciones();

            while(true) {
                // Mensaje recebido del servidor 1
                String mensaje = in.readUTF();
                System.out.println(mensaje);
                if(mensaje.equalsIgnoreCase("FIN")) {
                  break;
                }
                // Mensaje enviado al servidor 2
                String orden = recogerMensaje();
                out.writeUTF(orden);
                System.out.println("Se va a recibir el mensaje");
                String mensajeAccion = in.readUTF();
                System.out.println(mensajeAccion);
            }
            cs.close();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String recogerMensaje() {
        while (true) {
            String mensaje = entrada.nextLine().replaceAll("[“”\"\\[\\]]", "").replaceFirst("([^\\s]+)", "$1,");
            String[] mensajePreparado = mensaje.split(",");
            boolean comprobaciones = comprobaciones(mensajePreparado);
            if (comprobaciones) {
                return mensaje;
            } else {
                System.out.println("Mensaje no comprendido");
            }
        }
    }

    public boolean comprobaciones(String[] mensajePreparado) {
        if (mensajePreparado.length < 2 || mensajePreparado.length > 7) {
            return false;
        }
        if (comprobarOpcion(mensajePreparado[0]) == false) {
            return false;
        }
        return true;
    }

    /**
     * Pre:---
     * Post: metodo que comprueba si el primer mensaje del usuario
     * 		 corresponde con alguno de las opciones que tiene el programa para hacer.
     */
    public boolean comprobarOpcion(String opcion) {
        for (int i = 0; i < this.opciones.size(); i++) {
            if (opcion.equalsIgnoreCase(opciones.get(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * Pre: ---
     * Post: metodo que crea las opciones para el usuario
     */
    public ArrayList<String> prepararOpciones() {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("PostNote");
        lista.add("PN");
        lista.add("RemoveNote");
        lista.add("RN");
        lista.add("ReadNote");
        lista.add("ReadN");
        return lista;
    }
}
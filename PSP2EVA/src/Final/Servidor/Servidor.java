package Final.Servidor;

import Final.ConexionServidor;

import java.io.IOException;
import java.net.Socket;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.TreeMap;

public class Servidor extends ConexionServidor { //Se hereda de conexión para hacer uso de los sockets y demás

    public ShareDataServidor1 baseDeDatos;

    public Servidor() throws IOException {
        super("servidor");
    }

    public void startServer() {
        try {
            baseDeDatos = new ShareDataServidor1();
            System.out.println("Servidor para tuplas de tamaño 1 a 3 esperando...");
            while (true) {
                System.out.println("Esperando...");
                cs = ss.accept();
                System.out.println("Cliente en línea");

                DataInputStream in = new DataInputStream(cs.getInputStream());
                DataOutputStream out = new DataOutputStream(cs.getOutputStream());

                ThreadServidor1 nuevo = new ThreadServidor1(in, out, cs, baseDeDatos);
                nuevo.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
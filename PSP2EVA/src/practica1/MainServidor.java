package practica1;

import java.io.IOException;

/**
 * Clase principal que hará uso del servidor
 */
public class MainServidor {
  public static void main(String[] args) throws IOException {
      Servidor serv = new Servidor();
      System.out.println("Iniciando servidor\n");
      serv.startServer();
  }
}
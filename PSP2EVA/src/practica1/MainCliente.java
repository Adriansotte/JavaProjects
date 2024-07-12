package practica1;

import java.io.IOException;

/**
 * Clase que crea un cliente para comunicarlo con el servidor.
 */
public class MainCliente {
  public static void main(String[] args) throws IOException {
      Cliente cli = new Cliente();
      System.out.println("Iniciando cliente\n");
      cli.startClient();
  }
}
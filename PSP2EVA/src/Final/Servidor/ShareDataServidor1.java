package Final.Servidor;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class ShareDataServidor1 {

    public ArrayList<String[]> informacion;
    public Semaphore borrar;
    public Semaphore leer;
    public Semaphore insertar;

    public ArrayList<String[]> getInformacion() {
        return informacion;
    }

    public void setInformacion(ArrayList<String[]> informacion) {
        this.informacion = informacion;
    }

    public ShareDataServidor1(ArrayList<String[]> informacion) {
        this.informacion = informacion;
    }

    public ShareDataServidor1() {
        this.informacion = new ArrayList<>();
        this.borrar = new Semaphore(1);
        this.leer = new Semaphore(0);
        this.insertar = new Semaphore(1);
        insertarDatos();
    }

    public void insertarDatos() {
        informacion.add(new String[] {"Juan", "25", "Hola Mundo"});
        informacion.add(new String[] {"María", "Saludos"});
        informacion.add(new String[] {"Carlos"});
        informacion.add(new String[] {"Ana", "10"});
        informacion.add(new String[] {"Luis", "4", "Hola, ¿cómo estás?"});
        informacion.add(new String[] {"Laura", "8", "Hola desde Java"});
        informacion.add(new String[] {"Roberto", "Bienvenido"});
    }

    /**
     * Pre:---
     * Post:
     */
    public boolean comprobarParecidos(String[] enviada, String[] almacenada) {
        for(int i = 0; i < enviada.length; i++) {
            if(!enviada[i].contains("?")) {
                if(!enviada[i].equalsIgnoreCase(almacenada[i])) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Pre:---
     * Post:
     */
    public boolean insertarTupla(String[] tupla) {
        try {
            accionAtomicaEleccion(1);
            informacion.add(tupla);
            insertar.release();
            return true;
        } catch(Exception e ) {
            return false;
        }
    }

    /**
     * Pre:---
     * Post:
     */
    public String[] buscarTupla(String[] tupla) {
        try {
            accionAtomicaEleccion(0);
            if(tupla == null) {
                return null;
            }
            for(int i = 0; i < informacion.size(); i++) {
                if(tupla.length == informacion.get(i).length) {
                    boolean comprobacion = comprobarParecidos(tupla, informacion.get(i));
                    // Aqui se empieza a comprobar las tuplas
                    if(comprobacion) {
                        leer.acquire();
                        return informacion.get(i);
                    }
                }
            }
            leer.acquire();

            return null;
        } catch(Exception e) {
            return null;
        }
    }


    /**
     * Pre:---
     * Post:
     */
    public String[] eliminarNota(String[] tupla) {
        try{
            accionAtomicaEleccion(2);
            int indice = buscarParaEliminar(tupla);
            if(indice >= 0) {
                String[] tuplaEliminada = informacion.get(indice);
                informacion.remove(indice);
                return tuplaEliminada;
            } else {
                System.out.println("No se ha encontrado la tupla");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            borrar.release();
        }
    }

    public synchronized void accionAtomicaEleccion(int eleccion) throws InterruptedException {
        if(eleccion == 0) {
            while(borrar.availablePermits() == 0) { }
            leer.release();
        } else if(eleccion == 1) {
            while(borrar.availablePermits() == 0) { }
            try {
                insertar.acquire();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            //while(borrar.availablePermits() == 0) { }
            borrar.acquire();
        }
    }

    /**
     * Pre:---
     * Post:
     */
    public int buscarParaEliminar(String[] tupla) {
        try {

            for(int i = 0; i < informacion.size(); i++) {
                if(tupla.length == informacion.get(i).length) {
                    boolean comprobacion = comprobarParecidos(tupla, informacion.get(i));
                    // Aqui se empieza a comprobar las tuplas
                    if(comprobacion) {
                        return i;
                    }
                }
            }
            return -1;
        } catch(Exception e) {
            return -1;
        }
    }

    /**
     * Pre:---
     * Post:
     */
//	public String[] recogerNota(String[] tupla) {
//		try {
//			portero.acquire();
//			int indice = buscarTupla(tupla);
//			System.out.println("Es el indice de la tupla" + indice);
//			if(indice >= 0) {
//				return informacion.get(indice);
//			} else {
//				return null;
//			}
//		} catch(Exception e) {
//			System.out.println(e);
//			return null;
//		} finally {
//			portero.release();
//		}
//	}
}
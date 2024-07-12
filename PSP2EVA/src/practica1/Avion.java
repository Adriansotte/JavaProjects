package practica1;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Semaphore;

/**
 * Clase la cual simula un avion y sus plazas, permitirá al usuario reservar las plazas
 * mediante metodos internos. Contiene semaforos ya que varios threads podran trabajar
 * sobre esta clase.
 */
public class Avion {

	public TreeMap<String, String> asientos;
	public Semaphore s1;
	public Semaphore portero;
	
	public TreeMap<String, String> getAsientos() {
		return asientos;
	}

	public void setAsientos(TreeMap<String, String> asientos) {
		this.asientos = asientos;
	}

	public Avion() {
		this.asientos = rellenarAvion();
		this.s1 = new Semaphore(1);
		this.portero = new Semaphore(1);
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual, mediante el mensaje recibido como parametro
	 * 		 busca en el TreeMap y verifica el valor que tiene asignado.
	 * 		 Si es  X devuelve false, sino devuelve true
	 */
	public boolean reservarAsiento(String orden) {
		try {
			portero.acquire();
			s1.acquire();
			String estado = asientos.get(orden);
			if(estado.equalsIgnoreCase("X")) {
				portero.release();
				s1.release();
				return false;
			} else {
				asientos.put(orden, "X");
				portero.release();
				s1.release();
				return true;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual rellena el TreeMap con los keys de los asientos,
	 * 	     y su valor, el cual puede ser ocupado (X) o libre (L)
	 */
	public TreeMap<String, String> rellenarAvion() {
		TreeMap<String, String> plazas = new TreeMap<>();
		plazas.put("1A", "L");
		plazas.put("1B", "L");
		plazas.put("1C", "L");
		plazas.put("1D", "L");
		plazas.put("2A", "L");
		plazas.put("2B", "L");
		plazas.put("2C", "L");
		plazas.put("2D", "L");
		plazas.put("3A", "L");
		plazas.put("3B", "L");
		plazas.put("3C", "L");
		plazas.put("3D", "L");
		plazas.put("4A", "L");
		plazas.put("4B", "L");
		plazas.put("4C", "L");
		plazas.put("4D", "L");
		return plazas;
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual muestra los valores de las keys del treemap, asi da 
	 * 		 informacion al usuario sobre los asientos que quedan libres y cuales
	 * 		 estan ocupados.
	 */
	public String mostrarPlazas() {
		try {
			portero.acquire();
			String plazas = "";
			int cont = 1;
			for(Map.Entry<String, String> asiento : asientos.entrySet()) {
				plazas += asiento.getValue();
				if(cont % 4 == 0 && cont != 16) {
					plazas += "-";
				}
				cont++;
			}
			portero.release();
			return plazas;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	/**
	 * Pre:---
	 * Post: metodo el cual recorre el TreeMap y revisa todos los valores de las keys,
	 * 		 si alguno tiene valor "L" devuelve true, si tras completar el bucle no 
	 * 		 encuentra ninguna, devuelve false.
	 */
	public boolean comprobarPlazas() {
		try {
			portero.acquire();
			for(Map.Entry<String, String> asiento : asientos.entrySet()) {
				if(asiento.getValue().equalsIgnoreCase("L")) {
					portero.release();
					return true;
				}
			}
			portero.release();
			return false;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return false;
		}
	}
}
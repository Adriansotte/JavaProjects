package examen2EVA;

/**
 * Clase que se utiliza para otorgar funcionalidades a las demas
 * clases, contiene sus atributos, junto con la vida que regeneran 
 * o el mana que regenera.
 */
public class Pocion {

	protected String nombre;
	protected int manaRegenera;
	protected int vidaRegenera;
	
	public Pocion(String nombre, int manaRegenera, int vidaRegenera) {
		this.nombre = nombre;
		this.manaRegenera = manaRegenera;
		this.vidaRegenera = vidaRegenera;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getManaRegenera() {
		return manaRegenera;
	}
	public void setManaRegenera(int manaRegenera) {
		this.manaRegenera = manaRegenera;
	}
	public int getVidaRegenera() {
		return vidaRegenera;
	}
	public void setVidaRegenera(int vidaRegenera) {
		this.vidaRegenera = vidaRegenera;
	}
	
	@Override
	public String toString() {
		return "Esta pocion se llama: " + this.nombre + " Regenera puntos de salud: " + this.vidaRegenera +
				" Regenera puntos de mana: " + this.manaRegenera;
	}
	
	
}

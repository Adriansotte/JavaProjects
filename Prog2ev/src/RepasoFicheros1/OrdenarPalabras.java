package RepasoFicheros1;

import java.util.Comparator;

public class OrdenarPalabras implements Comparator<Par>{
	
	
	// esto lo ordena alfabeticamente
	@Override
	public int compare(Par o1, Par o2) {
		if(o1.getPalabra().compareTo(o2.getPalabra()) < 0 ) {
			return -1;
		} else if(o1.getPalabra().compareTo(o2.getPalabra()) == 0) {
			return 0;
		} else {
			return 1;
		}
	}

}

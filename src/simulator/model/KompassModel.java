package simulator.model;

import java.util.Observable;

/**
 * Ein Model bildet im MVC die Logik ab.
 * <p>
 * Es erweitert einfach nur die Klasse {@link java.util.Observable}. Alle Daten, die von einer View
 * angezeigt werden können werden hier zur Verfügung gestellt. Ausserdem übernimmt ein Model die
 * Validierung von Daten. Gegebenfalls können die Daten ebenfalls vorher vom Controller validiert
 * werden.
 * 
 * @author Nico Hanisch
 * @version 1.0
 */
public class KompassModel extends Observable {
	private int steuerkurs;
	private int kompasskurs;
	
	public KompassModel() {
		// Optional: Initialisierung hier, kann aber auch vom Controller übernommen werden
	}
	
	public int getSteuerkurs() {
		return steuerkurs;
	}
	
	public void setSteuerkurs(int steuerkurs) {
		if (steuerkurs >= 0 && steuerkurs <= 360) {
			this.steuerkurs = steuerkurs;
			setChanged();
			notifyObservers();
		}
	}
	
	public int getKompasskurs() {
		return kompasskurs;
	}
	
	public void setKompasskurs(int kompasskurs) {
		if (kompasskurs >= 0 && kompasskurs <= 360) {
			this.kompasskurs = kompasskurs;
			setChanged();
			notifyObservers();
		}
	}
}

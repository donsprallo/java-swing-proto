package simulator.model;

import java.util.Observable;

public class KompassModel extends Observable {
	private int steuerkurs;
	private int kompasskurs;
	
	public KompassModel() {
		// Optional: Initialisierung hier
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

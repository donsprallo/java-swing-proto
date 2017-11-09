package simulator.model;

/**
 * Ein Model bildet im MVC die Logik ab.
 * <p>
 * Erweitert die Klasse {@link simulator.model.ModelBase}. Alle Daten für die Views werden hier zur
 * Verfügung gestellt. Ausserdem übernimmt ein Model die Validierung von Daten. Gegebenfalls können
 * die Daten ebenfalls vorher vom Controller validiert werden. Eine View darf nur die Getter-Methoden
 * verwenden.
 * 
 * @author Nico Hanisch
 * @version 1.0
 */
@SuppressWarnings("serial")
public class SimulatorModel
extends ModelBase {
	
	private int steuerkurs;
	private int kompasskurs;
	
	public SimulatorModel() {
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
	
	/**
	 * Kopiert alle Attribute eines übergebenen Models in das Objekt.
	 * <p>
	 * Diese Hilfsmethode dient dazu, die Werte des Models aus einem anderen Model zu übernehmen. Beim
	 * Laden eines SimulatorModel-Objekts gehen sonst die Referenzen der Beobachter verloren.
	 * <p>
	 * Beispiel:
	 * <p>
	 * {@code SimulatorModel model = new SimulatorModel();}
	 * <p>
	 * {@code OutputStream os = new FileOutputStream("test.txt");}<br>
	 * {@code SimulatorModel.serialize(model, os);}
	 * <p> ... Änderung von Daten ... <p>
	 * {@code InputStream is = new FileInputStream("test.txt");} <br>
	 * {@code model.copy(SimulatorModel.deserialize(is));}}
	 * 
	 * @param copy Das {@link simulator.model.SimulatorModel}-Objekt, dessen Attribute kopiert werden sollen.
	 */
	public void copy(SimulatorModel copy) {
		setKompasskurs(copy.getKompasskurs());
		setSteuerkurs(copy.getSteuerkurs());
	}
}

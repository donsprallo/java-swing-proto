package simulator;

import simulator.controller.KompassControllerInterface;
import simulator.model.KompassModel;

/**
 * Stellt eine Minimalversion einer View dar.
 * <p>
 * Die ViewBase kann z.B. für eine kommandozeilenbasierte Version als Basis verwendet werden.
 * Das {@link simulator.ViewInterface ViewInterface} wird implementiert und stellt damit Methoden
 * für den Zugriff auf das Model und den Controller zur Verfügung.
 * 
 * @author Nico Hanisch
 * @version 1.0
 */
public abstract class ViewBase
implements ViewInterface {
	
	private KompassModel model;
	private KompassControllerInterface controller;
	
	/**
	 * Der Konstruktor für die Klasse.
	 * <p>
	 * Er koppelt die View mit einem Model und einem Controller. Damit registriert sich die View zur
	 * Beobachtung von Datenänderungen beim Model. Der Controller steuert, wie auf Aktionen vom Benutzer
	 * reagiert werden soll. Die View selbst weiß nichts darüber, wie sie sich zu verhalten hat. Sie
	 * ist nur für die Anzeige der Daten verantwortlich. Kommandos bzw. Ereignisse werden an den
	 * Controller übergeben.
	 * 
	 * @param model Das Model, auf dem sich zur Beobachtung registriert werden soll.
	 * @param controller Der Controller zur Steuerung der Benutzeraktionen.
	 */
	public ViewBase(KompassModel model, KompassControllerInterface controller) {
		this.model = model;
		this.controller = controller;
		
		model.addObserver(this);
		controller.addView(this);
	}
	
	public KompassModel getModel() {
		return model;
	}
	
	public KompassControllerInterface getController() {
		return controller;
	}
	
	/**
	 * Diese Methode ist nur als Beispiel gedacht. Sie sollte noch aus der ViewBase-Klasse verschwinden.
	 * @param kurskorrektur
	 */
	public abstract void showKurskorrektur(int kurskorrektur);
}

package simulator.view;

import simulator.controller.ControllerInterface;
import simulator.model.SimulatorModel;

/**
 * Stellt eine Minimalversion einer View dar.
 * <p>
 * Die ViewBase kann z.B. für eine kommandozeilenbasierte Version als Basis verwendet werden.
 * Das {@link simulator.view.ViewInterface ViewInterface} wird implementiert und stellt damit Methoden
 * für den Zugriff auf das Model und den Controller zur Verfügung.
 * 
 * @author Nico Hanisch
 * @version 1.0
 */
public abstract class ViewCmdLineBase
implements ViewInterface {
	
	private SimulatorModel model;
	private ControllerInterface controller;
	
	/**
	 * Der Konstruktor für die Klasse.
	 * <p>
	 * Er koppelt die View mit einem Model und einem Controller. Damit registriert sich die View zur
	 * Beobachtung von Datenänderungen beim Model. Der Controller steuert, wie auf Aktionen vom Benutzer
	 * reagiert werden soll. Die View selbst weiß nichts darüber, wie sie sich zu verhalten hat. Sie
	 * ist nur für die Anzeige der Daten verantwortlich. Kommandos bzw. Ereignisse werden an den
	 * Controller übergeben.
	 * <p>
	 * Die ableitende Klasse muss die Methode {@link java.util.Observer#update(java.util.Observable, Object)
	 * update(Observable, Object)} entsprechend überschreiben um über Änderungen im Model benachrichtigt zu
	 * werden. Die veränderten Eigenschaften müssen in der Methode selbst über
	 * {@link simulator.view.ViewUIComponentBase#getModel() getModel()} und den Getter-Methoden abgefragt werden.
	 * 
	 * @param model Das Model, auf dem sich zur Beobachtung registriert werden soll.
	 * @param controller Der Controller zur Steuerung der Benutzeraktionen.
	 */
	public ViewCmdLineBase(SimulatorModel model, ControllerInterface controller) {
		this.model = model;
		this.controller = controller;
		
		model.addObserver(this);
		controller.addView(this);
	}
	
	public SimulatorModel getModel() {
		return model;
	}
	
	public ControllerInterface getController() {
		return controller;
	}
	
	/**
	 * Diese Methode ist nur als Beispiel gedacht. Sie sollte noch aus der ViewBase-Klasse verschwinden.
	 * @param kurskorrektur
	 */
	public abstract void showKurskorrektur(int kurskorrektur);
}

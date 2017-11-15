package simulator.view;

import java.util.Observable;

import simulator.controller.ControllerInterface;
import simulator.model.SimulatorModel;

/**
 * Eine Beispiel-Klasse für eine View ohne GUI.
 * <p>
 * Erbt von {@link simulator.simulator.view.ViewCmdLineBase} und überschreibt die Methoden
 * {@code update(Observable, Object)} und {@code showKurskorrektur(int)}. Am wichtigsten ist die
 * update-Methode, in der die View über Datenänderungen am Model informiert wird. Die Daten selbst
 * werden über Getter-Methoden vom Model abgefragt.
 * 
 * @author Nico Hanisch
 * @version 1.0
 */
public class CommandlineView extends ViewCmdLineBase {
	
	/**
	 * Der Konstruktor leitet die übergebenen Argumente an die Basis-Klasse weiter.
	 * 
	 * @param model Das {@link simulator.model.SimulatorModel}-Objekt, auf dem sich die View registriert.
	 * @param controller Das zu verbindende {@link simulator.controller.ControllerInterface}-Objekt.
	 */
	public CommandlineView(SimulatorModel model, ControllerInterface controller) {
		super(model, controller);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// erzeugt auf der Konsole eine Ausgabe der Daten vom Model
		System.out.println("---");
		System.out.println("Steuerkurs: " + getModel().getSteuerkurs());
		System.out.println("Aktueller Kurs: " + getModel().getKompasskurs());
		System.out.println("---");
	}

	@Override
	public void showKurskorrektur(int kurskorrektur) {
		System.out.println("Steuerkurs-Korrekturanfrage: " + kurskorrektur + " Grad");
	}

}

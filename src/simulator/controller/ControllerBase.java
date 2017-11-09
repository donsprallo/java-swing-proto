package simulator.controller;

import java.util.ArrayList;
import java.util.Objects;

import simulator.ViewInterface;
import simulator.model.SimulatorModel;

/**
 * Eine einfache Controller-Klasse.
 * <p>
 * Ein Controller kann mehrere Views besitzen bzw. mehrere Views können sich auf einem Controller
 * registrieren. Dieser Controller übernimmt die Verarbeitung von Benutzereingaben und steuert damit
 * den Ablauf der Applikation. Nur dem Controller sind Operationen auf dem Model erlaubt. Ausserdem
 * kann er Daten, genau wie das Model selbst, validieren. Dafür kann der Controller zusätzlich,
 * z.B. bei falschen Daten, die View direkt beeinflussen.
 * <p>
 * Der {@link simulator.controller.ControllerBase} implementiert das
 * {@link simulator.controller.ControllerInterface} und bietet daher eine {@code addView(ViewInterface)}
 * -Methode.
 * 
 * @author Nico Hanisch
 * @version 1.0
 */
public abstract class ControllerBase
implements ControllerInterface {

	protected SimulatorModel model;
	protected ArrayList<ViewInterface> views;
	
	/**
	 * Konstruktor für ein {@link simulator.comtroller.ControllerBase}-Objekt.
	 * <p>
	 * Erstellt ein {@link simulator.controller.ControllerBase}-Objekt. Der Controller muss direkt
	 * mit einem {@link simulator.model.SimulatorModel} verbunden werden.
	 * @param model Ein {@link simulator.model.SimulatorModel}-Objekt.
	 */
	public ControllerBase(SimulatorModel model) {
		// Fehlerüberprüfung der Argumente
		Objects.requireNonNull(model, "model darf nicht null sein.");
		
		this.model = model;
		this.views = new ArrayList<ViewInterface>();
	}

	@Override
	public void addView(ViewInterface view) {
		views.add(view);
	}
	
	/**
	 * Erlaubt es dem Controller, das Model zu initialisieren.
	 */
	public abstract void initializeModel();
}

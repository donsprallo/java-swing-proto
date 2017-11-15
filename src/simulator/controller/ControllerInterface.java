package simulator.controller;

import java.awt.event.ActionListener;

import simulator.view.ViewInterface;

/**
 * Diese Schnittstelle ist der Grundstein für einen Controller.
 * <p>
 * Das Interface erweitert den {@link java.awt.event.ActionListener} um die Methode
 * {@link simulator.controller.ControllerInterface#addView(ViewInterface)}. Es erlaubt im MVC eine
 * lose Kopplung zwischen der View und dem Controller.
 * 
 * @author Nico Hanisch
 * @version 1.0
 */
public interface ControllerInterface extends ActionListener {
	/**
	 * Fügt dem Controller eine View hinzu.
	 * @param view Die hinzuzufügenden View.
	 */
	public void addView(ViewInterface view);
}

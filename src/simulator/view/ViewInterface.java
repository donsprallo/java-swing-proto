package simulator.view;

import java.util.Observer;

import simulator.controller.ControllerInterface;
import simulator.model.SimulatorModel;

/**
 * Dieses Interface stellt die minimalen Methoden für eine View dar.
 * <p>
 * Eine View muss diese Methoden unterstützen. Dieses Interface erweitert das
 * {@link java.util.Observer Observer}-Interface.
 * 
 * @author nico
 * @version 1.0
 */
public interface ViewInterface extends Observer {
	/**
	 * Gibt das Model, welches die View beobachtet, zurück.
	 * 
	 * @return Ein {@link simulator.model.SimulatorModel KompassModel}-Objekt.
	 */
	SimulatorModel getModel();
	
	/**
	 * Gibt den Controller der View zurück.
	 * 
	 * @return Ein {@link simulator.controller.ControllerInterface KompassControllerInterface}-Objekt.
	 */
	ControllerInterface getController();
}

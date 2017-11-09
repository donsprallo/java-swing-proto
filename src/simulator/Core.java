package simulator;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

import engine.CoreBase;
import engine.CoreEvent;
import simulator.controller.SimulatorController;
import simulator.model.SimulatorModel;
import simulator.view.CommandlineView;
import simulator.view.SteuerkursKompassView;
import simulator.view.SteuerkursView;

/**
 * Die konkrete Implementierung der Spiel-Engine.
 * <p>
 * Erweitert die abstrakte Klasse {@link engine.CoreBase} und implentiert die benötigten Funktionen
 * für die einfache Spiel-Engine. Sie basiert auf der grafischen GUI-Bibliothek Swing und verwendet
 * als Architektur das MVC-Muster (Model View Controller).
 * 
 * @author Nico Hanisch
 * @version 1.0
 */
public class Core
extends CoreBase {

	SimulatorModel model;
	SimulatorController controller;
	
	@Override
	protected CoreEvent pollEvent() {
		// Momentan werden keine Events abgefragt
		return null;
	}

	@Override
	protected boolean onInit() {
		try {
			// Das Hauptfenster erzeugen
			JFrame frame = new JFrame("Kompass GUI");
			frame.addWindowListener(new CloseListener());
			frame.setSize(200, 200);
			frame.setLocation(100, 100);
			frame.setVisible(true);
			
			// Verknüpfen der MVC-Komponenten
			model = new SimulatorModel();
			controller = new SimulatorController(model, frame);
			new CommandlineView(model, controller);
			new SteuerkursView(model, controller);
			new SteuerkursKompassView(model, controller);
			
			// Initialisierungen vornehmen
			controller.initializeModel();
			controller.showView(1);
			model.setKompasskurs(175);
			
			return true;
		}
		
		// Ausnahmebehandlung
		catch (Exception e) {  }
		finally { onCleanup(); }
		
		return false;
	}

	@Override
	protected void onEvent(CoreEvent e) {
		// Momentan werden keine Events abgefragt		
	}

	@Override
	protected void onUpdate() {
		// TODO Daten hier verändern (über Controller)
	}

	@Override
	protected void onRender() {
		// Macht nichts, da sich die Views bei Datenänderungen selbst neu zeichnen sollten
	}

	@Override
	protected void onCleanup() {
		// Macht nichts
	}
	
	/**
	 * Eine Nested-Class zum schliessen einer Anwendung.
	 * <p>
	 * Diese Klasse wird über {@code frame.addWindowListener(new CloseListener())} dem
	 * {@link javax.swing.JFrame JFrame} als {@link java.awt.event.WindowListener} hinzugefügt.
	 * Die Methode {@link java.awt.event.WindowAdapter#windowClosing(WindowEvent) windowClosing(WindowEvent)}
	 * wird beim schliessen des {@link javax.swing.JFrame JFrame} automatish ausgeführt.
	 * 
	 * @author Nico Hanisch
	 * @version 1.0
	 */
	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		}
	}
}

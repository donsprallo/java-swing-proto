package simulator.controller;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.util.Objects;

import javax.swing.JFrame;

import simulator.model.SimulatorModel;
import simulator.view.ViewInterface;
import simulator.view.ViewUIComponentBase;

/**
 * Diese Klasse erbt von {@link simulator.controller.ControllerBase}.
 * <p>
 * Erweitert die Klasse {@link simulator.controller.ControllerBase} für ein Swing basiertes
 * GUI-Interface. Sie ist zusätzlich für das Umschalten von Komponenten innerhalb eines
 * {@link javax.swing.JFrame} verantwortlich. Über die Methode {@code showView(int)}
 * kann zwischen einer anzuzeigenden View umgeschalten werden.
 * <p>
 * In der konkreten Klasse muss die Methode {@link java.awt.event.ActionListener#actionPerformed
 * (ActionEvent) actionPerformed(ActionEvent)} überschrieben werden. In dieser werden die
 * Ereignisse der View entgegengenommen und verarbeitet um z.B. Daten im Model zu ändern.
 * 
 * @author Nico Hanisch
 * @version 1.2
 */
public abstract class ControllerUIBase
extends ControllerBase {
	
	private Container contentPane;
	
	/**
	 * Konstruktor für ein {@link simulator.comtroller.ControllerUIBase}-Objekt.
	 * <p>
	 * Erstellt ein {@link simulator.controller.ControllerUIBase}-Objekt. Der Controller muss direkt
	 * mit einem {@link simulator.model.SimulatorModel} verbunden werden.
	 * @param model Ein {@link simulator.model.SimulatorModel}-Objekt.
	 * @param frame Ein {@link javax.swing.JFrame}-Objekt.
	 */
	public ControllerUIBase(SimulatorModel model, JFrame frame) {
		super(model);
		setFrame(frame);
	}
	
	/**
	 * Ermöglicht es, nachträglich das JFrame zu setzen.
	 * @param frame Das JFrame-Objekt zum umschalten zwischen den Views.
	 */
	public void setFrame(JFrame frame) {
		Objects.requireNonNull(frame, "frame darf nicht null sein.");
		this.contentPane = frame.getContentPane();
	}
	
	/**
	 * Wechselt die auf dem über {@link simulator.controller.ControllerBase#setFrame(JFrame)} anzuzeigende
	 * View.
	 * 
	 * @param index Der Index der View, die auf dem {@link javax.swing.JFrame} angezeigt werden soll.
	 */
	public void showView(int index) {		
		// Operation nur bei festgelegtem contentPane ausführen
		if (contentPane == null)
			return;
		
		// entfernt alle (anzeigbaren) Komponenten
		for(ViewInterface view : views) {
			if (view instanceof ViewUIComponentBase)
				contentPane.remove((ViewUIComponentBase)view);
		}
		
		// zeigt die (anzeigbare) View an
		if (views.get(index) instanceof ViewUIComponentBase)
			contentPane.add((ViewUIComponentBase)views.get(index));
		
		// ordnet ein neuzeichnen des Frames und dessen Komponenten an
		contentPane.validate();
		contentPane.repaint();
	}
}

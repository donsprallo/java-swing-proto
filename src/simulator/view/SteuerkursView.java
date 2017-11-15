package simulator.view;

import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JLabel;

import simulator.controller.SimulatorController;
import simulator.model.SimulatorModel;

/**
 * Eine Beispiel-Klasse für eine View mit GUI.
 * <p>
 * Erbt von {@link simulator.simulator.view.ViewUIComponentBase} und überschreibt die Methoden
 * {@code update(Observable, Object)}. In der update-Methode wird die View über Datenänderungen
 * am Model informiert. Die Daten selbst werden über Getter-Methoden vom Model abgefragt.
 * 
 * @author Nico Hanisch
 * @version 1.0
 */
@SuppressWarnings("serial")
public class SteuerkursView extends ViewUIComponentBase {
	
	JButton btnMinusFuenfGrad;
	JButton btnPlusFuenfGrad;
	JButton btnNextView;
	JButton btnSave;
	JButton btnLoad;
	JLabel lblSteuerkurs;
	JLabel lblKommentar;
	
	AbstractAction actSteuerkursPlus;
	AbstractAction actSteuerkursMinus;
	AbstractAction actNextView;
	
	/**
	 * Der Konstruktor leitet die übergebenen Argumente an die Basis-Klasse weiter.
	 * <p>
	 * Ausserdem wird im Konstruktor die Komponente selbst, mit allen seinen darzustellenden Elementen,
	 * erzeugt. Die Komponenten werden mit dem Controller über {@code Component.addActionListener(controller)}
	 * verbunden. Damit der Controller weiss, welches Kommando er ausführen muss, wird der Komponenten
	 * mittels {@code Component.setActionCommand(String)} ein Kommandoname vergeben.
	 * 
	 * @param model Das {@link simulator.model.SimulatorModel}-Objekt, auf dem sich die View registriert.
	 * @param controller Das zu verbindende {@link simulator.controller.ControllerInterface}-Objekt.
	 */
	public SteuerkursView(SimulatorModel model, SimulatorController controller) {
		super(model, controller);
		
		// einen Layout-Manager hinzufügen
		setLayout(new GridLayout(8, 1));
		
		// erstellt einen Button und koppelt den Controller
		// der Controller verarbeitet das Kommando namens "-5"
		// da die View selbst ein JFrame ist, kann der Button direkt mit add(Component) hinzugefügt werden
		actSteuerkursMinus = controller.new ChangeSteuerkursAction("-5 Grad", -5);
		btnMinusFuenfGrad = new JButton(actSteuerkursMinus);
		add("North", btnMinusFuenfGrad);
		
		// die folgenden Elemente werden äquivalent hinzugefügt
		lblSteuerkurs = new JLabel();
		lblSteuerkurs.setHorizontalAlignment(JLabel.CENTER);
		add(lblSteuerkurs);
		
		actSteuerkursPlus = controller.new ChangeSteuerkursAction("+5 Grad", 5);
		btnPlusFuenfGrad = new JButton(actSteuerkursPlus);
		add(btnPlusFuenfGrad);
		
		// das umschalten der View übernimmt ebenfalls der Controller
		actNextView = controller.new ChangeViewAction("Next View", 2);
		btnNextView = new JButton(actNextView);
		add(btnNextView);
		
		add(new JLabel("Kommentar:"));
		
		lblKommentar = new JLabel();
		add(lblKommentar);
		
		// Speicher-Button
		btnSave = new JButton();
		btnSave.setAction(controller.new SaveAction("Save"));
		add(btnSave);
		
		// Lade-Button
		btnLoad = new JButton();
		btnLoad.setAction(controller.new LoadAction("Load"));
		add(btnLoad);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		// auf dieser View wird nur der Steuerkurs ausgegeben
		lblSteuerkurs.setText("Steuerkurs: " + getModel().getSteuerkurs());
		lblKommentar.setText(getModel().getKommentar());
	}
}

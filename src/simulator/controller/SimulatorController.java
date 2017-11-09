package simulator.controller;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JFrame;

import simulator.ViewBase;
import simulator.ViewInterface;
import simulator.model.SimulatorModel;

/**
 * 
 * @author Nico Hanisch
 * @version 1.0
 */
public class SimulatorController extends ControllerUIBase {

	public SimulatorController(SimulatorModel model, JFrame frame) {
		super(model, frame);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getActionCommand().isEmpty())
			return;
		
		// Command auswerten und View setzen
		if (e.getActionCommand().startsWith("View")) {
			String[] cmd = e.getActionCommand().split(" ");
			int view = Integer.parseInt(cmd[1]);
			showView(view);
		}
		
		// Steuerkurs -5
		if (e.getActionCommand().equals("-5")) {
			model.setSteuerkurs(model.getSteuerkurs() - 5);
			informiereUeberKurskorrektur(-5);
		}
		
		// Steuerkurs +5
		if (e.getActionCommand().equals("+5")) {
			model.setSteuerkurs(model.getSteuerkurs() + 5);
			informiereUeberKurskorrektur(5);
		}
		
		// Speichern
		if (e.getActionCommand().equals("Save"))
			save("test.txt");
		
		// Laden
		if (e.getActionCommand().equals("Load"))
			load("test.txt");
	}
	
	/**
	 * Diese Funktion ist nur als Beispiel gedacht.
	 * @param kurskorrektur
	 */
	private void informiereUeberKurskorrektur(int kurskorrektur) {
		for (ViewInterface view : views)
			if (view instanceof ViewBase)
				((ViewBase)view).showKurskorrektur(kurskorrektur);
	}
	
	/**
	 * Speichert das Model in eine Datei.
	 * @param path Der Speicherort für das Model.
	 */
	private void save(String path) {
		OutputStream os = null;
		
		try {
			os = new FileOutputStream(path);
			SimulatorModel.serialize(model, os);
			
		} catch (IOException ex) { ex.printStackTrace(); }
		
		// Schliessen des Streams
		finally {
			try {
				os.close();
			} catch (IOException ex) { ex.printStackTrace(); }
		}
	}
	
	/**
	 * Lädt das Model aus einer Datei.
	 * @param path Der Speicherort des Models.
	 */
	private void load(String path) {
		InputStream is = null;
		
		try {
			
			is = new FileInputStream(path);
			model.copy(SimulatorModel.deserialize(is));
			
		} catch (ClassNotFoundException | IOException ex) {
			ex.printStackTrace();
		}
		
		// Schliessen des Streams
		finally {
			try {
				is.close();
			} catch (IOException ex) { ex.printStackTrace(); }
		}
	}

	@Override
	public void initializeModel() {
		model.setKompasskurs(0);
		model.setSteuerkurs(0);
	}
}

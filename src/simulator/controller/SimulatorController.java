package simulator.controller;

import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JTextField;

import simulator.model.SimulatorModel;
import simulator.view.ViewCmdLineBase;
import simulator.view.ViewInterface;

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
	}
	
	/**
	 * Diese Funktion ist nur als Beispiel gedacht.
	 * @param kurskorrektur
	 */
	private void informiereUeberKurskorrektur(int kurskorrektur) {
		for (ViewInterface view : views)
			if (view instanceof ViewCmdLineBase)
				((ViewCmdLineBase)view).showKurskorrektur(kurskorrektur);
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
	
	/**
	 * 
	 * @author Nico Hanisch
	 */
	@SuppressWarnings("serial")
	public class CommentAction extends AbstractAction {
		
		private JTextField textfield;
		
		/**
		 * 
		 * @param textfield
		 */
		public CommentAction(JTextField textfield) {
			super();
			this.textfield = textfield;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			model.setKommentar(textfield.getText());
		}
	}
	
	
	@SuppressWarnings("serial")
	public class ChangeViewAction extends AbstractAction {
		
		private int index;
		
		public ChangeViewAction(String text, int index) {
			super(text);
			this.index = index;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			showView(index);
		}
	}
	
	@SuppressWarnings("serial")
	public class SaveAction extends AbstractAction {
		
		public SaveAction(String text) {
			super(text);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			save("test.txt");
		}
	}
	
	@SuppressWarnings("serial")
	public class LoadAction extends AbstractAction {
		
		public LoadAction(String text) {
			super(text);
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			load("test.txt");
		}
	}
	
	@SuppressWarnings("serial")
	public class ChangeSteuerkursAction extends AbstractAction {
		
		int change;
		
		public ChangeSteuerkursAction(String text, int change) {
			super(text);
			this.change = change;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			model.setSteuerkurs(model.getSteuerkurs() + change);
			informiereUeberKurskorrektur(change);
		}
	}
}

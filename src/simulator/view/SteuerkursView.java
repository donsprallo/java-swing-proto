package simulator.view;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;

import simulator.controller.KompassControllerInterface;
import simulator.model.KompassModel;

public class SteuerkursView extends KompassView {
	
	Label label;
	Frame frame;
	
	public SteuerkursView(KompassModel model, KompassControllerInterface controller) {
		super(model, controller);
		
		frame = new Frame("Kompass GUI");
		frame.setLayout(new GridLayout(4, 1));
		
		Button btnMinusFuenfGrad = new Button("-5 Grad");
		btnMinusFuenfGrad.addActionListener(controller);
		btnMinusFuenfGrad.setActionCommand("-5");
		frame.add("North", btnMinusFuenfGrad);
		
		label = new Label();
		label.setAlignment(Label.CENTER);
		frame.add(label);
		
		Button btnPlusFuenfGrad = new Button("+5 Grad");
		btnPlusFuenfGrad.addActionListener(controller);
		btnPlusFuenfGrad.setActionCommand("+5");
		frame.add(btnPlusFuenfGrad);
		
		Button btnNextView = new Button("Next View");
		btnNextView.addActionListener(controller);
		btnNextView.setActionCommand("Next View");
		frame.add(btnNextView);
		
		frame.addWindowListener(new CloseListener());
		frame.setSize(200, 200);
		frame.setLocation(100, 100);
		//frame.setVisible(true);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		label.setText("Steuerkurs: " + getModel().getSteuerkurs());
	}

	@Override
	public void showKurskorrektur(int kurskorrektur) {
		// Tue nichts hier, die grafische Anzeige unterstützt diese Funktion nicht
	}
	
	@Override
	public void hide() {
		frame.setVisible(false);
	}
	
	@Override
	public void show() {
		frame.setVisible(true);
	}
	
	public static class CloseListener extends WindowAdapter {
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			System.exit(0);
		}
	}
}

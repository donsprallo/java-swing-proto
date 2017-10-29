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

public class SteuerkursKompassView extends KompassView {

	Label lblSteuerkurs;
	Label lblKompasskurs;
	Frame frame;
	
	public SteuerkursKompassView(KompassModel model, KompassControllerInterface controller) {
		super(model, controller);
		
		frame = new Frame("Kompass GUI");
		frame.setLayout(new GridLayout(5, 1));
		
		Button btnMinusFuenfGrad = new Button("-5 Grad");
		btnMinusFuenfGrad.addActionListener(controller);
		btnMinusFuenfGrad.setActionCommand("-5");
		frame.add("North", btnMinusFuenfGrad);
		
		lblSteuerkurs = new Label();
		lblSteuerkurs.setAlignment(Label.CENTER);
		frame.add(lblSteuerkurs);
		
		lblKompasskurs = new Label();
		lblKompasskurs.setAlignment(Label.CENTER);
		frame.add(lblKompasskurs);
		
		Button btnPlusFuenfGrad = new Button("+5 Grad");
		btnPlusFuenfGrad.addActionListener(controller);
		btnPlusFuenfGrad.setActionCommand("+5");
		frame.add(btnPlusFuenfGrad);
		
		Button btnBackView = new Button("Back View");
		btnBackView.addActionListener(controller);
		btnBackView.setActionCommand("Back View");
		frame.add(btnBackView);
		
		frame.addWindowListener(new CloseListener());
		frame.setSize(200, 200);
		frame.setLocation(100, 100);
		//frame.setVisible(true);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		lblSteuerkurs.setText("Steuerkurs: " + getModel().getSteuerkurs());
		lblKompasskurs.setText("Kompasskurs: " + getModel().getKompasskurs());
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

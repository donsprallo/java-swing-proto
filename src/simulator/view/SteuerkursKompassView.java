package simulator.view;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.Observable;

import simulator.ViewUIBase;
import simulator.controller.KompassControllerInterface;
import simulator.model.KompassModel;

@SuppressWarnings("serial")
public class SteuerkursKompassView extends ViewUIBase {

	Label lblSteuerkurs;
	Label lblKompasskurs;
	
	public SteuerkursKompassView(KompassModel model, KompassControllerInterface controller) {
		super(model, controller);
		
		setLayout(new GridLayout(5, 1));
		
		Button btnMinusFuenfGrad = new Button("-5 Grad");
		btnMinusFuenfGrad.addActionListener(controller);
		btnMinusFuenfGrad.setActionCommand("-5");
		add("North", btnMinusFuenfGrad);
		
		lblSteuerkurs = new Label();
		lblSteuerkurs.setAlignment(Label.CENTER);
		add(lblSteuerkurs);
		
		lblKompasskurs = new Label();
		lblKompasskurs.setAlignment(Label.CENTER);
		add(lblKompasskurs);
		
		Button btnPlusFuenfGrad = new Button("+5 Grad");
		btnPlusFuenfGrad.addActionListener(controller);
		btnPlusFuenfGrad.setActionCommand("+5");
		add(btnPlusFuenfGrad);
		
		Button btnBackView = new Button("Back View");
		btnBackView.addActionListener(controller);
		btnBackView.setActionCommand("Back View");
		add(btnBackView);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		lblSteuerkurs.setText("Steuerkurs: " + getModel().getSteuerkurs());
		lblKompasskurs.setText("Kompasskurs: " + getModel().getKompasskurs());
	}

}

package simulator.view;

import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.util.Observable;

import simulator.ViewUIComponentBase;
import simulator.controller.KompassControllerInterface;
import simulator.model.KompassModel;

@SuppressWarnings("serial")
public class SteuerkursView extends ViewUIComponentBase {
	
	Label label;
	
	public SteuerkursView(KompassModel model, KompassControllerInterface controller) {
		super(model, controller);
		
		setLayout(new GridLayout(4, 1));
		
		Button btnMinusFuenfGrad = new Button("-5 Grad");
		btnMinusFuenfGrad.addActionListener(controller);
		btnMinusFuenfGrad.setActionCommand("-5");
		add("North", btnMinusFuenfGrad);
		
		label = new Label();
		label.setAlignment(Label.CENTER);
		add(label);
		
		Button btnPlusFuenfGrad = new Button("+5 Grad");
		btnPlusFuenfGrad.addActionListener(controller);
		btnPlusFuenfGrad.setActionCommand("+5");
		add(btnPlusFuenfGrad);
		
		Button btnNextView = new Button("Next View");
		btnNextView.addActionListener(controller);
		btnNextView.setActionCommand("Next View");
		add(btnNextView);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		label.setText("Steuerkurs: " + getModel().getSteuerkurs());
	}
}

package simulator.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import simulator.ViewBase;
import simulator.ViewUIComponentBase;
import simulator.ViewInterface;
import simulator.model.KompassModel;

public class KompassController implements KompassControllerInterface {

	private KompassModel model;
	private ArrayList<ViewInterface> views;
	
	private JFrame frame;
	
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
	
	public KompassController(KompassModel model) {
		this.model = model;
		views = new ArrayList<ViewInterface>();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("-5")) {
			model.setSteuerkurs(model.getSteuerkurs() - 5);
			informiereUeberKurskorrektur(-5);
		}
		
		if (e.getActionCommand().equals("+5")) {
			model.setSteuerkurs(model.getSteuerkurs() + 5);
			informiereUeberKurskorrektur(5);
		}
		
		if (e.getActionCommand().equals("Next View")) {
			showView(2);
		}
		
		if (e.getActionCommand().equals("Back View")) {
			showView(1);
		}
	}

	private void informiereUeberKurskorrektur(int kurskorrektur) {
		for (ViewInterface view : views)
			if (view instanceof ViewBase)
				((ViewBase)view).showKurskorrektur(kurskorrektur);
	}
	
	private void showView(int index) {
		
		for(ViewInterface view : views) {
			if (view instanceof ViewUIComponentBase)
				frame.getContentPane().remove((ViewUIComponentBase)view);
		}
		
		if (views.get(index) instanceof ViewUIComponentBase)
			frame.getContentPane().add((ViewUIComponentBase)views.get(index));
		
		frame.getContentPane().validate();
	}
	
	public void initialisiereModel() {
		model.setKompasskurs(0);
		model.setSteuerkurs(0);
	}

	@Override
	public void addView(ViewInterface view) {
		views.add(view);
	}
}

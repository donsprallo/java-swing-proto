package simulator.controller;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import simulator.model.KompassModel;
import simulator.view.KompassView;

public class KompassController implements KompassControllerInterface {

	private KompassModel model;
	private ArrayList<KompassView> views;
	
	public KompassController(KompassModel model) {
		this.model = model;
		views = new ArrayList<KompassView>();
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
			for (KompassView view : views) {
				view.hide();
			}
			views.get(2).show();
		}
		
		if (e.getActionCommand().equals("Back View")) {
			for (KompassView view : views) {
				view.hide();
			}
			views.get(1).show();
		}
	}

	@Override
	public void addView(KompassView view) {
		views.add(view);
	}

	private void informiereUeberKurskorrektur(int kurskorrektur) {
		for (KompassView view : views)
			view.showKurskorrektur(kurskorrektur);
	}
	
	public void initialisiereModel() {
		model.setKompasskurs(0);
		model.setSteuerkurs(0);
		views.get(1).show();
	}
}

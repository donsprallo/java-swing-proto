package simulator.view;

import java.util.Observer;

import simulator.controller.KompassControllerInterface;
import simulator.model.KompassModel;

public abstract class KompassView implements Observer {
	
	private KompassModel model;
	private KompassControllerInterface controller;
	
	protected KompassModel getModel() {
		return model;
	}
	
	protected KompassControllerInterface getController() {
		return controller;
	}
	
	public abstract void hide();
	public abstract void show();
	public abstract void showKurskorrektur(int kurskorrektur);
	
	public KompassView(KompassModel model, KompassControllerInterface controller) {
		this.model = model;
		this.controller = controller;
		
		model.addObserver(this);
		controller.addView(this);
	}
}

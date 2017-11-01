package simulator;

import simulator.controller.KompassControllerInterface;
import simulator.model.KompassModel;

/**
 * 
 * 
 * @author Nico Hanisch
 * @version 1.0
 */
public abstract class ViewBase
implements ViewInterface {
	
	private KompassModel model;
	private KompassControllerInterface controller;
	
	public ViewBase(KompassModel model, KompassControllerInterface controller) {
		this.model = model;
		this.controller = controller;
		
		model.addObserver(this);
		controller.addView(this);
	}
	
	public KompassModel getModel() {
		return model;
	}
	
	public KompassControllerInterface getController() {
		return controller;
	}
	
	public abstract void showKurskorrektur(int kurskorrektur);
}

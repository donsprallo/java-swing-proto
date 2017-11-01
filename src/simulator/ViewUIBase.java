/**
 * 
 */
package simulator;

import javax.swing.JComponent;
import simulator.controller.KompassControllerInterface;
import simulator.model.KompassModel;

/**
 * 
 * 
 * @author Nico Hanisch
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class ViewUIBase
extends JComponent
implements ViewInterface {

	private KompassModel model;
	private KompassControllerInterface controller;
	
	public ViewUIBase(KompassModel model, KompassControllerInterface controller) {
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
}

package simulator.view;

import java.util.Observable;

import simulator.ViewBase;
import simulator.controller.KompassControllerInterface;
import simulator.model.KompassModel;

public class CommandlineView extends ViewBase {
	
	public CommandlineView(KompassModel model, KompassControllerInterface controller) {
		super(model, controller);
	}
	
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("---");
		System.out.println("Steuerkurs: " + getModel().getSteuerkurs());
		System.out.println("Aktueller Kurs: " + getModel().getKompasskurs());
		System.out.println("---");
	}

	@Override
	public void showKurskorrektur(int kurskorrektur) {
		System.out.println("Steuerkurs-Korrekturanfrage: " + kurskorrektur + " Grad");
	}

}

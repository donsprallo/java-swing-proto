package simulator.view;

import java.util.Observable;

import simulator.controller.KompassControllerInterface;
import simulator.model.KompassModel;

public class CommandlineView extends KompassView {
	
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
	public void hide() {
	}
	
	@Override
	public void show() {
	}

	@Override
	public void showKurskorrektur(int kurskorrektur) {
		System.out.println("Steuerkurs-Korrekturanfrage: " + kurskorrektur + " Grad");
	}

}

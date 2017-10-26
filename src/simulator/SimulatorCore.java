package simulator;

import engine.Core;
import engine.CoreEvent;

public class SimulatorCore extends Core {

	@Override
	protected CoreEvent pollEvent() {
		// Momentan werden keine Events abgefragt
		return null;
	}

	@Override
	protected boolean onInit() {
		// TODO Verknüpfen der MVC-Komponenten
		return true;
	}

	@Override
	protected void onEvent(CoreEvent e) {
		// Momentan werden keine Events abgefragt		
	}

	@Override
	protected void onUpdate() {
		// TODO Daten hier verändern
		
	}

	@Override
	protected void onRender() {
		// TODO Views hier verändern
		
	}

	@Override
	protected void onCleanup() {
		// Macht nichts
		return;
	}
	
}

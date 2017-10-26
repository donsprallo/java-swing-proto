package engine;

public abstract class Core {
	// Flag zum beenden das Game Loop
	private boolean _running;
	
	public Core() {
		_running = false;
	}
	
	// Startet die Engine
	public int onExcecute() {
		CoreEvent e;
		
		_running = true;
		
		// Grafik-Bib initialisieren
		if (!onInit()) {
			_running = false;
			return -1;
		}
		
		// Game-Loop
		while(_running) {
			
			while ((e = pollEvent()) != null) {
				onEvent(e);
			}
				
			onUpdate();
			onRender();
		}
			
		// Ressourcen freigeben
		onCleanup();
			
		return 0;
	}
		
	// Beendet die Engine
	public void onQuit() {
		_running = false;
	}
	
	// Gibt das n�chste Event zur�ck
	protected abstract CoreEvent pollEvent();
	
	// L�dt alle Ressourcen f�r die Engine
	protected abstract boolean onInit();
	
	// Reagiert auf alle Ereignisse, wie Eingaben
	protected abstract void onEvent(CoreEvent e);
	
	// Berechnet Daten�nderungen wie Bewegungen und Status�nderungen
	protected abstract void onUpdate();
	
	// Update der Anzeige, ohne Daten zu �ndern
	protected abstract void onRender();
	
	// Entl�dt alle Ressourcen
	protected abstract void onCleanup();
}

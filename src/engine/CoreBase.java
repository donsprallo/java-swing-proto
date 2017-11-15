package engine;

/**
 * Die Basisklasse für eine einfache Spiel-Engine.
 * <p>
 * Sie bietet eine grundlegende Struktur und Funktionen an.
 * Die eigentliche Engine muss von dieser Klasse ableiten und die benötigten Funktionen implementieren.
 * 
 * @author Nico Hanisch
 * @version 1.1
 */
public abstract class CoreBase {
	// Flag zum beenden das Game Loop
	private boolean running;
	
	/**
	 * Der Konstruktor für ein {@link engine.CoreBase}-Objekt (Engine).
	 * <p>
	 * Zum starten der Engine muss die Funktion {@link engine.CoreBase#excecute() excecute()} bemüht werden.
	 */
	public CoreBase() {
		running = false;
	}
	
	/**
	 * Startet die Engine.
	 * <p>
	 * Führt die Engine in einer Endlosschleife aus. Diese Funktion wird erst nach dem Beenden der
	 * Engine verlassen.
	 * 
	 * @return Gibt 0 zurück, wenn die Ausführung korrekt beendet wurde. Andernfalls wird eine Zahl
	 * ungleich 0 zurück gegeben.
	 */
	public int excecute() {
		CoreEvent e;
		
		running = true;
		
		// Grafik-Bib initialisieren
		if (!onInit()) {
			running = false;
			return -1;
		}
		
		// Game-Loop
		while(running) {
			
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
		
	/**
	 * Beendet die Engine.
	 * <p>
	 * Mit dieser Funktion kann von ausserhalb die Spiel-Schleife unterbrochen werden.
	 */
	public void quit() {
		running = false;
	}
	
	/**
	 * Gibt das nächste {@link engine.CoreEvent}-Objekt zurück.
	 * <p>
	 * Muss überladen werden. Die Funktion wird so lange aufgerufen bis alle Events in der
	 * Warteschlange abgearbeitet wurden. Das Event-Objekt, welches zurück gegeben wird, wird
	 * in der Funktion {@link engine.CoreBase#onEvent() onEvent()} verarbeitet.
	 * 
	 * @return Das nächste Event aus der Warteschlange oder
	 * null, wenn kein Event eingereiht ist.
	 */
	protected abstract CoreEvent pollEvent();
	
	/**
	 * Lädt alle Ressourcen für die Engine und führt Initialisierungen aus.
	 * <p>
	 * Muss überladen werden. Die Funktion wird einmalig bei der Ausführung von
	 * {@link engine.CoreBase#excecute() excecute()} aufgerufen. Hier werden Initialisierungen
	 * der Grafik-Bibliothek ausgeführt.
	 * 
	 * @return Gibt true zurück wenn die Initialisierung erfolgreich war,
	 * andernfalls false.
	 */
	protected abstract boolean onInit();
	
	/**
	 * Reagiert auf alle Ereignisse, wie Eingaben.
	 * <p>
	 * Muss überladen werden. Hier werden die Ereignisse verarbeitet, welche von
	 * {@link engine.CoreBase#pollEvent() pollEvent()} zurück gegeben werden.
	 * 
	 * @param e Das Event-Objekt, welches zur Verarbeitung durchgereicht wird.
	 */
	protected abstract void onEvent(CoreEvent e);
	
	/**
	 * Hier werden Datenänderungen wie Bewegungen und Statusänderungen durchgeführt.
	 * <p>
	 * Muss überladen werden. Diese Funktion wird in jedem Schleifendurchlauf ausgeführt.
	 * Es werden die Daten zur Anzeige berechnet.
	 */
	protected abstract void onUpdate();
	
	/**
	 * Verarbeitet die Daten und zeigt diese an.
	 * <p>
	 * Muss überladen werden. Diese Funktion wird in jedem Schleifendurchlauf ausgeführt.
	 * Hier werden die Daten, die vorher in {@link engine.CoreBase#onUpdate() onUpdate()}
	 * berechnet wurde, angezeigt bzw. gezeichnet.
	 */
	protected abstract void onRender();
	
	/**
	 * Entlädt alle Ressourcen und bereinigt die Engine.
	 * <p>
	 * Muss überladen werden. Die Funktion wird nur aufgerufen, wenn die Engine Ordungsgemäß mit
	 * {@link engine.CoreBase#quit() quit()} beendet wurde. Hier werden gegebenenfalls alle
	 * Bereinigungen von Ressourcen durchgeführt.
	 */
	protected abstract void onCleanup();
}

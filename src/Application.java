import simulator.Core;

/**
 * Die Klasse stellt die Anwendung dar.
 * 
 * @author Nico Hanisch
 * @version 1.0
 */
public class Application {
	
	/**
	 * Einstiegspunkt in die Anwendung. Startet den Simulator.
	 * @param args Übergebene Parameter bei Programmstart.
	 */
	public static void main(String[] args) {
		Core simulator = new Core();
		simulator.excecute();
	}

}

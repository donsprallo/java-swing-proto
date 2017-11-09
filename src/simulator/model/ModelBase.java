package simulator.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.Observable;

/**
 * Ein Model bildet im MVC die Logik ab.
 * <p>
 * Erweitert die Klasse {@link java.util.Observable} und implementiert das {@link java.io.Serializeable}
 * -Interface. Alle Daten, die von einer View angezeigt werden können, werden hier zur Verfügung gestellt.
 * Ausserdem übernimmt ein Model die Validierung von Daten. Gegebenfalls können die Daten ebenfalls vorher
 * vom Controller validiert werden. Ein konkretes Model sollte von dieser Klasse ableiten. Es werden
 * Methoden zum Serialisieren und Deserilisieren zur Verfügung gestellt.
 * 
 * @author Nico Hanisch
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class ModelBase
extends Observable
implements Serializable {
	
	/**
	 * Serialisiert ein übergebenes {@link simulator.model.SimulatorModel}-Objekt in einen Ausgabestream.
	 * @param model
	 * @param os
	 */
	public static <T extends ModelBase> void serialize(T model, OutputStream os)
			throws IOException {
		
		ObjectOutputStream oos = new ObjectOutputStream(os);
		
		oos.writeObject(model);
		oos.close();
	}
	
	/**
	 * Deserialisiert ein {@link simulator.model.SimulatorModel}-Objekt aus einem Eingabestream.
	 * @param is
	 * @return
	 */
	public static <T extends ModelBase> T deserialize(InputStream is)
			throws IOException, ClassNotFoundException {
		
		ObjectInputStream ois = new ObjectInputStream(is);
		
		@SuppressWarnings("unchecked")
		T res = (T)ois.readObject();
		ois.close();
		
		return res;
	}
}

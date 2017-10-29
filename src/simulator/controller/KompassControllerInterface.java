package simulator.controller;

import java.awt.event.ActionListener;

import simulator.view.KompassView;

public interface KompassControllerInterface extends ActionListener {
	public void addView(KompassView view);
}

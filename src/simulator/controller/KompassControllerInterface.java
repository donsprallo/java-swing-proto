package simulator.controller;

import java.awt.event.ActionListener;

import simulator.ViewInterface;

public interface KompassControllerInterface extends ActionListener {
	public void addView(ViewInterface view);
}

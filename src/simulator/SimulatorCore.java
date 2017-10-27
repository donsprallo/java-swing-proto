package simulator;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

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
		SwingUtilities.invokeLater(() -> starteMich());
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
		System.out.println("onCleanup");
		return;
	}
	
	private static void starteMich() {
		// Frame erzeugen
		JFrame frame = new JFrame("Versuch_02");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(Box.createVerticalBox());
		
		// Dehnbaren Zwischenraum hinzufügen
		frame.add(Box.createGlue());
		
		// Label erzeugen
		JLabel label = new JLabel("Text");
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		frame.add(label);
		
		// Zwischenraum hinzufügen
		frame.add(Box.createVerticalStrut(50));
		
		// Button erzeugen
		JButton button = new JButton("Knopf");
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.addActionListener(
				(e) -> { System.out.println("Knopf gedrückt"); }
				);
		frame.add(button);
		
		// Dehnbaren Zwischenraum hinzufügen
		frame.add(Box.createGlue());
		
		// Horizontale Box erzeugen
		Box box = Box.createHorizontalBox();
		{
			Icon green = new ImageIcon("green.png");
			Icon yellow = new ImageIcon("yellow.png");
			Icon red = new ImageIcon("red.png");
			
			box.add(new JLabel(green));
			box.add(new JLabel(yellow));
			box.add(new JLabel(red));
		}
		frame.add(box);
		
		// Menü erzeugen
		JMenuBar bar = new JMenuBar();
		{
			JMenu menu1 = new JMenu("File");
			{
				JMenuItem item1 = new JMenuItem("Open");
				item1.addActionListener(
						(e) -> { System.out.println("Open");}
						);
				JMenuItem item2 = new JMenuItem("Close");
				item2.addActionListener(
						(e) -> { System.out.println("Close");}
						);
				
				menu1.add(item1);
				menu1.add(item2);
			}
			
			JMenu menu2 = new JMenu("Edit");
			{
				JMenuItem item1 = new JMenuItem("Copy");
				item1.addActionListener(
						(e) -> { System.out.println("Copy");}
						);
				JMenuItem item2 = new JMenuItem("Paste");
				item2.addActionListener(
						(e) -> { System.out.println("Paste");}
						);
				
				menu2.add(item1);
				menu2.add(item2);
			}
			
			bar.add(menu1);
			bar.add(menu2);
		}
		frame.setJMenuBar(bar);
		
		// Packen und anzeigen
		frame.pack();
		frame.setVisible(true);
	}
}

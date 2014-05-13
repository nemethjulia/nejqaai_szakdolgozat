package gui.methodComponents;

import gui.Manager;

import javax.swing.JPanel;

import algorithms.Method;
import datastructures.MySparseVector;

public class MethodPanel extends JPanel {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = -2763805661243785910L;

	public MethodPanel(Method method) {
		Manager manager = Manager.getInstance();

		for (MySparseVector x : manager.getxVectors()) {

		}

	}

}

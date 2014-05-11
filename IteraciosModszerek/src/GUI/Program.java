package gui;

import javax.swing.SwingUtilities;

public class Program {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});

	}

	private static void createAndShowGUI() {
		MyFrame frame = new MyFrame();
		frame.pack();
		frame.setVisible(true);
	}

}

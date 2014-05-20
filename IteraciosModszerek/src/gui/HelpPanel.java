package gui;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class HelpPanel extends JPanel {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = -6010631095524168028L;

	public HelpPanel() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JScrollPane scrollPane = new JScrollPane();
		add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
	}

}

package GUI;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;

import datastructures.MySparseVector;

public class ShowValues extends JPanel {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = 5680723855545340540L;

	private JTextArea matrixArea;
	private JTextArea xVectorsArea;
	private JTextArea bVectorArea;

	public ShowValues() {
		super();

		matrixArea = new JTextArea();

		JLabel lblBetltttMtrix = new JLabel("Bet\u00F6lt\u00F6tt m\u00E1trix:");

		xVectorsArea = new JTextArea();

		JLabel lblXVektorok = new JLabel("X0 vektorok: ");

		bVectorArea = new JTextArea();

		JLabel lblBVektor = new JLabel("b vektor");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(lblBetltttMtrix, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE).addGap(10).addComponent(matrixArea, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addComponent(lblXVektorok, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(xVectorsArea, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE))
										.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addComponent(lblBVektor, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE).addComponent(bVectorArea, GroupLayout.PREFERRED_SIZE, 470, GroupLayout.PREFERRED_SIZE))).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(35).addComponent(lblBetltttMtrix, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addGap(30).addComponent(matrixArea, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(18).addComponent(xVectorsArea, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addGap(25).addComponent(lblXVektorok, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))).addGap(18)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(bVectorArea, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE).addComponent(lblBVektor, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)).addContainerGap(12, Short.MAX_VALUE)));
		setLayout(groupLayout);

		setValues();
	}

	private void setValues() {
		Manager manager = Manager.getInstance();
		matrixArea.setText(manager.getMatrix().toString());
		String xVectors = "";
		for (MySparseVector x : manager.getxVectors()) {
			xVectors += x.toString();
		}
		xVectorsArea.setText(xVectors);
		bVectorArea.setText(manager.getBVector().toString());
	}
}

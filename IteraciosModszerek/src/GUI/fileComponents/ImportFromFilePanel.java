package GUI.fileComponents;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import GUI.Manager;
import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

public class ImportFromFilePanel extends JPanel {
	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = 532472660198249533L;

	private JComboBox<String> comboBoxDataStructure;
	private JComboBox<String> comboBoxVectorStatus;
	private JTextArea txtrDescription;

	private String vectorDescription = "vector";
	private String matrixDescription = "matrix";

	public ImportFromFilePanel() {
		setBorder(null);

		JTextField textAsking = new JTextField();
		textAsking.setHorizontalAlignment(SwingConstants.CENTER);
		textAsking.setText("K\u00E9rem, v\u00E1lassza ki a beolvasand\u00F3 adatt\u00EDpust!");
		textAsking.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAsking.setEditable(false);
		textAsking.setColumns(30);

		comboBoxVectorStatus = new JComboBox<String>();
		comboBoxVectorStatus.setModel(new DefaultComboBoxModel<String>(new String[] { "Egy X0 érték", "B" }));
		comboBoxVectorStatus.setSelectedIndex(0);

		txtrDescription = new JTextArea();
		txtrDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtrDescription.setEditable(false);
		txtrDescription.setText(vectorDescription);

		JButton btnImport = new JButton("Beolvas\u00E1s");
		btnImport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				JFileChooser chooser = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(getParent());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					if (comboBoxDataStructure.getSelectedIndex() == 0) {
						MySparseVector vector = MySparseVector.readFromFile(chooser.getSelectedFile());
						if (vector != null) {
							if (comboBoxVectorStatus.getSelectedIndex() == 0) {
								Manager.getInstance().addXVector(vector);
							} else {
								Manager.getInstance().setBVector(vector);
							}
						}
					} else if (comboBoxDataStructure.getSelectedIndex() == 1) {
						MySparseMatrix matrix = MySparseMatrix.readFromFile(chooser.getSelectedFile());
						if (matrix != null) {
							Manager.getInstance().setMatrix(matrix);
						}
					}
				}
			}

		});

		comboBoxDataStructure = new JComboBox<String>();
		comboBoxDataStructure.setModel(new DefaultComboBoxModel<String>(new String[] { "Vektor", "M\u00E1trix" }));
		comboBoxDataStructure.setSelectedIndex(0);
		comboBoxDataStructure.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (comboBoxDataStructure.getSelectedIndex() == 0) {
					txtrDescription.setText(vectorDescription);
					comboBoxVectorStatus.setEnabled(true);
				} else if (comboBoxDataStructure.getSelectedIndex() == 1) {
					txtrDescription.setText(matrixDescription);
					comboBoxVectorStatus.setEnabled(false);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(comboBoxDataStructure, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE).addComponent(textAsking, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup().addGap(50).addComponent(comboBoxVectorStatus, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED, 274, Short.MAX_VALUE).addComponent(btnImport).addGap(75))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(txtrDescription, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE).addContainerGap()));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap().addComponent(textAsking, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(20).addComponent(comboBoxDataStructure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(comboBoxVectorStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(btnImport)).addGap(11).addComponent(txtrDescription, GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE).addContainerGap()));
		setLayout(groupLayout);
	}
}

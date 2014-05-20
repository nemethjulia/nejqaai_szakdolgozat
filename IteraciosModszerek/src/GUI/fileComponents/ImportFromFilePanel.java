package gui.fileComponents;

import gui.Manager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

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

	private String vectorDescription = " Vektor megadása esetén az elsõ sorba a vektor méretét várja a program.\n A következõ sorokban az elemek sorának számát, majd vesszõvel elválasztva az elemek értékét kell írni.\n Például:\n 120\n 10,1.2\n 11,0.42\n";
	private String matrixDescription = " Mátrix megadása esetén az elsõ sorba a mátrix méretét várja a program.\n A következõ sorokban az elemek sorának, oszlopának számát, majd az elemek értékét kell írni vesszõvel elválasztva.\n Például:\n 120\n 10,10,1.2\n 11,11,0.42\n";

	public ImportFromFilePanel() {
		setBorder(null);

		JTextField textAsking = new JTextField();
		textAsking.setHorizontalAlignment(SwingConstants.CENTER);
		textAsking.setText("K\u00E9rem, v\u00E1lassza ki a beolvasand\u00F3 adatt\u00EDpust!");
		textAsking.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAsking.setEditable(false);
		textAsking.setColumns(30);

		comboBoxVectorStatus = new JComboBox<String>();
		comboBoxVectorStatus.setModel(new DefaultComboBoxModel<String>(new String[] { "Egy X0 kezdõvektor", "A b jobboldali vektor" }));
		comboBoxVectorStatus.setSelectedIndex(0);

		txtrDescription = new JTextArea();
		txtrDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtrDescription.setEditable(false);
		txtrDescription.setText(vectorDescription);

		JButton btnImport = new JButton("Beolvas\u00E1s");
		btnImport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				JFileChooser chooser;
				String lastPath = Manager.getInstance().getLastPath();
				if (lastPath != null) {
					chooser = new JFileChooser(lastPath);
				} else {
					chooser = new JFileChooser();
				}
				FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
				chooser.setFileFilter(filter);
				int returnVal = chooser.showOpenDialog(getParent());
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					if (comboBoxDataStructure.getSelectedIndex() == 0) {
						MySparseVector vector = null;
						try {
							vector = MySparseVector.readFromFile(chooser.getSelectedFile());
						} catch (NumberFormatException | IOException e) {
							showMessage("Hiba a fájl beolvasásában!");
						}
						if (vector != null) {
							if (comboBoxVectorStatus.getSelectedIndex() == 0) {
								Manager.getInstance().addXVector(vector);
							} else {
								Manager.getInstance().setBVector(vector);
							}
						}
					} else if (comboBoxDataStructure.getSelectedIndex() == 1) {
						MySparseMatrix matrix = null;
						try {
							matrix = MySparseMatrix.readFromFile(chooser.getSelectedFile());
						} catch (NumberFormatException | IOException e) {
							showMessage("Hiba a fájl beolvasásában!");
						}
						if (matrix != null) {
							Manager.getInstance().setMatrix(matrix);
						}
					}
					Manager.getInstance().setLastPath(chooser.getSelectedFile().getAbsolutePath());
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
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(160).addComponent(textAsking, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE).addGap(160)).addGroup(groupLayout.createSequentialGroup().addGap(204).addComponent(comboBoxVectorStatus, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED, 237, Short.MAX_VALUE).addComponent(btnImport).addGap(238))
				.addGroup(groupLayout.createSequentialGroup().addGap(174).addComponent(comboBoxDataStructure, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE).addContainerGap(646, Short.MAX_VALUE)).addGroup(groupLayout.createSequentialGroup().addGap(160).addComponent(txtrDescription, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE).addGap(160)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addGap(30).addComponent(textAsking, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(18).addComponent(comboBoxDataStructure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(comboBoxVectorStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(btnImport)).addGap(22).addComponent(txtrDescription, GroupLayout.PREFERRED_SIZE, 222, GroupLayout.PREFERRED_SIZE).addContainerGap(39, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}

	private void showMessage(String msg) {

		Manager.getInstance().showMessage(msg);
	}
}

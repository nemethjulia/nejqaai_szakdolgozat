package gui.fileComponents;

import gui.Manager;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import datastructures.MySparseVector;

public class ExportToFile extends JPanel {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = -6379745879494313917L;

	private JComboBox<String> comboBoxDataStructure;
	private JComboBox<String> comboBoxVectorStatus;

	private boolean letsSave = true;

	public ExportToFile() {
		setBorder(null);

		JTextField textAsking = new JTextField();
		textAsking.setHorizontalAlignment(SwingConstants.CENTER);
		textAsking.setText("K\u00E9rem, v\u00E1lassza ki a ki\u00EDrand\u00F3 adatt\u00EDpust!");
		textAsking.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAsking.setEditable(false);
		textAsking.setColumns(30);

		comboBoxVectorStatus = new JComboBox<String>();
		comboBoxVectorStatus.setModel(new DefaultComboBoxModel<String>(Manager.getInstance().getxVectorsString()));
		if (comboBoxVectorStatus.getItemCount() > 0) {
			comboBoxVectorStatus.setSelectedIndex(0);
		}

		JButton btnExport = new JButton("Mentés");
		btnExport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {

				Manager manager = Manager.getInstance();

				String dataToFile = "";
				switch (comboBoxDataStructure.getSelectedIndex()) {
					case 0 :
						if (comboBoxVectorStatus.getSelectedIndex() > -1) {
							MySparseVector vector = manager.getxVectors().get(comboBoxVectorStatus.getSelectedIndex());
							dataToFile = vector.toFileFormat();
							letsSave = true;
						} else {
							manager.showMessage("Nem megfelelõ érték!");
							letsSave = false;
						}
						break;

					case 1 :
						dataToFile = manager.getBVector().toFileFormat();
						letsSave = true;
						break;

					case 2 :
						dataToFile = manager.getMatrix().toFileFormat();
						letsSave = true;
						break;

					default :
						break;
				}

				if (letsSave) {
					JFileChooser chooser = new JFileChooser();
					FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
					chooser.setFileFilter(filter);
					int returnVal = chooser.showSaveDialog(getParent());
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						try (FileWriter fw = new FileWriter(chooser.getSelectedFile() + ".txt")) {
							fw.write(dataToFile);
							fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			}

		});

		comboBoxDataStructure = new JComboBox<String>();
		comboBoxDataStructure.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBoxDataStructure.setModel(new DefaultComboBoxModel<String>(new String[] { "Egy X0 kezdõvektor", "A b jobboldali vektor", "m\u00E1trix" }));
		comboBoxDataStructure.setSelectedIndex(0);
		comboBoxDataStructure.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (comboBoxDataStructure.getSelectedIndex() == 0) {
					comboBoxVectorStatus.setEnabled(true);
				} else {
					comboBoxVectorStatus.setEnabled(false);
				}
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addGroup(
								groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addContainerGap().addComponent(comboBoxVectorStatus, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE).addGap(139).addComponent(btnExport))
										.addGroup(groupLayout.createSequentialGroup().addGap(160).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(comboBoxDataStructure, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE).addComponent(textAsking, GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)))).addGap(160)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addGap(13).addComponent(textAsking, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(79).addComponent(comboBoxDataStructure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addGap(30).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(btnExport).addComponent(comboBoxVectorStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addContainerGap(203, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}
}

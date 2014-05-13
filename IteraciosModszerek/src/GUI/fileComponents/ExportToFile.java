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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
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
							JOptionPane.showMessageDialog(getParent(), "Nem megfelelõ érték!");
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
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup().addGap(90).addComponent(comboBoxVectorStatus, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(btnExport).addGap(75))
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(comboBoxDataStructure, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE).addComponent(textAsking, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addContainerGap().addComponent(textAsking, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(20).addComponent(comboBoxDataStructure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnExport).addComponent(comboBoxVectorStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addContainerGap(188, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}
}

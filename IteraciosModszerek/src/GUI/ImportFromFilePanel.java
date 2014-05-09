package GUI;

import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ImportFromFilePanel extends JPanel {
	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = 532472660198249533L;

	private String vectorDescription = "";
	private String matrixDescription = "";

	public ImportFromFilePanel() {
		setBorder(null);

		JTextField textAsking = new JTextField();
		textAsking.setHorizontalAlignment(SwingConstants.CENTER);
		textAsking.setText("K\u00E9rem, v\u00E1lassza ki a beolvasand\u00F3 adatt\u00EDpust!");
		textAsking.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAsking.setEditable(false);
		textAsking.setColumns(30);

		JComboBox<String> comboBoxDataStructure = new JComboBox<String>();
		comboBoxDataStructure.setModel(new DefaultComboBoxModel<String>(new String[] { "Vektor", "M\u00E1trix" }));
		comboBoxDataStructure.setSelectedIndex(0);

		JTextArea txtrDescription = new JTextArea();
		txtrDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtrDescription.setEditable(false);

		JButton btnImport = new JButton("Beolvas\u00E1s");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout
				.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup().addContainerGap().addComponent(textAsking, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(
						groupLayout.createSequentialGroup().addGap(50).addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(comboBoxDataStructure, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE).addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(btnImport, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE).addComponent(txtrDescription, GroupLayout.PREFERRED_SIZE, 500, GroupLayout.PREFERRED_SIZE)))
								.addContainerGap(50, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addGap(15).addComponent(textAsking, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(10).addComponent(comboBoxDataStructure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGroup(groupLayout.createSequentialGroup().addGap(30).addComponent(btnImport, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))).addGap(35)
						.addComponent(txtrDescription, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE).addContainerGap(25, Short.MAX_VALUE)));
		setLayout(groupLayout);
	}
}

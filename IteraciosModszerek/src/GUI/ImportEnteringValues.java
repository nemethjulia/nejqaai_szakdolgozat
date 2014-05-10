package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

public class ImportEnteringValues extends JPanel {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = -3259504850477274793L;

	private JComboBox<String> comboBoxDataStructure;
	private JComboBox<String> comboBoxVectorStatus;
	private JTextField sizeField;
	private JTextField rowField;
	private JTextField colField;
	private JTextField valueField;

	public ImportEnteringValues() {
		super();

		JTextField textAsking = new JTextField();
		textAsking.setHorizontalAlignment(SwingConstants.CENTER);
		textAsking.setText("K\u00E9rem, v\u00E1lassza ki a beolvasand\u00F3 adatt\u00EDpust!");
		textAsking.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAsking.setEditable(false);
		textAsking.setColumns(30);

		comboBoxVectorStatus = new JComboBox<String>();
		comboBoxVectorStatus.setModel(new DefaultComboBoxModel<String>(new String[] { "Egy X0 érték", "B" }));
		comboBoxVectorStatus.setSelectedIndex(0);

		JButton btnImport = new JButton("Beolvas\u00E1s");
		btnImport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				comboBoxDataStructure.setEnabled(false);
				comboBoxVectorStatus.setEnabled(false);
				sizeField.setEnabled(true);
				sizeField.setEditable(true);
			}

		});

		comboBoxDataStructure = new JComboBox<String>();
		comboBoxDataStructure.setModel(new DefaultComboBoxModel<String>(new String[] { "Vektor", "M\u00E1trix" }));
		comboBoxDataStructure.setSelectedIndex(0);
		comboBoxDataStructure.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				if (comboBoxDataStructure.getSelectedIndex() == 0) {
					comboBoxVectorStatus.setEnabled(true);
				} else if (comboBoxDataStructure.getSelectedIndex() == 1) {
					comboBoxVectorStatus.setEnabled(false);
				}
			}
		});

		JLabel lblSize = new JLabel("M\u00E9ret");

		sizeField = new JTextField();
		sizeField.setEnabled(false);
		sizeField.setEditable(false);
		sizeField.setToolTipText("\u00DCss\u00F6n egy Entert a folytat\u00E1shoz");
		sizeField.setColumns(10);
		sizeField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
					rowField.setEnabled(true);
					rowField.setEditable(true);

					if (comboBoxDataStructure.getSelectedIndex() == 1) {
						colField.setEnabled(true);
						colField.setEditable(true);
					}
					valueField.setEnabled(true);
					valueField.setEditable(true);

					sizeField.setEditable(false);
					sizeField.setEnabled(true);
					rowField.requestFocus();
				}
			}
		});

		rowField = new JTextField();
		rowField.setEnabled(false);
		rowField.setEditable(false);
		rowField.setColumns(10);

		colField = new JTextField();
		colField.setEnabled(false);
		colField.setEditable(false);
		colField.setColumns(10);

		JLabel lblRow = new JLabel("Sor");

		JLabel labelCol = new JLabel("Oszlop");

		JLabel labelValue = new JLabel("\u00C9rt\u00E9k");

		valueField = new JTextField();
		valueField.setEnabled(false);
		valueField.setEditable(false);
		valueField.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addContainerGap()
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addComponent(textAsking, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
										.addComponent(comboBoxDataStructure, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
										.addGroup(
												groupLayout.createSequentialGroup().addComponent(lblSize, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addComponent(comboBoxVectorStatus, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE).addGap(60).addComponent(btnImport, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)).addComponent(sizeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(
												groupLayout.createSequentialGroup().addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblRow, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addComponent(labelCol, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(colField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(rowField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
										.addGroup(groupLayout.createSequentialGroup().addComponent(labelValue, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(valueField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))).addContainerGap(10, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addGap(5).addComponent(textAsking, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(18).addComponent(comboBoxDataStructure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(comboBoxVectorStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(btnImport)).addGap(30).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblSize, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addComponent(sizeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED).addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblRow, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addComponent(rowField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(9)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(colField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(labelCol, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(valueField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(labelValue, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)).addContainerGap(67, Short.MAX_VALUE)));
		setLayout(groupLayout);

	}
}

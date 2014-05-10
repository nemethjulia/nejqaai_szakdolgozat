package GUI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

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

	private JButton btnImport;
	private JButton buttonAdd;
	private JButton buttonAddSize;
	private JButton btnDone;

	private Object newObject;
	private int size = 0;

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
		btnImport = new JButton("Beolvas\u00E1s");
		btnImport.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				comboBoxDataStructure.setEnabled(false);
				comboBoxVectorStatus.setEnabled(false);
				sizeField.setEnabled(true);
				sizeField.setEditable(true);
				btnImport.setEnabled(false);
				buttonAddSize.setEnabled(true);
			}

		});

		comboBoxDataStructure = new JComboBox<String>();
		comboBoxDataStructure.setFont(new Font("Tahoma", Font.PLAIN, 13));
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
					sizeFieldChanged();
				}
			}
		});

		rowField = new JTextField();
		rowField.setColumns(10);
		rowField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					int value = Integer.parseInt(rowField.getText());
					if (!checkIndex(value)) {
						JOptionPane.showMessageDialog(rowField, "Nem megfelelõ érték!");
						rowField.requestFocus();
					}
				} catch (NumberFormatException exc) {
					JOptionPane.showMessageDialog(rowField, "Nem megfelelõ érték!");
					rowField.requestFocus();
				}
			}

			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});

		colField = new JTextField();
		colField.setColumns(10);
		colField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					int value = Integer.parseInt(colField.getText());
					if (!checkIndex(value)) {
						JOptionPane.showMessageDialog(colField, "Nem megfelelõ érték!");
						colField.requestFocus();
					}
				} catch (NumberFormatException exc) {
					JOptionPane.showMessageDialog(colField, "Nem megfelelõ érték!");
					colField.requestFocus();
				}
			}

			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});

		JLabel lblRow = new JLabel("Sor");

		JLabel labelCol = new JLabel("Oszlop");

		JLabel labelValue = new JLabel("\u00C9rt\u00E9k");

		valueField = new JTextField();
		valueField.setToolTipText("\u00DCss\u00F6n egy Entert a folytat\u00E1shoz");
		valueField.setColumns(10);
		valueField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent arg0) {
				try {
					Double.parseDouble(valueField.getText());
				} catch (NumberFormatException exc) {
					JOptionPane.showMessageDialog(valueField, "Nem megfelelõ érték!");
					valueField.requestFocus();
				}
			}

			@Override
			public void focusGained(FocusEvent arg0) {
			}
		});
		valueField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent arg0) {
			}

			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			@Override
			public void keyPressed(KeyEvent event) {
				if (event.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
					valueFieldChanged();
				}
			}
		});

		buttonAdd = new JButton("Hozz\u00E1ad");
		buttonAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				valueFieldChanged();
			}
		});

		buttonAddSize = new JButton("Hozz\u00E1ad");
		buttonAddSize.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				sizeFieldChanged();
			}
		});

		btnDone = new JButton("K\u00E9sz");
		btnDone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (comboBoxDataStructure.getSelectedIndex() == 0) {
					if (comboBoxVectorStatus.getSelectedIndex() == 0) {
						Manager.getInstance().addXVector((MySparseVector) newObject);
					} else if (comboBoxVectorStatus.getSelectedIndex() == 1) {
						Manager.getInstance().setBVector((MySparseVector) newObject);
					}
				} else if (comboBoxDataStructure.getSelectedIndex() == 1) {
					Manager.getInstance().setMatrix((MySparseMatrix) newObject);
				}

				startStatus();
			}
		});

		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout
						.createSequentialGroup()
						.addGroup(
								groupLayout
										.createParallelGroup(Alignment.LEADING)
										.addGroup(
												groupLayout
														.createSequentialGroup()
														.addContainerGap()
														.addGroup(
																groupLayout
																		.createParallelGroup(Alignment.LEADING)
																		.addComponent(textAsking, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE)
																		.addGroup(
																				groupLayout
																						.createSequentialGroup()
																						.addGroup(
																								groupLayout
																										.createParallelGroup(Alignment.LEADING)
																										.addGroup(
																												groupLayout
																														.createSequentialGroup()
																														.addGroup(groupLayout.createParallelGroup(Alignment.LEADING).addComponent(lblRow, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addComponent(labelCol, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addComponent(lblSize, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
																														.addPreferredGap(ComponentPlacement.RELATED)
																														.addGroup(
																																groupLayout.createParallelGroup(Alignment.LEADING).addComponent(colField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(rowField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(sizeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
																																		.addComponent(comboBoxVectorStatus, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
																										.addGroup(groupLayout.createSequentialGroup().addComponent(labelValue, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(valueField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addComponent(comboBoxDataStructure, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE))
																						.addPreferredGap(ComponentPlacement.RELATED)
																						.addGroup(
																								groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup().addGap(63).addGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addComponent(buttonAddSize, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE).addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))
																										.addGroup(groupLayout.createSequentialGroup().addGap(169).addComponent(btnImport, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)))))).addGroup(groupLayout.createSequentialGroup().addGap(137).addComponent(btnDone))).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		groupLayout.setVerticalGroup(groupLayout.createParallelGroup(Alignment.LEADING).addGroup(
				groupLayout.createSequentialGroup().addGap(5).addComponent(textAsking, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(18).addComponent(comboBoxDataStructure, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(btnImport).addComponent(comboBoxVectorStatus, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(30)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblSize, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addComponent(sizeField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(buttonAddSize, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(lblRow, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addComponent(rowField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addGap(9)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(labelCol, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addComponent(colField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)).addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE).addComponent(labelValue, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addComponent(valueField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(buttonAdd, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)).addGap(18).addComponent(btnDone).addContainerGap(16, Short.MAX_VALUE)));
		setLayout(groupLayout);

		startStatus();
	}

	private void valueFieldChanged() {
		try {
			double value = Double.parseDouble(valueField.getText());
			int row = Integer.parseInt(rowField.getText());

			if (comboBoxDataStructure.getSelectedIndex() == 1) {
				int col = Integer.parseInt(colField.getText());
				((MySparseMatrix) newObject).setValue(row - 1, col - 1, value);
			} else if (comboBoxDataStructure.getSelectedIndex() == 0) {
				((MySparseVector) newObject).setValue(row - 1, value);
			}

			rowField.setText("0");
			colField.setText("0");
			valueField.setText("0");
			rowField.requestFocus();
		} catch (NumberFormatException exc) {
			JOptionPane.showMessageDialog(valueField, "Nem megfelelõ érték!");
		}
	}

	private boolean checkIndex(int i) {
		return (i > 0 || i <= size);
	}

	private void sizeFieldChanged() {
		try {
			size = Integer.parseInt(sizeField.getText());
			if (size > 0) {
				rowField.setEnabled(true);
				rowField.setEditable(true);

				if (comboBoxDataStructure.getSelectedIndex() == 1) {
					colField.setEnabled(true);
					colField.setEditable(true);
				}
				valueField.setEnabled(true);
				valueField.setEditable(true);

				sizeField.setEditable(false);
				sizeField.setEnabled(false);
				rowField.requestFocus();

				buttonAddSize.setEnabled(false);
				buttonAdd.setEnabled(true);
				btnDone.setEnabled(true);
				if (comboBoxDataStructure.getSelectedIndex() == 0) {
					newObject = new MySparseVector(size);
				} else if (comboBoxDataStructure.getSelectedIndex() == 1) {
					newObject = new MySparseMatrix(size);
				}
			}
		} catch (NumberFormatException exc) {
			JOptionPane.showMessageDialog(sizeField, "Nem megfelelõ érték!");
		}
	}

	private void startStatus() {

		comboBoxDataStructure.setEnabled(true);
		comboBoxVectorStatus.setEnabled(true);
		btnImport.setEnabled(true);

		sizeField.setEnabled(false);
		sizeField.setEditable(false);
		rowField.setEnabled(false);
		rowField.setEditable(false);
		colField.setEnabled(false);
		colField.setEditable(false);
		valueField.setEnabled(false);
		valueField.setEditable(false);

		buttonAddSize.setEnabled(false);
		buttonAdd.setEnabled(false);
		btnDone.setEnabled(false);

		sizeField.setText("0");
		rowField.setText("0");
		colField.setText("0");
		valueField.setText("0");
	}
}

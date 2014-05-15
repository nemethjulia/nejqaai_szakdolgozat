package gui.methodComponents;

import gui.Manager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import algorithms.ConjugateGradientMethod;
import algorithms.GaussSeidelMethod;
import algorithms.GradientMethod;
import algorithms.JacobiMethod;
import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

public class MethodComponent extends JPanel {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = 1304131196764873253L;

	private Manager manager;

	private JTextField stepNumberField;
	private JCheckBox boxJacobi;
	private JCheckBox boxGaussSeidel;
	private JCheckBox boxGradiens;
	private JCheckBox boxKonjugaltGradiens;
	private JTabbedPane tabbedPane;
	private JComboBox<String> x0ComboBox;

	public MethodComponent() {

		manager = Manager.getInstance();

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 0, 0, 0, 25, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		JPanel filterPanel = new JPanel();
		filterPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		GridBagConstraints gbc_filterPanel = new GridBagConstraints();
		gbc_filterPanel.insets = new Insets(0, 0, 5, 0);
		gbc_filterPanel.gridwidth = 7;
		gbc_filterPanel.gridheight = 7;
		gbc_filterPanel.fill = GridBagConstraints.BOTH;
		gbc_filterPanel.gridx = 0;
		gbc_filterPanel.gridy = 0;
		add(filterPanel, gbc_filterPanel);

		JLabel lblKremVlasszonAz = new JLabel("K\u00E9rem, v\u00E1lasszon az al\u00E1bbi lehet\u0151s\u00E9gekb\u0151l!");
		lblKremVlasszonAz.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblKremVlasszonAz.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel stepNumber = new JLabel("L\u00E9p\u00E9ssz\u00E1m: ");

		stepNumberField = new JTextField();
		stepNumberField.setColumns(10);

		x0ComboBox = new JComboBox<String>();
		x0ComboBox.setMaximumRowCount(10);

		String[] x0Strings = manager.getxVectorsString();
		x0ComboBox.setModel(new DefaultComboBoxModel<String>(x0Strings));
		if (x0Strings.length > 0) {
			x0ComboBox.setSelectedIndex(0);
		}
		x0ComboBox.setPreferredSize(new Dimension(180, 30));

		JButton startProcessButton = new JButton("M\u00F3dszer(ek) ind\u00EDt\u00E1sa");
		startProcessButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				startProcess();
			}
		});
		if (!manager.hasGoodData()) { // ha az adatok nem jók, akkor nem lehet elkezdeni a folyamatot
			startProcessButton.setEnabled(false);
		}

		boxJacobi = new JCheckBox("Jacobi iter\u00E1ci\u00F3");

		boxGaussSeidel = new JCheckBox("Gauss-Seidel iter\u00E1ci\u00F3");

		boxGradiens = new JCheckBox("Gradiens m\u00F3dszer");

		boxKonjugaltGradiens = new JCheckBox("Konjug\u00E1lt Gradiens m\u00F3dszer");

		GroupLayout gl_filterPanel = new GroupLayout(filterPanel);
		gl_filterPanel.setHorizontalGroup(gl_filterPanel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_filterPanel
						.createSequentialGroup()
						.addGroup(
								gl_filterPanel
										.createParallelGroup(Alignment.LEADING)
										.addGroup(
												gl_filterPanel
														.createSequentialGroup()
														.addGap(50)
														.addGroup(
																gl_filterPanel
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(
																				gl_filterPanel
																						.createSequentialGroup()
																						.addGroup(
																								gl_filterPanel.createParallelGroup(Alignment.LEADING, false).addComponent(x0ComboBox, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																										.addGroup(gl_filterPanel.createSequentialGroup().addComponent(stepNumber, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE).addPreferredGap(ComponentPlacement.RELATED).addComponent(stepNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))).addGap(78)
																						.addGroup(gl_filterPanel.createParallelGroup(Alignment.LEADING).addComponent(boxGaussSeidel).addComponent(boxJacobi)).addGap(74).addGroup(gl_filterPanel.createParallelGroup(Alignment.LEADING).addComponent(boxGradiens).addComponent(boxKonjugaltGradiens))).addComponent(lblKremVlasszonAz, GroupLayout.PREFERRED_SIZE, 700, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_filterPanel.createSequentialGroup().addGap(220).addComponent(startProcessButton))).addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		gl_filterPanel.setVerticalGroup(gl_filterPanel.createParallelGroup(Alignment.LEADING).addGroup(
				gl_filterPanel.createSequentialGroup().addContainerGap().addComponent(lblKremVlasszonAz, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addGap(18).addGroup(gl_filterPanel.createParallelGroup(Alignment.BASELINE).addComponent(stepNumber, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE).addComponent(stepNumberField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(boxJacobi).addComponent(boxGradiens)).addGap(18)
						.addGroup(gl_filterPanel.createParallelGroup(Alignment.BASELINE).addComponent(x0ComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE).addComponent(boxGaussSeidel).addComponent(boxKonjugaltGradiens)).addGap(18).addComponent(startProcessButton).addContainerGap(19, Short.MAX_VALUE)));
		filterPanel.setLayout(gl_filterPanel);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.gridwidth = 7;
		gbc_tabbedPane.insets = new Insets(0, 0, 0, 5);
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 7;
		add(tabbedPane, gbc_tabbedPane);

	}

	private void startProcess() {
		try {
			if (x0ComboBox.getSelectedIndex() < 0) {
				showMessage("Nem megfelelõ érték: nincs kiválasztva kezdõvektor!");
			} else {
				MySparseVector x = manager.getxVectors().get(x0ComboBox.getSelectedIndex());
				MySparseVector b = manager.getBVector();
				MySparseMatrix a = manager.getMatrix();

				if (x.getSize() != b.getSize()) {
					showMessage("Nem megfelelõ érték: A kezdõ- és jobboldali vektorok mérete nem egyezik!");
				} else {
					int stepNumber = Integer.parseInt(stepNumberField.getText());
					if (stepNumber <= 0) {
						showMessage("Nem megfelelõ érték: Lépések száma!");
					} else {
						boolean jacobiKell = boxJacobi.isSelected();
						boolean gSKell = boxGaussSeidel.isSelected();
						boolean gradiensKell = boxGradiens.isSelected();
						boolean kGradiensKell = boxKonjugaltGradiens.isSelected();
						if (!(jacobiKell || gSKell || gradiensKell || kGradiensKell)) {
							showMessage("Nem megfelelõ érték: Nincs kiválasztva módszer!");
						} else {
							tabbedPane.removeAll();
							if (jacobiKell) {
								tabbedPane.addTab("Jacobi iteráció", new MethodResultPanel(new JacobiMethod(stepNumber), a, b, x));
							}
							if (gSKell) {
								tabbedPane.addTab("Gauss-Seidel iteráció", new MethodResultPanel(new GaussSeidelMethod(stepNumber), a, b, x));
							}
							if (gradiensKell) {
								tabbedPane.addTab("Gradiens módszer", new MethodResultPanel(new GradientMethod(stepNumber), a, b, x));
							}
							if (kGradiensKell) {
								tabbedPane.addTab("Konjugált Gradiens módszer", new MethodResultPanel(new ConjugateGradientMethod(stepNumber), a, b, x));
							}

							pack();
						}
					}
				}
			}

		} catch (NumberFormatException ex) {
			showMessage("Nem megfelelõ érték: Lépések száma!");
		}
	}

	private void showMessage(String msg) {
		manager.showMessage(msg);
	}

	public void pack() {
		((JFrame) getParent().getParent().getParent().getParent()).pack();
	}
}

package gui.fileComponents.showDataStructures;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import datastructures.MySparseVector;
import datastructures.VectorItem;

public class VectorComponent extends JPanel {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = -2466355130444457788L;

	public VectorComponent(MySparseVector vector) {
		setBorder(new LineBorder(new Color(0, 0, 0)));

		int size = vector.getSize();
		List<VectorItem> data = vector.getData();

		int[] colWidth = new int[size];
		int[] rowHeight = new int[1];

		if (size > 12) {
			for (int i = 0; i < size; i++) {
				colWidth[i] = 25;
			}
		} else if (size > 0) {
			for (int i = 0; i < size; i++) {
				colWidth[i] = getWidth() / size;
			}
		}
		rowHeight[0] = 20;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = colWidth;
		gridBagLayout.rowHeights = rowHeight;
		gridBagLayout.columnWeights = new double[] {};
		gridBagLayout.rowWeights = new double[] { 0.0 };
		setLayout(gridBagLayout);

		int row = 0;
		for (int i = 0; i < data.size(); i++) {
			VectorItem item = data.get(i);
			if (item.getIndex() > row) {

				for (; row < item.getIndex(); ++row) {
					JLabel label = new JLabel("0.0");
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.anchor = GridBagConstraints.CENTER;
					gbc.insets = new Insets(0, 0, 0, 5);
					gbc.gridx = row;
					gbc.gridy = 0;
					add(label, gbc);
				}
			}

			if (item.getIndex() == row) {
				JLabel label = new JLabel(String.valueOf(item.getValue()));
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.anchor = GridBagConstraints.CENTER;
				gbc.insets = new Insets(0, 0, 0, 5);
				gbc.gridx = row;
				gbc.gridy = 0;
				add(label, gbc);
				row++;
			}
		}

		if (row < size) {
			for (; row < size; ++row) {
				JLabel label = new JLabel("0.0");
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.anchor = GridBagConstraints.CENTER;
				gbc.insets = new Insets(0, 0, 0, 5);
				gbc.gridx = row;
				gbc.gridy = 0;
				add(label, gbc);
			}
		}
	}
}

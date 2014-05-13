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

public class VectorJustDataComponent extends JPanel {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = -2466355130444457788L;

	public VectorJustDataComponent(MySparseVector vector) {
		setBorder(new LineBorder(new Color(0, 0, 0)));

		List<VectorItem> data = vector.getData();
		int size = data.size();

		int[] colWidth = new int[size];
		int[] rowHeight = new int[1];

		for (int i = 0; i < size; i++) {
			colWidth[i] = 25;
		}
		rowHeight[0] = 20;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = colWidth;
		gridBagLayout.rowHeights = rowHeight;
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		for (int i = 0; i < size; i++) {
			VectorItem item = data.get(i);
			JLabel label = new JLabel("[" + item.getIndex() + " | " + String.valueOf(item.getValue()) + "]");
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.insets = new Insets(0, 0, 0, 5);
			gbc.gridx = i;
			gbc.gridy = 0;
			add(label, gbc);
		}

	}
}

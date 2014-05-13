package gui.fileComponents.showDataStructures;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JPanel;

import datastructures.MySparseVector;

public class MultipleVectorJustDataComponent extends JPanel {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = -208873879897753580L;

	public MultipleVectorJustDataComponent(List<MySparseVector> xVectors) {

		int size = xVectors.size();

		int[] colWidth = new int[1];
		int[] rowHeight = new int[size];

		for (int i = 0; i < size; i++) {
			rowHeight[i] = 20;
		}
		if (size > 0) {
			colWidth[0] = xVectors.get(0).getSize() * 25;
		}

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = colWidth;
		gridBagLayout.rowHeights = rowHeight;
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		for (int i = 0; i < xVectors.size(); i++) {
			VectorJustDataComponent comp = new VectorJustDataComponent(xVectors.get(i));
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.insets = new Insets(0, 0, 0, 5);
			gbc.gridx = 0;
			gbc.gridy = i;
			add(comp, gbc);
		}

	}
}

package gui.fileComponents.showDataStructures;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import datastructures.MatrixItem;
import datastructures.MySparseMatrix;

public class MatrixJustDataComponent extends JPanel {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = 6179586084696826085L;

	public MatrixJustDataComponent(MySparseMatrix matrix) {

		List<MatrixItem> data = matrix.getData();
		int size = data.size();

		int[] colWidth = new int[1];
		int[] rowHeight = new int[size];

		for (int i = 0; i < size; i++) {
			rowHeight[i] = 20;
		}

		colWidth[0] = 30;

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = colWidth;
		gridBagLayout.rowHeights = rowHeight;
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		for (int i = 0; i < data.size(); i++) {
			MatrixItem item = data.get(i);
			JLabel label = new JLabel("[" + item.getRow() + ", " + item.getCol() + " | " + String.valueOf(item.getValue()) + "]");
			GridBagConstraints gbc = new GridBagConstraints();
			gbc.anchor = GridBagConstraints.CENTER;
			gbc.insets = new Insets(0, 0, 0, 5);
			gbc.gridx = 0;
			gbc.gridy = i;
			add(label, gbc);
		}

	}
}

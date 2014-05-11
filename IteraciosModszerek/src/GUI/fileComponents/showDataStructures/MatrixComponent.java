package GUI.fileComponents.showDataStructures;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import datastructures.MatrixItem;
import datastructures.MySparseMatrix;

public class MatrixComponent extends JPanel {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = 6179586084696826085L;

	public MatrixComponent(MySparseMatrix matrix) {
		setSize(400, 100);

		int size = matrix.getSize();
		List<MatrixItem> data = matrix.getData();

		int[] colWidth = new int[size];
		int[] rowHeight = new int[size];

		for (int i = 0; i < size; i++) {
			colWidth[i] = getWidth() / size;
			rowHeight[i] = getHeight() / size;
		}

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = colWidth;
		gridBagLayout.rowHeights = rowHeight;
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		setLayout(gridBagLayout);

		int row = 0;
		int col = 0;
		for (int i = 0; i < data.size(); i++) {
			MatrixItem item = data.get(i);
			if (item.getRow() > row) {
				for (; row < item.getRow(); ++row) {
					for (; col < size; ++col) {
						JLabel label = new JLabel("0.0");
						GridBagConstraints gbc = new GridBagConstraints();
						gbc.anchor = GridBagConstraints.CENTER;
						gbc.insets = new Insets(0, 0, 0, 5);
						gbc.gridx = col;
						gbc.gridy = row;
						add(label, gbc);
					}
					col = 0;
				}
			}
			if (item.getRow() == row) {
				if (col < item.getCol()) {
					for (; col < item.getCol(); ++col) {
						JLabel label = new JLabel("0.0");
						GridBagConstraints gbc = new GridBagConstraints();
						gbc.anchor = GridBagConstraints.CENTER;
						gbc.insets = new Insets(0, 0, 0, 5);
						gbc.gridx = col;
						gbc.gridy = row;
						add(label, gbc);
					}
				}
				if (col == item.getCol()) {
					JLabel label = new JLabel(String.valueOf(item.getValue()));
					GridBagConstraints gbc = new GridBagConstraints();
					gbc.anchor = GridBagConstraints.CENTER;
					gbc.insets = new Insets(0, 0, 0, 5);
					gbc.gridx = col;
					gbc.gridy = row;
					add(label, gbc);
					++col;
				}
				if (col == size) {
					row++;
					col = 0;
				}
			}
		}

	}
}

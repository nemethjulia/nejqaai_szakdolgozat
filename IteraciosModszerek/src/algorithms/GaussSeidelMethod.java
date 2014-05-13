package algorithms;

import java.util.List;

import datastructures.MatrixItem;
import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

/**
 * @author julcsi
 * 
 */
public class GaussSeidelMethod extends Method {

	public GaussSeidelMethod(int numberOfSteps) {
		super(numberOfSteps);
	}

	@Override
	public MySparseVector iterationStep(MySparseVector x, MySparseMatrix m, MySparseVector b) {
		int n = x.getSize();
		MySparseVector xnew = new MySparseVector(n);
		List<MatrixItem> data = m.getData();
		int row = 0;
		double rowsum = 0;
		double diag = 0;
		double value = 0;
		for (MatrixItem i : data) {
			if (i.getRow() != row) {
				value = (b.getValue(row) - rowsum) * (1 / diag);
				xnew.setValue(row, value);
				row = i.getRow();
				rowsum = 0;
			}

			if (i.getCol() == row)
				diag = i.getValue();
			else if (i.getCol() > row)
				rowsum += i.getValue() * x.getValue(i.getCol());
			else
				rowsum += i.getValue() * xnew.getValue(i.getCol());
		}
		value = (b.getValue(row) - rowsum) * (1 / diag);
		xnew.setValue(row, value);

		return xnew;
	}

}

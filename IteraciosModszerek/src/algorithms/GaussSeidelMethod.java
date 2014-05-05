package algorithms;

import java.util.List;

import datastructures.*;

/**
 * @author julcsi
 * 
 */
public class GaussSeidelMethod {

	public MySparseVector solve(MySparseMatrix a, MySparseVector b, MySparseVector x0) {
		// TODO ellenorizzuk, h szigoruan diagonalisan dominans-e, es ha nem,
		// dobjunk egy baszott nagy exception-t
		List<MatrixItem> m = a.getData();
		MySparseVector x = x0.clone();
		int i = 0;
		while (i < 20) {
			x = iterationStep(x, m, b);
			++i;
		}

		return x;
	}

	public MySparseVector iterationStep(MySparseVector x, List<MatrixItem> m, MySparseVector b) {
		int n = x.getSize();
		MySparseVector xnew = new MySparseVector(n);
		int row = 0;
		double rowsum = 0;
		double diag = 0;
		double value = 0;
		for (MatrixItem i : m) {
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

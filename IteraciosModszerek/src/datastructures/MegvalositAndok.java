package datastructures;

import java.util.List;

public class MegvalositAndok {

	public static MySparseVector residumVector(MySparseMatrix A, MySparseVector x, MySparseVector b) {
		int n = x.getSize();
		MySparseVector r = new MySparseVector(n);
		List<MatrixItem> m = A.getData();
		int row = m.get(0).getRow();
		double rowsum = 0;
		double value = 0;
		for (MatrixItem i : m) {
			if (i.getRow() != row) {
				value = b.getValue(row) - rowsum;
				r.setValue(row, value);
				row = i.getRow();
				rowsum = 0;
			}

			rowsum += i.getValue() * x.getValue(i.getCol());
		}
		value = b.getValue(row) - rowsum;
		r.setValue(row, value);

		return r;
	}
}

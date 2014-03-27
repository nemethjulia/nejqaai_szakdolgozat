
import java.util.List;

import datastructures.*;

public class MegvalositAndok {

	public MySparseVector residumVector(MySparseMatrix A, MySparseVector x, MySparseVector b) {
		int n = x.getSize();
		MySparseVector r = new MySparseVector(n);
		List<MatrixItem> m = A.getData();
		int row = m.get(0).getI();
		double rowsum = 0;
		double value = 0;
		for (MatrixItem i : m) {
			if (i.getI() != row) {
				value = b.getValue(row) - rowsum;
				r.setValue(row, value);
				row = i.getI();
				rowsum = 0;
			}

			rowsum += i.getValue() * x.getValue(i.getJ());
		}
		value = b.getValue(row) - rowsum;
		r.setValue(row, value);

		return r;
	}

}

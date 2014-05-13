package algorithms;

import java.util.List;

import datastructures.MatrixItem;
import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

/**
 * @author julcsi
 * 
 */
public class GradientMethod extends Method {

	public GradientMethod(int numberOfSteps) {
		super(numberOfSteps);
	}

	@Override
	public MySparseVector iterationStep(MySparseVector x, MySparseMatrix m, MySparseVector b) {
		int n = x.getSize();
		MySparseVector xnew = new MySparseVector(n);
		List<MatrixItem> data = m.getData();

		// rk eloallitasa rk=b-A*x(k-1)

		// segedvaltozok
		int row = 0;
		double rowsum = 0;
		double value = 0;

		MySparseVector rk = new MySparseVector(n);

		for (MatrixItem i : data) {
			if (i.getRow() != row) {
				value = b.getValue(row) - rowsum;
				rk.setValue(row, value);
				row = i.getRow();
				rowsum = 0;
			} else
				rowsum += i.getValue() * x.getValue(i.getCol());
		}
		value = b.getValue(row) - rowsum;
		rk.setValue(row, value);

		// alpha kiszamitasa

		// szamlalo

		double szamlalo = 0;
		value = 0;

		for (int i = 0; i < n; ++i) {
			value = rk.getValue(i);
			szamlalo += value * value;
		}

		// nevezo

		// kihasznaljuk, h a matrix szimmetrikus

		row = 0;
		rowsum = 0;

		MySparseVector current = new MySparseVector(n);

		for (MatrixItem i : data) {
			if (i.getRow() != row) {
				current.setValue(row, rowsum);
				row = i.getRow();
				rowsum = 0;
			} else
				rowsum += i.getValue() * rk.getValue(i.getCol());
		}
		current.setValue(row, rowsum);

		double nevezo = 0;

		for (int i = 0; i < n; ++i) {
			nevezo += current.getValue(i) * rk.getValue(i);
		}

		// es vegre az alpha

		double alpha = szamlalo / nevezo;

		// xnew kiszmolasa : xk=x(k-1) + alpha * rk

		for (int i = 0; i < n; ++i) {
			xnew.setValue(i, x.getValue(i) + alpha * rk.getValue(i));
		}

		return xnew;
	}
}

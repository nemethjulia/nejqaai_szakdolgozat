package algorithms;

import java.util.List;

import datastructures.MatrixItem;
import datastructures.MySparseMatrix;
import datastructures.MySparseVector;
import exceptions.IsNotPositiveDefinite;
import exceptions.IsNotSymmetryc;

/**
 * @author julcsi
 * 
 */
public class GradientMethod extends Method {

	public GradientMethod(int numberOfSteps) {
		super(numberOfSteps);
	}

	@Override
	protected void throwExceptions(MySparseMatrix a) throws Exception {
		if (!a.isSymmetryc()) {
			throw new IsNotSymmetryc("Nem szimmetrikus a mátrix!");
		}

		if (!a.isPositiveDefinite()) {
			throw new IsNotPositiveDefinite("Nem pozitív definit a mátrix!");
		}

	}

	@Override
	public MySparseVector iterationStep(MySparseVector x, List<MatrixItem> m, MySparseVector b) {
		int n = x.getSize();
		MySparseVector xnew = new MySparseVector(n);

		// rk eloallitasa rk=b-A*x(k-1)

		// segedvaltozok
		int row = 0;
		double rowsum = 0;
		double value = 0;

		MySparseVector rk = new MySparseVector(n);

		for (MatrixItem i : m) {
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

		for (MatrixItem i : m) {
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

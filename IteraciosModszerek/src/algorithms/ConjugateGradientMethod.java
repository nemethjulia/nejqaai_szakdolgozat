package algorithms;

import java.util.List;

import datastructures.MatrixItem;
import datastructures.MySparseMatrix;
import datastructures.MySparseVector;
import exceptions.IsNotPositiveDefinite;
import exceptions.IsNotSymmetryc;
import exceptions.NotSameSize;

public class ConjugateGradientMethod extends Method {

	MySparseVector rm;
	MySparseVector vm;

	public ConjugateGradientMethod(int numberOfStreps) {
		super(numberOfStreps);
	}

	@Override
	public MySparseVector iterationStep(MySparseVector x, List<MatrixItem> m, MySparseVector b) {

		MySparseVector xnew = null;
		try {
			rm = b.substract(multiple(m, x));
			if (rm == null || vm == null) {
				vm = rm;
			} else {
				double beta = 0 - (vm.multiple(multiple(m, rm)) / vm.multiple(multiple(m, vm)));
				vm = rm.add(vm.multiple(beta));
			}

			double szamlalo = vm.multiple(multiple(m, vm));
			if (Double.isNaN(szamlalo) || szamlalo == 0.0) {
				return x;
			}
			double alpha = vm.multiple(rm) / szamlalo;

			xnew = x.add(vm.multiple(alpha));
		} catch (NotSameSize e) {
			e.printStackTrace();
		}

		return xnew;
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

	private MySparseVector multiple(List<MatrixItem> m, MySparseVector v) {
		MySparseVector result = new MySparseVector(v.getSize());

		int row = 0;
		double rowsum = 0;
		for (MatrixItem i : m) {
			if (i.getRow() != row) {
				result.setValue(row, rowsum);
				row = i.getRow();
				rowsum = 0;
			}

			rowsum += i.getValue() * v.getValue(i.getCol());
		}
		result.setValue(row, rowsum);

		return result;
	}

}

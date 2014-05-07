package algorithms;

import java.util.List;

import datastructures.MatrixItem;
import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

public class Method {

	protected int numberOfSteps = 0;

	public Method(int numberOfSteps) {
		this.numberOfSteps = numberOfSteps;
	}

	public MySparseVector solve(MySparseMatrix a, MySparseVector b, MySparseVector x0) throws Exception {

		throwExceptions(a);

		List<MatrixItem> m = a.getData();
		MySparseVector x = x0.clone();
		int i = 0;
		while (i < numberOfSteps) {
			x = iterationStep(x, m, b);
			++i;
		}

		return x;
	}

	public MySparseVector iterationStep(MySparseVector x, List<MatrixItem> m, MySparseVector b) {
		throw new RuntimeException("This is an abstract class!");
	}

	protected void throwExceptions(MySparseMatrix a) throws Exception {
		throw new RuntimeException("This is an abstract class!");
	}
}

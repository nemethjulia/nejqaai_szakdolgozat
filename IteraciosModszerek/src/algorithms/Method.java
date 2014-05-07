package algorithms;

import java.util.List;

import datastructures.MatrixItem;
import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

public interface Method {

	public MySparseVector solve(MySparseMatrix a, MySparseVector b, MySparseVector x0) throws Exception;

	public MySparseVector iterationStep(MySparseVector x, List<MatrixItem> m, MySparseVector b);

}

package algorithms;

import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

/**
 * @author julcsi
 * 
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		MySparseVector b = new MySparseVector(3);
		b.setValue(0, 3);
		b.setValue(1, -1);
		b.setValue(2, 4);
		MySparseMatrix a = new MySparseMatrix(3);
		a.setValue(0, 0, 4);
		a.setValue(0, 1, 2);
		a.setValue(0, 2, 1);
		a.setValue(1, 0, 2);
		a.setValue(1, 1, 4);
		a.setValue(1, 2, 1);
		a.setValue(2, 0, 1);
		a.setValue(2, 1, 1);
		a.setValue(2, 2, 4);
		System.out.println(a);
		System.out.println(b);
		MySparseVector x = new MySparseVector(3);
		x.setValue(0, 1);
		x.setValue(1, 1);
		x.setValue(2, 1);
		System.out.println(x);
		JacobiMethod j = new JacobiMethod(30);
		MySparseVector mySparseVector = j.solve(a, b, x);
		System.out.println(mySparseVector);

		GaussSeidelMethod gs = new GaussSeidelMethod(30);
		mySparseVector = gs.solve(a, b, x);
		System.out.println(mySparseVector);

	}

}

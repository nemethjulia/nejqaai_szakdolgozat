package algorithms;

import java.util.ArrayList;
import java.util.List;

import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

public abstract class Method {

	protected int numberOfSteps = 0;

	public List<Double> residumNorms;
	public List<Double> qs;

	public Method(int numberOfSteps) {
		this.numberOfSteps = numberOfSteps;
	}

	public MySparseVector solve(MySparseMatrix a, MySparseVector b, MySparseVector x0) {

		residumNorms = new ArrayList<Double>();
		qs = new ArrayList<Double>();
		List<MySparseVector> xns = new ArrayList<MySparseVector>();
		MySparseVector x = x0.clone();
		xns.add(x);
		int i = 0;
		boolean needMoreStep = true;
		while (i < numberOfSteps && needMoreStep) {
			x = iterationStep(x, a, b);
			xns.add(x);

			MySparseVector resVector = b.substract(a.multiple(x));
			residumNorms.add(resVector.norm());
			if (i > 2) {
				double q = x.substract(xns.get(i - 1)).norm() / xns.get(i - 1).substract(xns.get(i - 2)).norm();
				qs.add(q);
			}
			/*
			 * TODO valamit ide kitalálni
			 */
			if (!needMoreStep) {
				needMoreStep = false;
			}
			++i;
		}

		return x;
	}

	public abstract MySparseVector iterationStep(MySparseVector x, MySparseMatrix m, MySparseVector b);
}

package algorithms;

import java.util.ArrayList;
import java.util.List;

import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

public abstract class Method {

	protected int numberOfSteps = 0;

	public List<Double> residumNorms;
	public List<Double> qs;
	public int lastStepNumber;

	public Method(int numberOfSteps) {
		this.numberOfSteps = numberOfSteps;
	}

	public MySparseVector solve(MySparseMatrix a, MySparseVector b, MySparseVector x0) {

		residumNorms = new ArrayList<Double>();
		qs = new ArrayList<Double>();
		List<MySparseVector> xns = new ArrayList<MySparseVector>();
		MySparseVector x = x0.clone();
		MySparseVector resVector = b.substract(a.multiple(x));
		residumNorms.add(resVector.norm());
		xns.add(x);
		int i = 0;
		boolean needMoreStep = true;
		while (i < numberOfSteps && needMoreStep) {
			x = iterationStep(x, a, b);
			xns.add(x);

			resVector = b.substract(a.multiple(x));
			residumNorms.add(resVector.norm());
			if (i > 2) {
				xns.remove(0);
				double szamlalo = x.substract(xns.get(1)).norm();
				double nevezo = xns.get(1).substract(xns.get(0)).norm();
				if (nevezo == 0.0) {
					needMoreStep = false;
				} else {
					double q = szamlalo / nevezo;
					qs.add(q);
					if (i > 5 && q > 5) {
						needMoreStep = false;
						lastStepNumber = i + 1;
					}
				}
			}
			++i;
		}
		lastStepNumber = i;

		return x;
	}

	public abstract MySparseVector iterationStep(MySparseVector x, MySparseMatrix m, MySparseVector b);
}

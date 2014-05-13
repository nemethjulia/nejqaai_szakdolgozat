package algorithms;

import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

public class ConjugateGradientMethod extends Method {

	MySparseVector rm;
	MySparseVector vm;

	public ConjugateGradientMethod(int numberOfStreps) {
		super(numberOfStreps);
	}

	@Override
	public MySparseVector iterationStep(MySparseVector x, MySparseMatrix m, MySparseVector b) {

		MySparseVector xnew = null;

		rm = b.substract(m.multiple(x));
		if (rm == null || vm == null) {
			vm = rm;
		} else {
			double beta = 0 - (vm.multiple(m.multiple(rm)) / vm.multiple(m.multiple(vm)));
			vm = rm.add(vm.multiple(beta));
		}

		double szamlalo = vm.multiple(m.multiple(vm));
		if (Double.isNaN(szamlalo) || szamlalo == 0.0) {
			return x;
		}
		double alpha = vm.multiple(rm) / szamlalo;

		xnew = x.add(vm.multiple(alpha));

		return xnew;
	}

}

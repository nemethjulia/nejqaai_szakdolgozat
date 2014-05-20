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
		if (vm == null) {
			vm = rm;
		} else {
			double beta = 0 - (vm.multiple(m.multiple(rm))) / (vm.multiple(m.multiple(vm)));
			vm = rm.add(vm.multiple(beta));
		}
		double nevezo = vm.multiple(m.multiple(vm));
		if (Double.isNaN(nevezo) || nevezo == 0.0) {
			return x;
		}
		double alpha = rm.multiple(rm) / nevezo;

		xnew = x.add(vm.multiple(alpha));

		/*
		 * MySparseVector rOld = rm.clone(); rm = rm.substract(m.multiple(vm).multiple(alpha)); double beta = rm.multiple(rm) / rOld.multiple(m.multiple(rOld)); vm = rm.add(vm.multiple(beta));
		 */

		return xnew;
	}

}

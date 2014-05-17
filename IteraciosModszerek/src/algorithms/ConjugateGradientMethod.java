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

		if (rm == null || vm == null) {
			rm = b.clone();
			vm = rm;
		}
		double nevezo = vm.multiple(m.multiple(vm));
		if (Double.isNaN(nevezo) || nevezo == 0.0) {
			return x;
		}
		double alpha = vm.multiple(rm) / nevezo;

		xnew = x.add(vm.multiple(alpha));

		rm = rm.substract(m.multiple(vm).multiple(alpha));
		double beta = vm.multiple(m.multiple(rm)) / vm.multiple(m.multiple(vm));
		vm = rm.substract(vm.multiple(beta));

		return xnew;
	}

}

package algorithms;

import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

/**
 * @author julcsi
 * 
 */
public class GradientMethod extends Method {

	public GradientMethod(int numberOfSteps) {
		super(numberOfSteps);
	}

	@Override
	public MySparseVector iterationStep(MySparseVector x, MySparseMatrix m, MySparseVector b) {
		// rk eloallitasa rk=b-A*x(k-1)

		MySparseVector rk = b.substract(m.multiple(x));

		// alpha kiszamitasa

		// szamlalo
		// r(k-1)T * r(k-1)

		double szamlalo = rk.multiple(rk);

		// nevezo
		// r(k-1)T * A * r(k-1)

		// kihasznaljuk, h a matrix szimmetrikus

		double nevezo = rk.multiple(m.multiple(rk));

		// es vegre az alpha

		double alpha = szamlalo / nevezo;

		// xnew kiszmolasa : xk=x(k-1) + alpha * rk

		MySparseVector xnew = x.add(rk.multiple(alpha));

		return xnew;
	}
}

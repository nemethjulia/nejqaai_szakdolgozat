package gui.methodComponents;

import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.JFreeChart;

import algorithms.Method;
import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

public class MethodResultPanel extends JPanel {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = -8243608542088224912L;

	public MethodResultPanel(Method method, MySparseMatrix a, MySparseVector b, MySparseVector x) {
		List<MySparseVector> xns = method.solve(a, b, x);
		List<Double> resNorms = method.residumNorms;
		List<Double> qs = method.qs;
	}

	private JFreeChart createChart() {

		return null;
	}

}

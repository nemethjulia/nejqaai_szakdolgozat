package gui.methodComponents;

import gui.fileComponents.showDataStructures.VectorComponent;
import gui.fileComponents.showDataStructures.VectorJustDataComponent;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import algorithms.Method;
import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

public class MethodResultPanel extends JPanel {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = -8243608542088224912L;

	private String X_N_Names = "X_N_Names";

	private MySparseVector xn;

	public MethodResultPanel(Method method, MySparseMatrix a, MySparseVector b, MySparseVector x) {
		xn = method.solve(a, b, x);
		List<Double> resNorms = method.residumNorms;
		List<Double> qs = method.qs;
		add(createChart(qs, "qs", X_N_Names, "q értéke"));
		add(createChart(resNorms, "resNorms", X_N_Names, "resNorms értéke"));

		JPanel panel = new JPanel();
		add(panel);

		JTabbedPane xVectorArea = new JTabbedPane();
		VectorComponent xVectorcomp = new VectorComponent(xn);
		JScrollPane xVectorScroller = new JScrollPane(xVectorcomp);
		VectorJustDataComponent xVectorJDcomp = new VectorJustDataComponent(xn);
		JScrollPane xVectorJDScroller = new JScrollPane(xVectorJDcomp);
		xVectorArea.addTab("Az eredményvektor teljes ábrázolása", xVectorScroller);
		xVectorArea.addTab("Csak az eredményvektor nem 0 elemei", xVectorJDScroller);

		xVectorArea.setBounds(476, 64, 252, 224);
		panel.add(xVectorArea);
		JButton exportXButton = new JButton("Az eredményvektor exportálása");
		panel.add(exportXButton);
		JButton runMoreButton = new JButton("Iteráció folytatása");
		runMoreButton.setToolTipText("Iteráció folytatása az eredményvektorral");
		panel.add(runMoreButton);

	}

	private ChartPanel createChart(List<Double> doubles, String title, String categoryAxisLabel, String valueAxisLabel) {
		JFreeChart chart = ChartFactory.createBarChart(title, categoryAxisLabel, valueAxisLabel, getDataSet(doubles));
		ChartPanel panel = new ChartPanel(chart);

		panel.setPreferredSize(new Dimension(300, 300));

		return panel;
	}

	private CategoryDataset getDataSet(List<Double> doubles) {
		DefaultCategoryDataset result = new DefaultCategoryDataset();
		for (int i = 0; i < doubles.size(); i++) {
			result.setValue(doubles.get(i), X_N_Names, "x" + i);
		}
		return result;
	}
}

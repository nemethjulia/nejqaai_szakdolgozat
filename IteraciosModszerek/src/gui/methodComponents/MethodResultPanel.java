package gui.methodComponents;

import gui.Manager;
import gui.fileComponents.showDataStructures.VectorComponent;
import gui.fileComponents.showDataStructures.VectorJustDataComponent;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

import algorithms.ConjugateGradientMethod;
import algorithms.GaussSeidelMethod;
import algorithms.GradientMethod;
import algorithms.JacobiMethod;
import algorithms.Method;

import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;

import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

public class MethodResultPanel extends JPanel {

	/**
	 * Auto generated serialVersion UID
	 */
	private static final long serialVersionUID = -8243608542088224912L;

	private MySparseVector xn;
	private JTextField stepNumberField;

	private Method method;
	private MySparseMatrix a;
	private MySparseVector b;

	private JPanel qChartPanel;
	private JPanel resChartPanel;

	private VectorComponent resultVectorComponent;
	private VectorJustDataComponent resultVectorJustDataComponent;

	public MethodResultPanel(Method method, MySparseMatrix a, MySparseVector b, MySparseVector x) {
		this.method = method;
		this.a = a;
		this.b = b;
		stepNumberField = new JTextField();
		stepNumberField.setText(String.valueOf(0));

		makePanel(x);

	}

	private void makePanel(MySparseVector x) {
		xn = method.solve(a, b, x);
		List<Double> resNorms = method.residumNorms;
		List<Double> qs = method.qs;
		qChartPanel = createChart(qs, "Tapasztalati kontrakciós együttható változása", "Iterációs lépés száma", "Együttható értéke", 3);
		add(qChartPanel);
		resChartPanel = createChart(resNorms, "Rezidumvektor normájának változása", "Iterációs lépés száma", "r normájának értéke", 0);
		add(resChartPanel);

		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("500px:grow"), }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("80px"), FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("30px:grow"), FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("30px"), FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("30px"), }));

		JTabbedPane xVectorArea = new JTabbedPane();
		resultVectorComponent = new VectorComponent(xn);
		JScrollPane xVectorScroller = new JScrollPane(resultVectorComponent);
		resultVectorJustDataComponent = new VectorJustDataComponent(xn);
		JScrollPane xVectorJDScroller = new JScrollPane(resultVectorJustDataComponent);
		xVectorArea.addTab("Az eredményvektor teljes ábrázolása", xVectorScroller);
		xVectorArea.addTab("Csak az eredményvektor nem 0 elemei", xVectorJDScroller);

		xVectorArea.setBounds(476, 64, 252, 224);
		panel.add(xVectorArea, "2, 2, fill, fill");

		JPanel panel_1 = new JPanel();
		panel.add(panel_1, "2, 4, fill, fill");

		JLabel lblHasznltLpsekSzma = new JLabel("Haszn\u00E1lt l\u00E9p\u00E9sek sz\u00E1ma: ");
		panel_1.add(lblHasznltLpsekSzma);

		int stNumb = Integer.parseInt(stepNumberField.getText()) + method.lastStepNumber;
		stepNumberField.setText(String.valueOf(stNumb));
		panel_1.add(stepNumberField);
		stepNumberField.setColumns(10);
		JButton exportXButton = new JButton("Az eredményvektor exportálása");
		exportXButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveXnVector();
			}
		});
		panel.add(exportXButton, "2, 6, center, center");
		JButton runMoreButton = new JButton("Iteráció folytatása");
		runMoreButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				runMore();
			}
		});
		runMoreButton.setToolTipText("Iteráció folytatása az eredményvektorral, mint kezdõvektor");
		panel.add(runMoreButton, "2, 8, center, center");
	}

	private JPanel createChart(final List<Double> doubles, final String title, final String categoryAxisLabel, final String valueAxisLabel, final int firstStep) {
		JPanel resultPanel = new JPanel();
		resultPanel.setLayout(new FormLayout(new ColumnSpec[] { FormFactory.LABEL_COMPONENT_GAP_COLSPEC, ColumnSpec.decode("300px:grow"), }, new RowSpec[] { FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("300px"), FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("30px:grow"), FormFactory.LINE_GAP_ROWSPEC, RowSpec.decode("30px"), }));

		final JFreeChart chart = ChartFactory.createBarChart(title, categoryAxisLabel, valueAxisLabel, getDataSet(doubles, firstStep));
		ChartPanel panel = new ChartPanel(chart);
		panel.setPreferredSize(new Dimension(300, 300));

		resultPanel.add(panel, "2, 2, fill, fill");

		JButton exportXButton = new JButton("Kép mentése");
		exportXButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				savePicture(chart);
			}
		});
		resultPanel.add(exportXButton, "2, 4, center, center");
		JButton runMoreButton = new JButton("Adatok mentése");
		runMoreButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				saveChartData(doubles, title, categoryAxisLabel, valueAxisLabel, firstStep);
			}
		});
		runMoreButton.setToolTipText("Iteráció folytatása az eredményvektorral, mint kezdõvektor");
		resultPanel.add(runMoreButton, "2, 6, center, center");

		return resultPanel;
	}

	private CategoryDataset getDataSet(List<Double> doubles, int firstStep) {
		DefaultCategoryDataset result = new DefaultCategoryDataset();
		for (int i = 0; i < doubles.size(); i++) {
			result.setValue(doubles.get(i), "Érték", String.valueOf(firstStep + i));
		}
		return result;
	}

	private String getMethodName() {
		String methodName = "";
		if (method instanceof JacobiMethod) {
			methodName = "Jacobi iterációval";
		} else if (method instanceof GaussSeidelMethod) {
			methodName = "Gauss-Seidel iterációval";
		} else if (method instanceof GradientMethod) {
			methodName = "Gradiens módszerrel";
		} else if (method instanceof ConjugateGradientMethod) {
			methodName = "Konjugált Gradiens módszerrel";
		}

		return methodName;
	}

	private void saveXnVector() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showSaveDialog(getParent());
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try (FileWriter fw = new FileWriter(chooser.getSelectedFile() + ".txt")) {
				fw.write(xn.toFileFormat());
				fw.close();
			} catch (IOException e) {
				Manager.getInstance().showMessage("Hiba a Fájl írása közben!");
				e.printStackTrace();
			}
		}
	}

	private void runMore() {
		removeAll();
		makePanel(xn);

		Manager.getInstance().getFrame().pack();
	}

	private void savePicture(JFreeChart chart) {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JPEG", "jpeg");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showSaveDialog(getParent());
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try {
				ChartUtilities.saveChartAsJPEG(chooser.getSelectedFile(), chart, 1200, 1200);
			} catch (IOException e) {
				Manager.getInstance().showMessage("Hiba a Fájl írása közben!");
				e.printStackTrace();
			}
		}
	}

	private void saveChartData(List<Double> doubles, String title, String categoryAxisLabel, String valueAxisLabel, int firstStep) {

		String dataToFile = new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "-n exportált " + getMethodName() + " számolt " + title + ": \n";

		for (int i = 0; i < doubles.size(); ++i) {
			dataToFile += categoryAxisLabel + ": " + String.valueOf(i + firstStep) + "; " + valueAxisLabel + ": " + doubles.get(i) + "\n";
		}
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT", "txt");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showSaveDialog(getParent());
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try (FileWriter fw = new FileWriter(chooser.getSelectedFile() + ".txt")) {
				fw.write(dataToFile);
				fw.close();
			} catch (IOException e) {
				Manager.getInstance().showMessage("Hiba a Fájl írása közben!");
				e.printStackTrace();
			}
		}
	}
}

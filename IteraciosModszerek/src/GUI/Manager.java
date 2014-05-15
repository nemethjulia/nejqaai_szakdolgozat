package gui;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

public class Manager {

	private static Manager instance;

	public static Manager getInstance() {
		if (instance == null) {
			instance = new Manager();
		}
		return instance;
	}

	private Manager() {
		restartProcess();
	}

	public void restartProcess() {
		matrix = new MySparseMatrix(0);
		xVectors = new ArrayList<MySparseVector>();
		bVector = new MySparseVector(0);
	}

	private MyFrame frame;

	private MySparseMatrix matrix;
	private List<MySparseVector> xVectors;
	private MySparseVector bVector;

	public MySparseMatrix getMatrix() {
		return matrix;
	}

	public void setMatrix(MySparseMatrix matrix) {
		this.matrix = matrix;
	}

	public List<MySparseVector> getxVectors() {
		return xVectors;
	}

	public String[] getxVectorsString() {
		String[] vectors = new String[xVectors.size()];
		for (int i = 0; i < xVectors.size(); ++i) {
			vectors[i] = xVectors.get(i).toString();
		}
		return vectors;
	}

	public void addXVector(MySparseVector xVector) {
		this.xVectors.add(xVector);
	}

	public void removeAllXVector() {
		this.xVectors = new ArrayList<MySparseVector>();
	}

	public MySparseVector getBVector() {
		return bVector;
	}

	public void setBVector(MySparseVector bVector) {
		this.bVector = bVector;
	}

	public void generateTestData() {
		try {
			matrix = MySparseMatrix.readFromFile(new File("src/test/01/01.matrix.txt"));
			bVector = MySparseVector.readFromFile(new File("src/test/01/01bvector.txt"));
			xVectors.add(MySparseVector.readFromFile(new File("src/test/01/01x01vector.txt")));
			xVectors.add(MySparseVector.readFromFile(new File("src/test/01/01x02vector.txt")));
		} catch (NumberFormatException | IOException e) {
			JOptionPane.showMessageDialog(frame, "Hiba a F�jlok beolvas�s�ban!");
		}
	}

	public MyFrame getFrame() {
		return frame;
	}

	public void setFrame(MyFrame frame) {
		this.frame = frame;
	}

}

package GUI;

import java.util.ArrayList;
import java.util.List;

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

		matrix = new MySparseMatrix(0);
		xVectors = new ArrayList<MySparseVector>();
		bVector = new MySparseVector(0);
	}

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

}

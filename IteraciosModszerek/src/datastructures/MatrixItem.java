/**
 * 
 */

package datastructures;

/**
 * @author julcsi
 * 
 */
public class MatrixItem {

	private int row;
	private int col;
	private double value;

	public int getRow() {
		return row;
	}

	public void setRow(int i) {
		this.row = i;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int j) {
		this.col = j;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public MatrixItem(int i, int j, double value) {
		this.row = i;
		this.col = j;

		this.value = value;
	}

}

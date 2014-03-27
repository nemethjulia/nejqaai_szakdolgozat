/**
 * 
 */

package datastructures;

/**
 * @author julcsi
 * 
 */
public class MatrixItem {

	private int i;
	private int j;
	private double value;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public MatrixItem(int i, int j, double value) {
		this.i = i;
		this.j = j;

		this.value = value;
	}

}

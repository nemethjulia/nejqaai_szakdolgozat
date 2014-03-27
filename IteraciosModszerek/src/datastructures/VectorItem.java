/**
 * 
 */

package datastructures;

/**
 * @author julcsi
 * 
 */
public class VectorItem {

	private int index;
	private double value;

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public VectorItem(int index, double value) {
		this.index = index;
		this.value = value;
	}

}

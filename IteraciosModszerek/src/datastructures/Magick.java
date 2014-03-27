/**
 * 
 */

package datastructures;

/**
 * @author julcsi
 * 
 */
public class Magick {

	private int row;
	private int index;

	public Magick(int row, int index) {
		this.row = row;
		this.index = index;
	}

	public void increaseIndex() {
		++index;
	}

	public int getRow() {
		return row;
	}

	public int getIndex() {
		return index;
	}

}

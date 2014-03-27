/**
 * 
 */

package datastructures;

import java.util.ArrayList;
import java.util.List;

/**
 * @author julcsi
 * 
 */
public class MySparseVector {

	private final List<VectorItem> data;
	private final int size;

	public int getSize() {
		return size;
	}

	public MySparseVector(int size) {
		data = new ArrayList<VectorItem>();
		this.size = size;
	}

	public double getValue(int index) {
		checkIndex(index);
		for (int i = 0; i < data.size(); ++i) {
			VectorItem item = data.get(i);
			if (item.getIndex() == index)
				return item.getValue();
			else if (item.getIndex() > index)
				return 0;
		}
		return 0;
	}

	public List<VectorItem> getData() {
		List<VectorItem> x = new ArrayList<VectorItem>();
		for (VectorItem i : data) {
			x.add(new VectorItem(i.getIndex(), i.getValue()));
		}
		return x;
	}

	public void setValue(int index, double value) {
		checkIndex(index);
		for (int i = 0; i < data.size(); ++i) {
			VectorItem item = data.get(i);
			if (item.getIndex() == index) {
				item.setValue(value);
				return;
			} else if (item.getIndex() > index) {
				data.add(i, new VectorItem(index, value));
				return;
			}
		}
		data.add(new VectorItem(index, value));
	}

	@Override
	public String toString() // lehetne getValue()-val, de igy gyorsabb
	{
		String vector = "[ ";
		int j = 0;
		for (int i = 0; i < size; ++i) {
			if (j < data.size()) {
				VectorItem v = data.get(j);
				if (v.getIndex() == i) {
					vector += v.getValue() + " ";
					++j;
				} else
					vector += "0 ";
			} else
				vector += "0 ";
		}

		return vector + "]T";
	}

	@Override
	public MySparseVector clone() {
		MySparseVector x = new MySparseVector(size);
		for (VectorItem i : data) {
			x.data.add(new VectorItem(i.getIndex(), i.getValue()));
		}
		return x;
	}

	private final void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
	}

}

/**
 * 
 */

package datastructures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import exceptions.NotSameSize;

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

	public static MySparseVector readFromFile(String fileName) {
		try {
			return readFromFile(new BufferedReader(new FileReader(fileName)));
		} catch (IOException e) {
			return null;
		}
	}

	public static MySparseVector readFromFile(BufferedReader reader) {
		MySparseVector vector = null;

		try {
			String line = reader.readLine();
			if (line != null) {
				vector = new MySparseVector(Integer.parseInt(line));
				line = reader.readLine();
				while (line != null) {
					String[] arr = line.split(",");
					if (arr.length == 2) {
						vector.setValue(Integer.parseInt(arr[0]), Double.parseDouble(arr[1]));
					} else {
						return vector;
					}
					line = reader.readLine();
				}
			}
		} catch (NumberFormatException e) {
			return null;
		} catch (IOException e) {
			// do nothing
		}
		return vector;
	}

	public MySparseVector add(MySparseVector otherVector) throws NotSameSize {
		if (size != otherVector.getSize()) {
			throw new NotSameSize("Nem ugyanakkora a két vektor!");
		}
		MySparseVector newVector = new MySparseVector(size);

		List<VectorItem> otherData = otherVector.getData();

		int thisI = 0;
		int otherI = 0;
		while (thisI < data.size() || otherI < otherData.size()) {
			VectorItem thisItem = data.get(thisI);
			VectorItem otherItem = otherData.get(otherI);

			if (thisItem.getIndex() == otherItem.getIndex()) {
				newVector.setValue(thisItem.getIndex(), thisItem.getValue() + otherItem.getValue());
				++thisI;
				++otherI;
			} else if (thisItem.getIndex() > otherItem.getIndex()) {
				newVector.setValue(otherItem.getIndex(), otherItem.getValue());
				++otherI;
			} else if (thisItem.getIndex() < otherItem.getIndex()) {
				newVector.setValue(thisItem.getIndex(), thisItem.getValue());
				++thisI;
			}

			if (thisI == data.size() && otherI != otherData.size()) {
				for (int i = otherI; i < otherData.size(); i++) {
					otherItem = otherData.get(i);
					newVector.setValue(otherItem.getIndex(), otherItem.getValue());
				}
			} else if (thisI != data.size() && otherI == otherData.size()) {
				for (int i = thisI; i < data.size(); i++) {
					thisItem = data.get(i);
					newVector.setValue(thisItem.getIndex(), thisItem.getValue());
				}
			}
		}

		return newVector;
	}

	public MySparseVector substract(MySparseVector otherVector) throws NotSameSize {
		if (size != otherVector.getSize()) {
			throw new NotSameSize("Nem ugyanakkora a két vektor!");
		}
		MySparseVector newVector = new MySparseVector(size);

		List<VectorItem> otherData = otherVector.getData();

		int thisI = 0;
		int otherI = 0;
		while (thisI < data.size() || otherI < otherData.size()) {
			VectorItem thisItem = data.get(thisI);
			VectorItem otherItem = otherData.get(otherI);

			if (thisItem.getIndex() == otherItem.getIndex()) {
				newVector.setValue(thisItem.getIndex(), thisItem.getValue() - otherItem.getValue());
				++thisI;
				++otherI;
			} else if (thisItem.getIndex() > otherItem.getIndex()) {
				newVector.setValue(otherItem.getIndex(), 0 - otherItem.getValue());
				++otherI;
			} else if (thisItem.getIndex() < otherItem.getIndex()) {
				newVector.setValue(thisItem.getIndex(), thisItem.getValue());
				++thisI;
			}

			if (thisI == data.size() && otherI != otherData.size()) {
				for (int i = otherI; i < otherData.size(); i++) {
					otherItem = otherData.get(i);
					newVector.setValue(otherItem.getIndex(), 0 - otherItem.getValue());
				}
			} else if (thisI != data.size() && otherI == otherData.size()) {
				for (int i = thisI; i < data.size(); i++) {
					thisItem = data.get(i);
					newVector.setValue(thisItem.getIndex(), thisItem.getValue());
				}
			}
		}

		return newVector;
	}

	public double multiple(MySparseVector otherVector) throws NotSameSize {
		if (size != otherVector.getSize()) {
			throw new NotSameSize("Nem ugyanakkora a két vektor!");
		}
		double sum = 0;

		List<VectorItem> otherData = otherVector.getData();

		int thisI = 0;
		int otherI = 0;
		while (thisI < data.size() || otherI < otherData.size()) {
			VectorItem thisItem = data.get(thisI);
			VectorItem otherItem = otherData.get(otherI);

			if (thisItem.getIndex() == otherItem.getIndex()) {
				sum += thisItem.getValue() * otherItem.getValue();
				++thisI;
				++otherI;
			} else if (thisItem.getIndex() > otherItem.getIndex()) {
				++otherI;
			} else if (thisItem.getIndex() < otherItem.getIndex()) {
				++thisI;
			}
		}

		return sum;
	}

	public MySparseVector multiple(double b) {

		MySparseVector result = new MySparseVector(size);

		for (int i = 0; i < data.size(); ++i) {
			VectorItem thisItem = data.get(i);
			result.setValue(thisItem.getIndex(), b * thisItem.getValue());
		}

		return result;
	}

	public double norm() {
		double sum = 0;

		for (VectorItem item : data) {
			sum += item.getValue() * item.getValue();
		}

		return Math.sqrt(sum);
	}
}

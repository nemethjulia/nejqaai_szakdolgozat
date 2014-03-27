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
public class MySparseMatrix {

	private final List<MatrixItem> data;
	private final List<Magick> rowindex;
	private int size;

	public MySparseMatrix(int size) {
		data = new ArrayList<MatrixItem>();
		rowindex = new ArrayList<Magick>();
		this.size = size;
	}

	public List<MatrixItem> getData() {
		List<MatrixItem> x = new ArrayList<MatrixItem>();
		for (MatrixItem i : data) {
			x.add(new MatrixItem(i.getI(), i.getJ(), i.getValue()));
		}
		return x;
	}

	public int getSize() {
		return size;
	}

	public double getValue(int row, int col) {
		checkIndex(row);
		checkIndex(col);
		for (int i = 0; i < rowindex.size(); ++i) {
			Magick m = rowindex.get(i);
			if (m.getRow() == row) {
				for (int j = m.getIndex(); j < data.size(); ++j) {
					MatrixItem b = data.get(j);
					if (b.getJ() == col)
						return b.getValue();
					else if (b.getJ() > col || b.getI() > row)
						return 0;
				}
			} else if (m.getRow() > row)
				return 0;
		}
		return 0;
	}

	public void setValue(int row, int col, double value) {
		checkIndex(row);
		checkIndex(col);
		// szimmetrikus matrixhoz a row-t meg a colt kell felcserelni, ha a
		// col>row
		for (int i = 0; i < rowindex.size(); ++i) {
			Magick m = rowindex.get(i);
			if (m.getRow() == row) {
				for (int j = m.getIndex(); j < data.size(); ++j) {
					MatrixItem b = data.get(j);
					if (b.getJ() == col) {
						b.setValue(value);
						return;
					} else if (b.getJ() > col || b.getI() > row) {
						data.add(j, new MatrixItem(row, col, value));
						for (int k = i + 1; k < rowindex.size(); ++k)
							rowindex.get(k).increaseIndex();
						return;
					}
				}
				if (i < rowindex.size() - 1)
					data.add(rowindex.get(i + 1).getIndex(), new MatrixItem(row, col, value));
				else
					data.add(new MatrixItem(row, col, value));

				for (int k = i + 1; k < rowindex.size(); ++k)
					rowindex.get(k).increaseIndex();
				return;
			} else if (m.getRow() > row) {
				data.add(m.getIndex(), new MatrixItem(row, col, value));
				rowindex.add(i, new Magick(row, m.getIndex()));
				for (int k = i + 1; k < rowindex.size(); ++k)
					rowindex.get(k).increaseIndex();
				return;
			}
		}
		data.add(new MatrixItem(row, col, value));
		rowindex.add(new Magick(row, data.size() - 1));
	}

	@Override
	public String toString() // lehetne getValue()-val, de igy gyorsabb
	{
		String matrix = "";
		int k = 0;
		for (int i = 0; i < size; ++i) {
			if (k >= rowindex.size() || rowindex.get(k).getRow() > i) {
				for (int j = 0; j < size; ++j) {
					matrix += "0 ";
				}
			} else if (rowindex.get(k).getRow() == i) {
				int l = rowindex.get(k).getIndex();
				for (int j = 0; j < size; ++j) {
					if (l < data.size() && j == data.get(l).getJ()) {
						matrix += data.get(l).getValue() + " ";
						++l;
					} else
						matrix += "0 ";
				}
				++k;
			}
			matrix += "\n";
		}
		return matrix;
	}

	private final void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
	}

	public boolean IsDiagonalDominant() {
		boolean l = true;
		int row = 0;
		double rowsum = 0;
		double diag = 0;
		MatrixItem mi;

		for (int i = 0; i < data.size() && l; ++i) {
			mi = data.get(i);
			if (mi.getI() != row) {
				if (rowsum > diag) {
					l = false;
				}
				row = mi.getI();
				rowsum = 0;
				diag = 0;
			} else {
				if (mi.getJ() == row)
					diag = Math.abs(mi.getValue());
				else
					rowsum += Math.abs(mi.getValue());
			}
		}
		if (rowsum > diag) {
			l = false;
		}
		return l;
	}
}

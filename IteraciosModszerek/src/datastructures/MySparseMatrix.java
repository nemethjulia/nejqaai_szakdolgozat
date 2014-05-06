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
			x.add(new MatrixItem(i.getRow(), i.getCol(), i.getValue()));
		}
		return x;
	}

	public int getSize() {
		return size;
	}

	private Magick getRowObject(int row) {
		for (int i = 0; i < rowindex.size(); ++i) {
			Magick m = rowindex.get(i);
			if (m.getRow() == row) {
				return m;
			} else if (m.getRow() > row) {
				return null;
			}
		}
		return null;
	}

	private MatrixItem getItemInRow(int colIndex, Magick rowObject) {
		for (int i = rowObject.getIndex(); i < data.size(); ++i) {
			MatrixItem item = data.get(i);
			if (item.getCol() == colIndex) {
				return item;
			} else if (item.getCol() > colIndex) {
				return new MatrixItem(rowObject.getRow(), colIndex, 0);
			}
		}
		return new MatrixItem(rowObject.getRow(), colIndex, 0);
	}

	public double getValue(int row, int col) {
		checkIndex(row);
		checkIndex(col);

		Magick rowObject = getRowObject(row);
		if (rowObject != null) {
			for (int j = rowObject.getIndex(); j < data.size(); ++j) {
				MatrixItem b = data.get(j);
				if (b.getCol() == col)
					return b.getValue();
				else if (b.getCol() > col || b.getRow() > row)
					return 0;
			}
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
					if (b.getCol() == col) {
						b.setValue(value);
						return;
					} else if (b.getCol() > col || b.getRow() > row) {
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
					if (l < data.size() && j == data.get(l).getCol()) {
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

	public boolean isDiagonalDominant() {
		boolean diagonalDominant = true;
		int row = 0;
		double rowsum = 0;
		double diag = 0;
		MatrixItem mi;

		for (int i = 0; i < data.size() && diagonalDominant; ++i) {
			mi = data.get(i);
			if (mi.getRow() != row) {
				if (rowsum > diag) {
					diagonalDominant = false;
				}
				row = mi.getRow();
				rowsum = 0;
				diag = 0;
			} else {
				if (mi.getCol() == row) {
					diag = Math.abs(mi.getValue());
				} else {
					rowsum += Math.abs(mi.getValue());
				}
			}
		}
		if (rowsum > diag) {
			diagonalDominant = false;
		}
		return diagonalDominant;
	}

	public boolean isSymmetryc() {
		boolean symetric = true;
		for (int i = 0; i < data.size() && symetric; ++i) {
			MatrixItem item = data.get(i);
			if (item.getCol() > item.getRow() / 2) {
				Magick rowObject = getRowObject(item.getCol());
				if (rowObject != null) {
					MatrixItem compare = getItemInRow(item.getRow(), rowObject);
					if (compare.getValue() != item.getValue()) {
						symetric = false;
					}
				} else {
					symetric = false;
				}
			}
		}
		return symetric;
	}
}

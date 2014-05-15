/**
 * 
 */

package datastructures;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
		if (value != 0.0) {
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
					if (l < data.size()) {
						MatrixItem item = data.get(l);
						if (j == item.getCol() && i == item.getRow()) {
							matrix += item.getValue() + " ";
							++l;
						} else {
							matrix += "0 ";
						}

					} else {
						matrix += "0 ";
					}
				}
				++k;
			}
			matrix += "\n";
		}
		return matrix;
	}

	public String toFileFormat() {
		String matrix = "";

		matrix += size + "\n";
		for (MatrixItem item : data) {
			matrix += item.getRow() + "," + item.getCol() + "," + item.getValue() + "\n";
		}

		return matrix;
	}

	private final void checkIndex(int index) {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException();
	}

	@Override
	public MySparseMatrix clone() {
		MySparseMatrix x = new MySparseMatrix(size);
		for (MatrixItem i : data) {
			x.data.add(new MatrixItem(i.getRow(), i.getCol(), i.getValue()));
		}
		for (Magick i : rowindex) {
			x.rowindex.add(new Magick(i.getRow(), i.getIndex()));
		}
		return x;
	}

	/*
	 * public MySparseMatrix add(MySparseMatrix otherMatrix) throws NotSameSize { MySparseMatrix result = this.clone();
	 * 
	 * if (size != otherMatrix.getSize()) { throw new NotSameSize("Nem ugyanakkora a két vektor!"); }
	 * 
	 * List<MatrixItem> otherData = otherMatrix.getData();
	 * 
	 * int thisI = 0; int otherI = 0; while (thisI < data.size() || otherI < otherData.size()) { MatrixItem thisItem = data.get(thisI); MatrixItem otherItem = otherData.get(otherI);
	 * 
	 * if (thisItem.getRow() == otherItem.getRow()) { if(thisItem) result.setValue(thisItem.getRow(), thisItem.getCol(), thisItem.getValue() + otherItem.getValue()); ++thisI; ++otherI; } else if (thisItem.getRow() > otherItem.getRow()) { result.setValue(otherItem.getRow(), otherItem.getCol(), otherItem.getValue()); ++otherI; } else if (thisItem.getRow() < otherItem.getRow()) {
	 * result.setValue(thisItem.getRow(), thisItem.getCol(), thisItem.getValue()); ++thisI; }
	 * 
	 * if (thisI == data.size() && otherI != otherData.size()) { for (int i = otherI; i < otherData.size(); i++) { otherItem = otherData.get(i); result.setValue(otherItem.getRow(), otherItem.getCol(), otherItem.getValue()); } } else if (thisI != data.size() && otherI == otherData.size()) { for (int i = thisI; i < data.size(); i++) { thisItem = data.get(i); result.setValue(thisItem.getRow(),
	 * thisItem.getCol(), thisItem.getValue()); } } }
	 * 
	 * return result; }
	 */

	public MySparseVector multiple(MySparseVector v) {
		MySparseVector result = new MySparseVector(v.getSize());

		int row = 0;
		double rowsum = 0;
		for (MatrixItem i : data) {
			if (i.getRow() != row) {
				result.setValue(row, rowsum);
				row = i.getRow();
				rowsum = 0;
			}

			rowsum += i.getValue() * v.getValue(i.getCol());
		}
		result.setValue(row, rowsum);

		return result;
	}

	public static MySparseMatrix readFromFile(File file) throws NumberFormatException, IOException {
		return readFromFile(new BufferedReader(new FileReader(file)));
	}

	public static MySparseMatrix readFromFile(BufferedReader reader) throws NumberFormatException, IOException {
		MySparseMatrix matrix = null;

		String line = reader.readLine();
		if (line != null) {
			matrix = new MySparseMatrix(Integer.parseInt(line));
			line = reader.readLine();
			while (line != null) {
				String[] arr = line.split(",");
				if (arr.length == 3) {
					matrix.setValue(Integer.parseInt(arr[0]) - 1, Integer.parseInt(arr[1]) - 1, Double.parseDouble(arr[2]));
				} else {
					return matrix;
				}
				line = reader.readLine();
			}
		}
		return matrix;
	}

	public boolean isDiagonalDominant() {
		boolean diagonalDominant = true;
		int row = 0;
		double rowsum = 0;
		double oldRowsum = 0;
		double diag = 0;
		double oldDiag = 1;
		MatrixItem mi;

		for (int i = 0; i < data.size() && diagonalDominant; ++i) {
			mi = data.get(i);
			if (mi.getRow() != row) {
				if (row + 1 != mi.getRow()) {
					diagonalDominant = false; // ha egy sorban nincs érték, akkor a diagonális 0, így nem > mint a többi
				} else {
					if (oldRowsum >= oldDiag) { // azért >= és nem >, hogy szigorú legyen
						diagonalDominant = false;
					} else {
						oldRowsum = rowsum;
						oldDiag = diag;
						row = mi.getRow();
						rowsum = 0;
						diag = 0;

						if (mi.getCol() == row) {
							diag = Math.abs(mi.getValue());
						} else {
							rowsum += Math.abs(mi.getValue());
						}

					}
				}
			} else {
				if (mi.getCol() == row) {
					diag = Math.abs(mi.getValue());
				} else {
					rowsum += Math.abs(mi.getValue());
				}
			}
		}
		if (oldRowsum >= oldDiag) {
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

	public boolean isPositiveDefinite() {
		return true;
	}
}

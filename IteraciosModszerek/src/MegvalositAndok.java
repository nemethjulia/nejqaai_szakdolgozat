import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import datastructures.MatrixItem;
import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

public class MegvalositAndok {

	public static MySparseVector residumVector(MySparseMatrix A, MySparseVector x, MySparseVector b) {
		int n = x.getSize();
		MySparseVector r = new MySparseVector(n);
		List<MatrixItem> m = A.getData();
		int row = m.get(0).getRow();
		double rowsum = 0;
		double value = 0;
		for (MatrixItem i : m) {
			if (i.getRow() != row) {
				value = b.getValue(row) - rowsum;
				r.setValue(row, value);
				row = i.getRow();
				rowsum = 0;
			}

			rowsum += i.getValue() * x.getValue(i.getCol());
		}
		value = b.getValue(row) - rowsum;
		r.setValue(row, value);

		return r;
	}

	public static MySparseVector olvassVectort(String fileName) {
		try {
			return olvassVectort(new BufferedReader(new FileReader(fileName)));
		} catch (IOException e) {
			return null;
		}
	}

	public static MySparseVector olvassVectort(BufferedReader reader) {
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
				}
			}
		} catch (NumberFormatException e) {
			return null;
		} catch (IOException e) {
			// do nothing
		}
		return vector;
	}

	public static MySparseMatrix olvassMatrixot(String fileName) {
		try {
			return olvassMatrixot(new BufferedReader(new FileReader(fileName)));
		} catch (IOException e) {
			return null;
		}
	}

	public static MySparseMatrix olvassMatrixot(BufferedReader reader) {
		MySparseMatrix matrix = null;

		try {
			String line = reader.readLine();
			if (line != null) {
				matrix = new MySparseMatrix(Integer.parseInt(line));
				line = reader.readLine();
				while (line != null) {
					String[] arr = line.split(",");
					if (arr.length == 3) {
						matrix.setValue(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]), Double.parseDouble(arr[2]));
					} else {
						return matrix;
					}
				}
			}
		} catch (NumberFormatException e) {
			return null;
		} catch (IOException e) {
			// do nothing
		}
		return matrix;
	}
}

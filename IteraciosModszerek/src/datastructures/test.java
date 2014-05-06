/**
 * 
 */

package datastructures;

/**
 * @author julcsi
 * 
 */
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MySparseMatrix m = new MySparseMatrix(10);
		m.setValue(5, 5, 1);
		System.out.println(m);
		System.err.println(m.isSymmetryc());

		m.setValue(1, 5, 4);
		m.setValue(5, 1, 4);
		System.out.println(m);
		System.err.println(m.isSymmetryc());

		m.setValue(4, 5, 10);
		m.setValue(5, 4, 2);
		System.out.println(m);
		System.err.println(m.isSymmetryc());

		MySparseVector v = new MySparseVector(10);
		v.setValue(5, 1);
		System.out.println(v);

	}

}

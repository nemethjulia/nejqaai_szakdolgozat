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
		m.setValue(5, 4, 1);
		System.out.println(m);
		MySparseVector v = new MySparseVector(10);
		v.setValue(5, 1);
		System.out.println(v);

	}

}

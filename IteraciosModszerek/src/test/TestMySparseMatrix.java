/**
 * 
 */
package test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.MySparseMatrix;

/**
 * @author seya
 * 
 */
public class TestMySparseMatrix {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testToString() {
		MySparseMatrix m = new MySparseMatrix(10);
		m.setValue(5, 5, 1);

		String expected = "0 0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 1.0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 0 \n0 0 0 0 0 0 0 0 0 0 \n";

		Assert.assertEquals(expected, m.toString());
	}

	@Test
	public void testIsSymmmetric() {
		MySparseMatrix m = new MySparseMatrix(10);
		m.setValue(5, 5, 1);
		Assert.assertTrue(m.isSymmetryc());

		m.setValue(1, 5, 4);
		m.setValue(5, 1, 4);
		Assert.assertTrue(m.isSymmetryc());

		m.setValue(4, 5, 10);
		m.setValue(5, 4, 2);
		Assert.assertFalse(m.isSymmetryc());
	}

	@Test
	public void testIsDiagonalDominant() {
		MySparseMatrix m = new MySparseMatrix(10);
		for (int i = 0; i < m.getSize(); ++i) {
			m.setValue(i, i, 1);
		}
		Assert.assertTrue(m.isDiagonalDominant());

		m.setValue(1, 5, 2);
		m.setValue(5, 1, 2);
		Assert.assertFalse(m.isDiagonalDominant());

		m.setValue(1, 1, 3);
		m.setValue(5, 5, 3);
		Assert.assertTrue(m.isDiagonalDominant());
	}

}

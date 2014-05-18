package test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import algorithms.ConjugateGradientMethod;
import algorithms.GaussSeidelMethod;
import algorithms.GradientMethod;
import algorithms.JacobiMethod;
import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

public class TestMethods {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	private MySparseMatrix getMatrix() {
		MySparseMatrix a = new MySparseMatrix(3);
		a.setValue(0, 0, 4);
		a.setValue(0, 1, 2);
		a.setValue(0, 2, 1);
		a.setValue(1, 0, 2);
		a.setValue(1, 1, 4);
		a.setValue(1, 2, 1);
		a.setValue(2, 0, 1);
		a.setValue(2, 1, 1);
		a.setValue(2, 2, 4);
		return a;
	}

	private MySparseVector getX0() {
		MySparseVector x = new MySparseVector(3);
		x.setValue(0, 1);
		x.setValue(1, 1);
		x.setValue(2, 1);
		return x;
	}

	private MySparseVector getB() {
		MySparseVector b = new MySparseVector(3);
		b.setValue(0, 3);
		b.setValue(1, -1);
		b.setValue(2, 4);
		return b;
	}

	private MySparseVector getSolution() {
		MySparseVector b = new MySparseVector(3);
		b.setValue(0, 1);
		b.setValue(1, -1);
		b.setValue(2, 1);
		return b;
	}

	@Test
	public void testJacobi() {
		JacobiMethod j = new JacobiMethod(20);

		try {
			MySparseVector xnew = j.solve(getMatrix(), getB(), getX0());

			Assert.assertTrue(xnew.substract(getSolution()).norm() < 1);

		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testGS() {
		GaussSeidelMethod gs = new GaussSeidelMethod(20);

		try {
			MySparseVector xnew = gs.solve(getMatrix(), getB(), getX0());

			Assert.assertTrue(xnew.substract(getSolution()).norm() < 1);

		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testGradient() {
		GradientMethod g = new GradientMethod(20);

		try {
			MySparseVector xnew = g.solve(getMatrix(), getB(), getX0());

			Assert.assertTrue(xnew.substract(getSolution()).norm() < 1);

		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.assertFalse(true);
		}
	}

	@Test
	public void testCGradient() {
		ConjugateGradientMethod cg = new ConjugateGradientMethod(20);

		try {
			MySparseVector xnew = cg.solve(getMatrix(), getB(), getX0());

			Assert.assertTrue(xnew.substract(getSolution()).norm() < 2);

		} catch (Exception e) {
			System.err.println(e.getMessage());
			Assert.assertFalse(true);
		}
	}
}

package test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import datastructures.MegvalositAndok;
import datastructures.MySparseMatrix;
import datastructures.MySparseVector;

public class TestRead {

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

	@Test
	public void testReadVector() {
		MySparseVector vector = MegvalositAndok.olvassVectort("vector.txt");
		System.out.println(vector);
		Assert.assertNotNull(vector);
	}

	@Test
	public void testReadMatrix() {
		MySparseMatrix matrix = MegvalositAndok.olvassMatrixot("matrix.txt");
		System.out.println(matrix);
		Assert.assertNotNull(matrix);
	}

}

package test;

import junit.framework.Assert;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
		MySparseVector vector = MySparseVector.readFromFile("src/test/vector.txt");
		Assert.assertNotNull(vector);
		Assert.assertEquals("[ 1.0 2.0 3.0 4.0 ]T", vector.toString());
	}

	@Test
	public void testReadMatrix() {
		MySparseMatrix matrix = MySparseMatrix.readFromFile("src/test/matrix.txt");
		Assert.assertNotNull(matrix);
		Assert.assertEquals("4.0 0 0 0 \n0 4.0 0 0 \n0 0 4.0 3.0 \n0 0 3.0 4.0 \n", matrix.toString());
	}

}

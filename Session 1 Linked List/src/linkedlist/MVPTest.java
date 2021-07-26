package linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MVPTest {
	MultiVariatePolynomial mvp ;
	
	/**
	 * Test Degree of polynomial
	 */
	@Test
	public void testMaxDegree() {
		mvp = new MultiVariatePolynomial();
		mvp.addMVP(new String[]{"3","0","x","y"});
		mvp.addMVP(new String[]{"1","x","0","y"});
		mvp.addMVP(new String[]{"-5","0","z"});
		mvp.addMVP(new String[]{"1","x"});
		mvp.addMVP(new String[]{"-1","y"});
		mvp.addMVP(new String[]{"20"});
		assertEquals(5, mvp.calculateMaxDegree());
	}
	
	/**
	 * Test Zero Degree
	 */
	@Test
	public void testZeroDegree() {
		mvp = new MultiVariatePolynomial();
		mvp.addMVP(new String[]{"0","y"});
		mvp.addMVP(new String[]{"20"});
		assertEquals(0, mvp.calculateMaxDegree());
	}
	
	/**
	 * Test fail input on empty array
	 */
	@Test
	public void testFailInputTerm() {
		mvp = new MultiVariatePolynomial();
		mvp.addMVP(new String[]{"0","y"});
		assertThrows(AssertionError.class,() ->{mvp.addMVP(new String[]{});});
	}
	
	/**
	 * Test head is null
	 */
	@Test
	public void testHeadNull() {
		mvp = new MultiVariatePolynomial();
		assertThrows(AssertionError.class,() ->{mvp.calculateMaxDegree();});
	}
	
}

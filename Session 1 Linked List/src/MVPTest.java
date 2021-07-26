
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import linkedlist.MultiVariatePolynomial;

public class MVPTest {
	MultiVariatePolynomial mvp ;
	
	@Test
	public void TestMaxDegree() {
		mvp = new MultiVariatePolynomial();
		mvp.addMVP(new String[]{"3","0","x","y"});
		mvp.addMVP(new String[]{"1","x","0","y"});
		mvp.addMVP(new String[]{"-5","0","z"});
		mvp.addMVP(new String[]{"1","x"});
		mvp.addMVP(new String[]{"-1","y"});
		mvp.addMVP(new String[]{"20"});
		assertEquals(5, mvp.calculateMaxDegree());
	}
	
	@Test
	public void TestZeroDegree() {
		mvp = new MultiVariatePolynomial();
		mvp.addMVP(new String[]{"0","y"});
		mvp.addMVP(new String[]{"20"});
		assertEquals(0, mvp.calculateMaxDegree());
	}
	
	@Test
	public void TestFailInputTerm() {
		mvp = new MultiVariatePolynomial();
		mvp.addMVP(new String[]{"0","y"});
		assertThrows(AssertionError.class,() ->{mvp.addMVP(new String[]{});});
	}
	
	@Test
	public void TestHeadNull() {
		mvp = new MultiVariatePolynomial();
		assertThrows(AssertionError.class,() ->{mvp.calculateMaxDegree();});
	}
	
}

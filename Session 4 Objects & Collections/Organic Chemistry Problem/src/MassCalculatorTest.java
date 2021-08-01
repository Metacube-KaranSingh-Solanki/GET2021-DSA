import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MassCalculatorTest {
	
	public static MassCalculator massCalculator;
	
	@BeforeEach
	public void init() {
		 massCalculator = new MassCalculator();
	}
	
	@Test
	public void TestFormulaIsNull() {
		assertThrows(AssertionError.class, () -> {massCalculator.calculateMass(null);});
	}
	
	@Test
	public void TestSimpleFormula() {
		assertEquals(29, massCalculator.calculateMass("CHO"));
		assertEquals(17, massCalculator.calculateMass("oh"));
	}
	
	@Test
	public void TestSimpleFormulaWithNumbers() {
		assertEquals(15, massCalculator.calculateMass("CH3"));
		assertEquals(18, massCalculator.calculateMass("h2o"));
	}
	
	@Test
	public void TestComplexFormula() {
		assertEquals(49, massCalculator.calculateMass("CH3(OH)2"));
		assertEquals(108, massCalculator.calculateMass("C4H6(H2O)3"));
	}
}

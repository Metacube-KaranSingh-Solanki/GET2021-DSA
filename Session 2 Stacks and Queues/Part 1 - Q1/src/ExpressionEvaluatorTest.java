import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ExpressionEvaluatorTest {

	public ExpressionEvaluator expEvaluator;

	@Test
	public void TestSimpleArithmetic() {
		expEvaluator = new ExpressionEvaluator("1 + 2 * 4");
		assertTrue("9.0".equals(expEvaluator.evaluate()));
	}

	@Test
	public void TestComplexArithmetic() {
		expEvaluator = new ExpressionEvaluator("10 + 8 * 3 / 12 - 8");
		assertTrue("4.0".equals(expEvaluator.evaluate()));
	}

	@Test
	public void TestDivideByZero() {
		expEvaluator = new ExpressionEvaluator("12 + 3 / 0");
		assertThrows(ArithmeticException.class, () -> {
			expEvaluator.evaluate();
		});
	}

	@Test
	public void TestRelational_Equals() {
		expEvaluator = new ExpressionEvaluator("10 + 8 == 9 + 9");
		assertTrue("true".equals(expEvaluator.evaluate()));
	}

	@Test
	public void TestRelational_NotEquals() {
		expEvaluator = new ExpressionEvaluator("10 + 8 != 9 + 9");
		assertTrue("false".equals(expEvaluator.evaluate()));
	}

	@Test
	public void TestRelational_GreaterThan() {
		expEvaluator = new ExpressionEvaluator("10 + 8 > 9 + 12");
		assertTrue("false".equals(expEvaluator.evaluate()));
	}

	@Test
	public void TestRelational_LessThan() {
		expEvaluator = new ExpressionEvaluator("10 + 8 < 9 + 12");
		assertTrue("true".equals(expEvaluator.evaluate()));
	}

	@Test
	public void TestRelational_LessThanEquals() {
		expEvaluator = new ExpressionEvaluator("10 + 8 <= 9 + 12");
		assertTrue("true".equals(expEvaluator.evaluate()));
	}

	@Test
	public void TestRelational_GreaterThanEquals() {
		expEvaluator = new ExpressionEvaluator("10 + 10 >= 3 * 2");
		assertTrue("true".equals(expEvaluator.evaluate()));
	}

	@Test
	public void TestBoolean_And() {
		expEvaluator = new ExpressionEvaluator("1 + 2 && 9 - 9");
		assertTrue("false".equals(expEvaluator.evaluate()));
	}

	@Test
	public void TestBoolean_Or() {
		expEvaluator = new ExpressionEvaluator("( 2 > 3 ) || ( 9 - 9 > 4 - 6 )");
		assertTrue("true".equals(expEvaluator.evaluate()));
	}

	@Test
	public void TestBoolean_Not() {
		expEvaluator = new ExpressionEvaluator("! 9 > 9");
		assertTrue("true".equals(expEvaluator.evaluate()));
	}

	@Test
	public void testArithmeticAndBooleanComplex() {
		expEvaluator = new ExpressionEvaluator("1 + 32 / 8 > 12 && 1 + 2 != 3 * 4");
		assertTrue("false".equals(expEvaluator.evaluate()));
	}

}

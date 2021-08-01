
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MassCalculator {
	
	private Map<Character, Integer> molecularMassOfAtoms;
	private final static int BRACKET_CODE = -1;
	
	/**
	 * Constructor to initialize the molecular mass map
	 */
	public MassCalculator() {
		molecularMassOfAtoms = new HashMap<>();
		molecularMassOfAtoms.put('O', 16);
		molecularMassOfAtoms.put('C', 12);
		molecularMassOfAtoms.put('H', 1);
	}
	
	/**
	 * Calculates the molecular mass of the given formula
	 * @param formula
	 * @return molecular mass
	 */
	public int calculateMass(String formula) {
		if (formula == null)
			throw new AssertionError("Formula can't be null.");
		
		Stack<Integer> stack = new Stack<>();
		int mass=0, sum=0;
		
		for (Character ch: formula.toUpperCase().toCharArray()) {
			if (ch == ')') {
				sum = 0;
				while (stack.peek() != BRACKET_CODE) {
					sum += stack.pop();
				}
				stack.pop();
				stack.push(sum);
			} else if (isNumber(ch)) {
				sum = stack.pop() * Integer.parseInt(ch.toString());
				stack.push(sum);
			} else if (ch == '(')
				stack.push(BRACKET_CODE);
			else
				stack.push(molecularMassOfAtoms.get(ch));
		}
		
		while (!stack.isEmpty())
			mass += stack.pop();
		
		return mass;
	}
	
	/**
	 * Checks if a character is number of not
	 * @param ch character to check
	 * @return true if it is number false if it is not
	 */
	private boolean isNumber(char ch) {
		return ch >='0' && ch <='9';
	}
}

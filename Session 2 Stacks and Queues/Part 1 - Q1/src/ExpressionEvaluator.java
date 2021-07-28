
/**
 * Expression Evaluator class works on arithmetic operators (+, -, *, /),
 * relational operators (==, !=, <, >, <=, >=),
 * and boolean operators (&&, ||, !), and parentheses.
 * assumes the expression has only integer constants, and the tokens are separated using spaces
 */
public class ExpressionEvaluator {
	private String infixExpression;
    private Stack<String> operatorStack;

    public ExpressionEvaluator(String infixExpression) {
        this.infixExpression = infixExpression;
    }

    /**
     * Method to evaluate expression
     * @return return the evaluated expression
     */
    public String evaluate() {
        String postfixExpression = infixToPostfix();
        Stack<String> stack = new Stack<>(postfixExpression.length()/2+1);
        
        for (String s: postfixExpression.split(" ")) {
            if ("!".equals(s)){
            	String operand1 = stack.pop();
                stack.push(execute(operand1, null, s));                
            }else if (isValidOperator(s)) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                stack.push(execute(operand2,operand1, s));
            }else {
                stack.push(s);
            }
        }
        return String.valueOf(stack.pop());
    }

    /**
     * Method to evaluate the sub expression
     * @param operand1 operand
     * @param operand2 operand
     * @param operator operator to perform operation 
     * @return expression evaluation output
     */
    private String execute(String operand1, String operand2, String operator) {
        String result=null;
		switch (operator) {
		case "+":
			result = String.valueOf(Double.parseDouble(operand1) + Double.parseDouble(operand2));
			break;
		case "-":
			result = String.valueOf(Double.parseDouble(operand1) - Double.parseDouble(operand2));
			break;
		case "*":
			result = String.valueOf(Double.parseDouble(operand1) * Double.parseDouble(operand2));
			break;
		case "/":
			if("0".equals(operand2))
				throw new ArithmeticException("Divide by Zero");
			result = String.valueOf(Double.parseDouble(operand1) / Double.parseDouble(operand2));
			break;
		case ">":
			result = String.valueOf(Double.parseDouble(operand1) > Double.parseDouble(operand2));
			break;
		case "<":
			result = String.valueOf(Double.parseDouble(operand1) < Double.parseDouble(operand2));
			break;
		case ">=":
			result = String.valueOf(Double.parseDouble(operand1) >= Double.parseDouble(operand2));
			break;
		case "<=":
			result = String.valueOf(Double.parseDouble(operand1) <= Double.parseDouble(operand2));
			break;
		case "==":
			result = String.valueOf(Double.parseDouble(operand1) == Double.parseDouble(operand2));
            break;
		case "!=":
			result = String.valueOf(Double.parseDouble(operand1) != Double.parseDouble(operand2));
            break;
		case "&&":
			result = String.valueOf(Boolean.parseBoolean(operand1) && Boolean.parseBoolean(operand2));
            break;
        case "!":	
        	result = String.valueOf(!Boolean.parseBoolean(operand1));
            break;
        case "||":
        	result = String.valueOf(Boolean.parseBoolean(operand1) || Boolean.parseBoolean(operand2));
            break;
		}
        return result;
    }

    /**
     * convert infix to postfix expression
     * @return expression in postfix form
     */
     private String infixToPostfix() {
        StringBuilder postfixExpression = new StringBuilder();
        operatorStack = new Stack<>(infixExpression.length());
        
		for (String ch : infixExpression.split(" ")) {
			// An operand is scanned, push it
			if (!isValidOperator(ch)) {
				
				postfixExpression.append(ch + " ");
				
			} else if ("(".equals(ch)) {
				
				operatorStack.push(ch);
				
			} else if (")".equals(ch)) {
				
				while (!operatorStack.isEmpty() && !"(".equals(operatorStack.peek())) {
					postfixExpression.append(operatorStack.pop() + " ");
				}
				operatorStack.pop();

			} else {
				
				while (!operatorStack.isEmpty() && getPrecedence(ch) <= getPrecedence(operatorStack.peek())) {
					postfixExpression.append(operatorStack.pop() + " ");
				}
				operatorStack.push(ch);
			}
		}
		while (!operatorStack.isEmpty())
			postfixExpression.append(operatorStack.pop() + " ");

		return postfixExpression.toString().trim();
    }

    /**
     * Check given operator lies in the given list 
     * @param op to be compared
     * @return true, if exists
     */
    private boolean isValidOperator(String op) {
        String operators = "+-*/)(";
        return operators.contains(op) || isRelationalOperator(op) || isBooleanOperator(op);
    }

    /** Helper method to check the precedence of the operators, high integer value means high precedence
     * @param op input operator in string
     * @return weight of the precedence
     */
    private int getPrecedence(String op) {
        int result = -1;
 
        switch (op) {
            case "/":
            case "*":
                result = 5;
                break;
            case "+":
            case "-": 
                result = 4;
                break; 
            case ">":
            case "<":
            case ">=":
            case "<=":
            case "!=":
            	 result = 3;
                 break;
            case "==":	
            case "&&":
            case "||":
            	 result = 2;
                 break;
            case "!":	
            	result = 1;
                break;
        }
        return result;
    }
    
    /**
     * Helper method to check is Operator is relational Operator or not
     * @param op input to check
     * @return if match return true
     */
    private boolean isRelationalOperator(String op) {
        switch(op) {
            case ">":
            case "<":
            case ">=":
            case "<=":
            case "==":
            case "!=":
                return true;
        }
        return false;
    }
    
    /**
     * Helper method to check is Operator is boolean operator or not
     * @param op input to check
     * @return if match return true
     */
    private boolean isBooleanOperator(String op) {
        switch(op) {
            case "&&":
            case "!":
            case "||":
                return true;
        }
        return false;
    }
}

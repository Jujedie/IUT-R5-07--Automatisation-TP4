public class Calculette {
	public static int polonaiseInverse(String expression) {
		String[] tokens = expression.split(" ");
		java.util.Stack<Integer> stack = new java.util.Stack<>();

		for (String token : tokens) {
			if (isOperator(token)) {
				int b = stack.pop();
				int a = stack.pop();
				int result = applyOperator(a, b, token);
				stack.push(result);
			} else {
				stack.push(Integer.parseInt(token));
			}
		}

		return stack.pop();
	}

	private static boolean isOperator(String token) {
		return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
	}

	private static int applyOperator(int a, int b, String operator) {
		switch (operator) {
			case "+":
				return a + b;
			case "-":
				return a - b;
			case "*":
				return a * b;
			case "/":
				if (b == 0) {
					throw new ArithmeticException("Division by zero");
				}
				return a / b;
			default:
				throw new IllegalArgumentException("Invalid operator: " + operator);
		}
	}

	public static void main(String[] args) {
		String expression = "3 4 + 2 * 7 /"; // Example expression in Reverse Polish Notation
		int result = polonaiseInverse(expression);
		System.out.println("Result: " + result); // Output the result
	}
}

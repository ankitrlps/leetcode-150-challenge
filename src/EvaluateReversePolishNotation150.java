import java.util.Stack;

public class EvaluateReversePolishNotation150 {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int i1 = stack.pop();
                int i2 = stack.pop();

                stack.push(operate(i1, i2, token));
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    private int operate(int i1, int i2, String operator) {
        switch (operator) {
            case "+" -> {
                return i1 + i2;
            }
            case "-" -> {
                return i2 - i1;
            }
            case "*" -> {
                return i1 * i2;
            }
            case "/" -> {
                return i2 / i1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        
    }
}
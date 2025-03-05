import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class GenerateParentheses22 {

    // ===== Using stacks
    public List<String> generateParenthesis1(int n) {
        List<String> valid = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        backtrack(0, 0, valid, stack, n);
        return valid;
    }

    void backtrack(int openCount, int closeCount, List<String> list, Stack<String> stack, int n) {
        if (openCount == closeCount && closeCount == n) {
            list.add(stack.stream().collect(Collectors.joining("")));
            return;
        }

        if (openCount < n) {
            stack.push("(");
            backtrack(openCount + 1, closeCount, list, stack, n);
            stack.pop();
        }

        if (openCount > closeCount) {
            stack.push(")");
            backtrack(openCount, closeCount+1, list, stack, n);
            stack.pop();
        }
    }
    // ===== ending stacks

    // ===== Using string
    public List<String> generateParenthesis(int n) {
        List<String> valid = new ArrayList<>();
        backtrack(0, 0, valid, "", n);
        return valid;
    }

    void backtrack(int openCount, int closeCount, List<String> list, String s, int n) {
        if (s.length() == n*2) {
            list.add(s);
            return;
        }

        if (openCount < n) {
            backtrack(openCount + 1, closeCount, list, s + "(", n);
        }

        if (openCount > closeCount) {
            backtrack(openCount, closeCount+1, list, s + ")", n);
        }
    }
    // ===== ending string

    public static void main(String[] args) {
        
    }
}

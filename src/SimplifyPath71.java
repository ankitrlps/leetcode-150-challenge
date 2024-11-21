import java.util.Stack;

public class SimplifyPath71 {

    public String simplifyPath(String path) {
        String[] ss = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (int i = 1; i < ss.length; i++) {
            if (ss[i].equals("") || ss[i].equals(".")) {
                continue;
            } else if (ss[i].equals("..")) {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else {
                stack.push(ss[i]);
            }
        }

        if (stack.isEmpty()) return "/";

        StringBuilder sb = new StringBuilder();
        for (String s : stack) {
            sb.append("/").append(s);
        }

        return sb.toString();
    }
    
    public static void main(String[] args) {
        
    }

}

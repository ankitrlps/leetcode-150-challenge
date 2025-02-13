import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextRightPointersEachNodeII117 {

    public Node connect(Node root) {
        if (root == null) return null;
        Queue<Node> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int i = que.size();

            while (i > 0) {
                Node curr = que.poll();
                if (i > 1) curr.next = que.peek();

                if (curr.left != null) {
                    que.add(curr.left);
                }
                if (curr.right != null) {
                    que.add(curr.right);
                }
                i--;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
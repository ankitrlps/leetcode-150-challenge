import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView199 {

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        
        while (!que.isEmpty()) {
            int size = que.size();
            list.add(que.peek().val);
            while (size > 0) {
                TreeNode node = que.poll();

                if (node.right != null) 
                    que.add(node.right);
                if (node.left != null)
                    que.add(node.left);
                size--; 
            }
        }
        return list;
    }

    public static void main(String[] args) {
        
    }    
}

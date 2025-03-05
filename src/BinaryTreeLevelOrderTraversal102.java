import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal102 {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int size = que.size();
            List<Integer> currLevel = new ArrayList<>();
            while (size > 0) {
                TreeNode curr = que.poll();
                currLevel.add(curr.val);

                if (curr.left != null) {
                    que.add(curr.left);
                }
                if (curr.right != null) {
                    que.add(curr.right);
                }
                size--;
            }
            list.add(currLevel);
        }

        return list;
    }

    public static void main(String[] args) {
        
    }
}

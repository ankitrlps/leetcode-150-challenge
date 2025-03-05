import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int oddEven = 0;

        while (!que.isEmpty()) {
            int size = que.size();
            oddEven++;
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
            // reverse the list if its even level
            if (oddEven % 2 == 0) {
                int i = 0;
                int j = currLevel.size()-1;
                while (i < j) {
                    int temp = currLevel.get(i);
                    currLevel.set(i, currLevel.get(j));
                    currLevel.set(j, temp);
                    i++;
                    j--;
                }
            }
            res.add(currLevel);
        }

        return res;
    }

    public static void main(String[] args) {
        
    }
}

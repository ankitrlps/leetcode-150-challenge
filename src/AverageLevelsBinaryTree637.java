import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageLevelsBinaryTree637 {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while (!que.isEmpty()) {
            int i = que.size();
            int nodes = i;
            double nodeVals = 0.0;
            while (i > 0) {
                TreeNode node = que.poll();
                if (node.left != null) que.add(node.left);
                if (node.right != null) que.add(node.right);
                nodeVals += node.val;
                i--;
            }
            list.add((double) nodeVals/nodes);
        }
        return list;
    }

    public static void main(String[] args) {
        
    }
}

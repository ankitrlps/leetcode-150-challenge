public class PathSum112 {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        int j = dfs(root, targetSum, 0);
        System.out.println(j);
        return targetSum == j;
    }

    private int dfs(TreeNode root, int targetSum, int sum) {
        if (sum + root.val > targetSum) return 0;
        
        sum += root.val;
        
        if (root.left == null && root.right == null && targetSum == sum) return sum;
        
        if (root.left != null) {
            return dfs(root.left, targetSum, sum);
        }
        if (root.right != null) {
            return dfs(root.right, targetSum, sum);
        }
        return sum;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);
        node.left.left = new TreeNode(11);
        node.left.left.left = new TreeNode(7);
        node.left.left.right = new TreeNode(2);

        PathSum112 path = new PathSum112();
        System.out.println(path.hasPathSum(node, 22));
    }
}

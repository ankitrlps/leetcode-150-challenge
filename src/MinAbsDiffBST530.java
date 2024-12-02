public class MinAbsDiffBST530 {

    int minDiff = Integer.MAX_VALUE;
    TreeNode prev = null;
    
    public int getMinimumDifference(TreeNode root) {
        dfs(root);
        return minDiff;
    }

    void dfs(TreeNode root) {
        if (root == null) return;

        dfs(root.left);

        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(root.val - prev.val));
        }

        prev = root;

        dfs(root.right);
    }
    
    public static void main(String[] args) {
        
    }
}

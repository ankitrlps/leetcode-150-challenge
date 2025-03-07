public class CountCompleteTreeNodes222 {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return dfs(root);
    }

    int dfs(TreeNode root) {
        if (root == null) return 0;

        return 1 + dfs(root.left) + dfs(root.right);
    }
    
    public static void main(String[] args) {
        
    }
}

public class ValidateBinarySearchTree98 {

    public boolean isValidBST(TreeNode root) {
        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    boolean dfs(TreeNode root, long lowBound, long highBound) {
        if (root == null) return true;

        if (!(lowBound < root.val && root.val < highBound)) return false;

        return dfs(root.left, lowBound, root.val) && dfs(root.right, root.val, highBound);
    }

    public static void main(String[] args) {
        System.out.println(((0-1) + 4) % 4);
    }
}

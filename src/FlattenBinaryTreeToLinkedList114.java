public class FlattenBinaryTreeToLinkedList114 {


    public void flatten(TreeNode root) {
        //if (root == null) return;
        dfs(root);
    }

    TreeNode dfs(TreeNode root) {
        if (root == null) return null;

        var leftTail = dfs(root.left);
        var rightTail = dfs(root.right);

        if (root.left != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        TreeNode last;
        if (rightTail != null) {
            last = rightTail;
        } else if (leftTail != null) {
            last = leftTail;
        } else {
            last = root;
        }
        return last;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        FlattenBinaryTreeToLinkedList114 flatten = new FlattenBinaryTreeToLinkedList114();
        flatten.flatten(root);
    }
}

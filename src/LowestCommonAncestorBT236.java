public class LowestCommonAncestorBT236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        // if we find a root that equals p or q then return from there and find on the other side        
        if (root == p || root == q) return root;
        
        var left = lowestCommonAncestor(root.left, p, q);
        var right = lowestCommonAncestor(root.right, p, q);

        if (left == null) return right;
        if (right == null) return left;

        return root; // when left is non null and right is non null
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        LowestCommonAncestorBT236 ancestorBT236 = new LowestCommonAncestorBT236();
        //ancestorBT236.lowestCommonAncestor(root, root.left, root.left.right.right);
        ancestorBT236.lowestCommonAncestor(root, root.left.right, root.left.right.left);
    }

}

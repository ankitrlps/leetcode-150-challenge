import java.util.HashMap;
import java.util.Map;

public class ConstructBTPostorderAndInorderTraversal106 {


    Map<Integer, Integer> inOrderMap = new HashMap<>();
    int postOrderIndex = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrderIndex = postorder.length-1;
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return traverse(postorder, 0, postOrderIndex);
    }

    private TreeNode traverse(int[] postorder, int left, int right) {
        if (left > right) return null;

        int rootVal = postorder[postOrderIndex--];
        TreeNode root = new TreeNode(rootVal);
        int inorderIndex = inOrderMap.get(rootVal);

        root.right = traverse(postorder, inorderIndex + 1, right);
        root.left = traverse(postorder, left, inorderIndex - 1);
        
        return root;
    }

    public static void main(String[] args) {
        
    }
}

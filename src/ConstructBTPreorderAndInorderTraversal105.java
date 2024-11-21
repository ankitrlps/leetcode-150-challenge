import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBTPreorderAndInorderTraversal105 {

    Map<Integer, Integer> inorder_map = new HashMap<>();
    private int preIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorder_map.put(inorder[i], i);
        }
        return construct(preorder, 0, preorder.length-1);
    }

    private TreeNode construct(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);
        int inRootIndex = inorder_map.get(rootVal);

        root.left = construct(preorder, left, inRootIndex-1);
        root.right = construct(preorder, inRootIndex+1, right);
        return root;
    }


    /**
     * Bad TC
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;

        TreeNode root = new TreeNode(preorder[0]);

        int mid = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                mid = i;
                break;
            }
        }
        int[] leftPreorder = Arrays.copyOfRange(preorder, 1, mid+1);
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, mid);
        root.left = buildTree1(leftPreorder, leftInorder);

        int[] rightPreorder = Arrays.copyOfRange(preorder, mid+1, preorder.length);
        int[] rightInorder = Arrays.copyOfRange(inorder, mid+1, inorder.length);
        root.right = buildTree1(rightPreorder, rightInorder);

        return root;
    }

    public static void main(String[] args) {
        ConstructBTPreorderAndInorderTraversal105 bTree = new ConstructBTPreorderAndInorderTraversal105();
        bTree.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }   
}

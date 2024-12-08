public class ConvertSortedArrayToBT108 {
    
    public TreeNode sortedArrayToBST(int[] nums) {
        return bst(nums, 0, nums.length - 1);
    }

    TreeNode bst(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = left + (right - left) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = bst(nums, left, mid - 1);
        root.right = bst(nums, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBT108 convert = new ConvertSortedArrayToBT108();
        convert.sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }
}

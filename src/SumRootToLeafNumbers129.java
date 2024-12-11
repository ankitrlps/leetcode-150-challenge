
public class SumRootToLeafNumbers129 {

    int total = 0;
    public int sumNumbers(TreeNode root) {
        dfs(root, 0);
        return total;
    }

    void dfs(TreeNode root, int sum) {
        if (root == null) return;
        sum = sum * 10 + root.val;
        
        if (root.left == null && root.right == null) {
            total += sum;
        }

        dfs(root.left, sum);
        dfs(root.right, sum);
    }

    // ===== start Using stringbuilder and array to save sum
    public int sumNumbers1(TreeNode root) {
        int[] sum = {0};
        dfs1(root, new StringBuilder(), sum);
        return sum[0];
    }

    void dfs1(TreeNode root, StringBuilder sb, int[] sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            sum[0] = sum[0] + Integer.parseInt(sb.toString());
            sb.setLength(sb.length() - 1);
            return;
        }
        sb.append(root.val);
        dfs1(root.left, sb, sum);
        dfs1(root.right, sb, sum);
        sb.setLength(sb.length() - 1);
    }
    // ===== end

    public static void main(String[] args) {

    }
}

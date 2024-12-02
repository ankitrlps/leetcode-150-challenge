import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KthSmallestElementBST230 {
    
    int count = 0;
    int value = -1;

    // In a BST, left most element will be the smallest element in whole tree
    // looping through the tree and reaching the left most element
    // from there, increment the count till it equals k
    // that means we found a smallest val, counted from bottom of tree
    public int kthSmallest(TreeNode root, int k) {
        dfs(root, k);
        return value;
    }

    void dfs(TreeNode root, int k) {
        if (root == null) return;
        
        dfs(root.left, k);

        count++;
        
        if (count == k) {
            value = root.val;
            return;
        }

        dfs(root.right, k);
    }
    
    // adding all elements in set
    // then creating a list out of it
    // then sorting the list
    // returning the k-1 index element
    public int kthSmallest1(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        dfs1(root, set);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        return list.get(k-1);
    }

    void dfs1(TreeNode root, Set<Integer> set) {
        if (root == null) return;
        set.add(root.val);
        if (root.left != null) dfs1(root.left, set);
        if (root.right != null) dfs1(root.right, set);
    }

    public static void main(String[] args) {
        
    }
}

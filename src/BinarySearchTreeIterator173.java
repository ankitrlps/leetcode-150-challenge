import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator173 {

    List<Integer> list = new ArrayList<>();
    int pointer = 0;

    public BinarySearchTreeIterator173(TreeNode root) {
        dfs(root);
    }
    
    public int next() {
        return list.get(pointer++);
    }
    
    public boolean hasNext() {
        if (pointer == list.size()) return false;
        return true;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    public static void main(String[] args) {
        
    }
}

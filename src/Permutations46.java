import java.util.ArrayList;
import java.util.List;

public class Permutations46 {

    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>(), new boolean[nums.length]);               
        return res;
    }

    void backtrack(int[] nums, List<Integer> perm, boolean[] visited) {
        if (perm.size() == nums.length) {
            res.add(new ArrayList<>(perm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                perm.add(nums[i]);
                backtrack(nums, perm, visited);
                perm.remove(perm.size()-1);
                visited[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        Permutations46 p = new Permutations46();
        System.out.println(p.permute(new int[]{1,2,3}));
    }
}

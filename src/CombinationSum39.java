import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(0, new ArrayList<>(), list, target, candidates);
        return list;
    }

    void dfs(int index, List<Integer> curr, List<List<Integer>> list, int target, int[] candidates) {
        if (target == 0) {
            list.add(new ArrayList<>(curr));
            return;
        }
        if (target < 0 || index >= candidates.length) {
            return;
        }
        
        curr.add(candidates[index]);
        dfs(index, curr, list, target-candidates[index], candidates);
        curr.remove(curr.size()-1);
        dfs(index+1, curr, list, target, candidates);
    }
    
    public static void main(String[] args) {
        
    }
}

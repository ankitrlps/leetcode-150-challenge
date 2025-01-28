import java.util.ArrayList;
import java.util.List;

public class Combinations77 {
    
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(1, n, k, list, new ArrayList<>());
        return list;
    }

    private void dfs(int ii, int n, int k, List<List<Integer>> list, List<Integer> ll) {
        if (ll.size() == k) {
            list.add(new ArrayList<>(ll));
            return;
        }

        for (int i = ii; i <= n; i++) {
            ll.add(i);
            dfs(i+1, n, k, list, ll);
            ll.remove(ll.size()-1);
        }
    }

    public static void main(String[] args) {
    }
}

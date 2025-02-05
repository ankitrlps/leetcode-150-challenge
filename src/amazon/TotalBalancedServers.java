package amazon;

import java.util.HashMap;
import java.util.Map;

public class TotalBalancedServers {

    static int getTotalBalanced(int[] capacity) {
        int balanced = 0;
        int sum = 0;
        int[] sums = new int[capacity.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < capacity.length; i++) {
            sum += capacity[i];
            sums[i] = sum - capacity[i];
            if (map.containsKey(capacity[i])) {
                int index = map.get(capacity[i]);
                if (i-index + 1 < 3) continue;

                int leftSum = sums[index];
                if (sums[i] - leftSum - capacity[i] == capacity[i]) balanced++;
            } else {
                map.put(capacity[i], i);
            }
        }
        
        return balanced;
    }

    public static void main(String[] args) {
        System.out.println(getTotalBalanced(new int[]{9,3,3,3,9}));
        System.out.println(getTotalBalanced(new int[]{9,3,1,2,3,9,10}));
        System.out.println(getTotalBalanced(new int[]{6,1,2,3,6}));
    }
}

package amazon;

import java.util.HashMap;
import java.util.Map;

public class OptimizePayload {


    public static int maxEvents(int[] payload) {
        int res = 0;

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int ele : payload) {
            map.put(ele, map.getOrDefault(ele, 0));
            minVal = Math.min(minVal, ele);
            maxVal = Math.max(minVal, ele);
        }

        res += Math.min(minVal, 2);
        res += Math.min(maxVal, 2);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getKey() != minVal && entry.getKey() != maxVal) {
                res += Math.min(entry.getValue(), 3);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        maxEvents(new int[]{1, 3, 5, 4, 2, 6, 8, 7, 9});
    }
}

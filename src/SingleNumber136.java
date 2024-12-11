
import java.util.HashMap;
import java.util.Map;

public class SingleNumber136 {

    public int singleNumber(int[] nums) {
        int single = 0;

        for (int i : nums) {
            single ^= i;
        }
        return single;
    }

    public int singleNumber1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.remove(i);
            } else {
                map.put(i, 1);
            }
        }

        for (var m : map.entrySet()) {
            return m.getKey();
        }
        return 0;
    }

    public static void main(String[] args) {
    }
}

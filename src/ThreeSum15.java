import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum15 {

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int temp = nums[i];
            int a = i+1;
            int b = nums.length-1;
            while (a < b) {
              int sum = temp + nums[a] + nums[b];
              if (sum < 0) {
                a++;
              } else if (sum > 0) {
                b--;
              } else {
                set.add(List.of(temp, nums[a], nums[b]));
                a++;
                b--;
              }
            }
        }
    
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        
    }
}

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence128 {

    public int longestConsecutive(int[] nums) {
        // for duplicate removal: put nums in a set
        // loop through set and check if each element is a start of sequence
        // for checking if start of a sequence, check -1 of curr element
        // if its a start then run a loop by increasing each element value and checking if it exists in set
        // and pick the max sequence found
        // if not then leave it

        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }

        for (int num : set) {
            if (!set.contains(num - 1)) { // checking if nums[i] is start of sequence
                int maxTemp = 1;
                while (set.contains(num + maxTemp)) {
                    maxTemp++;
                }
                max = Math.max(max, maxTemp);
            }
        }

        return max;
    }
    
    public static void main(String[] args) {
        
    }
}

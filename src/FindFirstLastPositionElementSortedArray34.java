import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindFirstLastPositionElementSortedArray34 {

    // using binary search
    public int[] searchRange(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        int[] res = {-1, -1};
        // initializing a list for grabbing all indexes of occurences
        List<Integer> list = new ArrayList<>();
        
        bs(0, nums.length-1, nums, target, list);
        
        if (list.isEmpty()) return res;
        // sort the list to grab the first and last element indexes
        Collections.sort(list);
        res[0] = list.get(0);
        res[1] = list.get(list.size()-1);
        
        return res;
    }

    void bs(int low, int high, int[] nums, int target, List<Integer> list) {
        if (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) { // found the occurence
                int i = mid; // starting from mid
                while (i >= 0 && nums[i] == target) { // loop on low/left side to find the left most index of that occurence
                    list.add(i--);
                }
                i = mid+1; // reusing the same int but starting from next index from mid this time
                while (i < nums.length && nums[i] == target) {// loop on high/right side to find the right most index of that occurence
                    list.add(i++);
                }
                return;
            }
            if (nums[mid] < target) { // traditional binary search check to search on second half of nums
                bs(mid + 1, high, nums, target, list);
            } else { // traditional bs check to search on first half of nums
                bs(low, mid-1, nums, target, list);
            }
        }
    }

    // using two pointers
    public int[] searchRange1(int[] nums, int target) {
        int i = 0;
        int j = nums.length-1;
        int[] res = {-1, -1};

        while (i <= j) {
            if (nums[i] == target) {
                res[0] = i;
            }

            if (nums[j] == target) {
                res[1] = j;
            }

            if (nums[i] == target && nums[j] == target) return res;
            if (res[0] == -1) i++;
            if (res[1] == -1) j--;
        }
        return res;
    }


    public static void main(String[] args) {
        
    }
}

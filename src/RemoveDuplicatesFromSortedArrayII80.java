/**
 * RemoveDuplicatesFromSortedArrayII80
 */
public class RemoveDuplicatesFromSortedArrayII80 {

    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) return nums.length;
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i];
            if (k > 1 && nums[k-2] == temp && nums[k-1] == temp) continue;
            nums[k] = nums[i];
            k++;
        }
        return k;
    }

    public static void main(String[] args) {
        
    }
}
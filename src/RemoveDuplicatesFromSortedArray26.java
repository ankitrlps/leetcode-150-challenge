public class RemoveDuplicatesFromSortedArray26 {
    
    public int removeDuplicates(int[] nums) {
        int j = 1;
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != prev) {
                nums[j] = nums[i];
                prev = nums[i];
                j++;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        
    }
}

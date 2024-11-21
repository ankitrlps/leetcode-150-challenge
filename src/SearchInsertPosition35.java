
public class SearchInsertPosition35 {

    public int searchInsert(int[] nums, int target) {
        return bs(0, nums.length-1, nums, target);
    }

    int bs(int left, int right, int[] nums, int target) {
        if (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target && mid+1 < nums.length && nums[mid+1] > target) {
                return mid+1;
            }
            if (mid == nums.length-1 && nums[mid] < target) return mid+1;
            
            if (nums[mid] < target) {
                return bs(mid+1, right, nums, target);
            } else {
                return bs(left, mid-1, nums, target);
            }
        }
        return 0;
    }
    
    public static void main(String[] args) {
        SearchInsertPosition35 search = new SearchInsertPosition35();
        search.searchInsert(new int[]{1,3,5,6}, 5);
        search.searchInsert(new int[]{1,3,5,6}, 2);
        search.searchInsert(new int[]{1,3,5,6}, 7);
    }
}

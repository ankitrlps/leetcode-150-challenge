public class FindPeakElement162 {

    // Using BS - From the mid, try to find which adjacent side has greater element, just start searching in that direction.
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length-1;

        while (left < right) {
            int mid = left + (right-left)/2;

            if (nums[mid] > nums[mid+1]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        
        return left;
    }

    // Two pointers
    public int findPeakElement1(int[] nums) {
        if (nums.length == 1) return 0;
        int len = nums.length-1;
        int i = 0, j = len;

        while (i <= j) {
            if (i == 0 && j == len && (i + 1 <= j || j - 1 >= i)) {
                if (nums[i] > nums[i+1]) return i;
                else if (nums[j] > nums[j-1]) return j;
            } else {
                if (nums[i-1] < nums[i] && nums[i] > nums[i+1]) return i;
                else if (nums[j-1] < nums[j] && nums[j] > nums[j+1]) return j;
            }
            i++;
            j--;
        }
        return -1;
    }

    public static void main(String[] args) {
        
    }
}

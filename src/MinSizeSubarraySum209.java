public class MinSizeSubarraySum209 {

    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;

        int sum = 0;
        int i = 0;
        int j = 0;
        int len = nums.length;
        while (i < len && j < len) { // sliding window starting and increment j till sum >= target
            sum += nums[j]; // add each element
            while (sum >= target) { // while sum is >= target
                minLen = Math.min(minLen, j - i + 1); // calc the len of i till j so far and store it only if its "<" already existing Len
                sum -= nums[i++]; // remove value at index i from sum and increment i. We're shorting the window 
                //to check if there's shorter window range which suffies sum >= target
            }
            j++;
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
    public static void main(String[] args) {
        MinSizeSubarraySum209 subarray = new MinSizeSubarraySum209();
        System.out.println(subarray.minSubArrayLen(6, new int[]{2,3,1,2,4,3}));
        System.out.println(subarray.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(subarray.minSubArrayLen(4, new int[]{1,4,4}));
        System.out.println(subarray.minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
    }
}

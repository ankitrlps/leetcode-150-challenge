public class MaxSubArraySum53 {

    public int maxSubArray(int[] nums) {
        int currSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currSum = Math.max(nums[i], currSum + nums[i]); // nums[i] is greater or adding previous sum with nums[i] is greater
            maxSum = Math.max(maxSum, currSum); // max sum got so far
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        
    }
}
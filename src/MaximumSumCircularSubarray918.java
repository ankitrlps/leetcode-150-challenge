public class MaximumSumCircularSubarray918 {

    public int maxSubarraySumCircular(int[] nums) {
        int currMax = 0;
        int globalMax = nums[0];

        int currMin = 0;
        int globalMin = nums[0];
        
        int total = 0;
        for (int num : nums) {
            total += num;
            currMax = Math.max(num, currMax + num);
            globalMax = Math.max(globalMax, currMax);

            currMin = Math.min(num, currMin + num);
            globalMin = Math.min(globalMin, currMin);
        }

        //when nums is all negatives
        if (globalMax < 0) return globalMax;

        return Math.max(total - globalMin, globalMax);
    }

    public static void main(String[] args) {
        
    }
}

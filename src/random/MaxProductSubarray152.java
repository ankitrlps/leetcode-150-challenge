package random;

public class MaxProductSubarray152 {
    
    public static int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            max = Math.max(max, n);
        }

        int currMax = 1, currMin = 1;

        for (int n : nums) {
            var tempMax = currMax * n;
            currMax = Math.max(Math.max(n * currMax, n * currMin), n);
            currMin = Math.min(Math.min(tempMax, n * currMin), n);
            max = Math.max(max, currMax);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{2,-2,4,5,-1}));
    }
}

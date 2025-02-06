package amazon;

import java.util.Arrays;

public class MakeArrayZeroSubtractingEqualAmounts {

    public static int minimumOperations(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        int count = 0;

        for (int n : nums) {
            if (n > sum) {
                sum = n;
                count++;
            }
        }
        return count;
    }

    public int minimumOperations1(int[] nums) {
        int small = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n == 0) continue;
            small = Math.min(small, n);
        }
        if (small == Integer.MAX_VALUE) return 0;

        int min = 0;
        while (true) {
            int currSmall = Integer.MAX_VALUE;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 0) continue;
                nums[i] -= small;
                if (nums[i] == 0) continue;
                
                currSmall = Math.min(nums[i], currSmall);
            }
            min++;
            if (currSmall == Integer.MAX_VALUE) break;
            small = currSmall;
        }

        return min;
    }

    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[]{1,5,0,3,5}));
    }
}

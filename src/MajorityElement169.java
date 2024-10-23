/**
 * MajorityElement169
 */
import java.util.Arrays;
public class MajorityElement169 {

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
        // int maxIndices = 0;
        // int j = 0;
        // int majority = nums[0];
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] != nums[i-1]) {
        //         if (maxIndices <= i-j) {
        //             maxIndices = i-j;
        //             majority = nums[i-1];
        //             j = i;
        //         }
        //         System.out.println(j + " " + maxIndices + " " + majority);
        //     }
        // }
        // if (nums.length - j > maxIndices) {
        //     majority = nums[j];
        // }
        // return majority;
    }

    public static void main(String[] args) {
        
    }
}
public class RotateArray189 {

    public void rotate(int[] nums, int k) {
        if (nums.length == 1) return;
        int i = 0, j = nums.length-1;
        k = k % nums.length;
        while (i < j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
        i = 0;
        j = k-1;
        while (i < j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
        i = k;
        j = nums.length-1;
        while (i < j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {

    }
}

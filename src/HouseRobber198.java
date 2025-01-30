public class HouseRobber198 {

    public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        for (int n : nums) {
            var temp = Math.max(rob1 + n, rob2);
            rob1 = rob2;
            rob2 = temp;
        }
        
        return rob2;
    }

    public static void main(String[] args) {
        
    }
}

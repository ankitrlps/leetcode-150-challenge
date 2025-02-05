public class ContainerWithMostWater11 {

    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length-1;
        while (i < j) {
            int x = j-i;
            int y = Math.min(height[i], height[j]);
            max = Math.max(max, x*y);
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }

        return max;
    }
    
    public static void main(String[] args) {
        
    }
}

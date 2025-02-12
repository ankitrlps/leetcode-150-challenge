import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberArrowsBurstBalloons452 {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();

        int prevStart = Integer.MIN_VALUE;
        int prevEnd = Integer.MIN_VALUE;
        for (int[] curr : points) {
            int newStart = 0;
            int newEnd = 0;

            if (curr[0] <= prevEnd) {
                newStart = Math.max(curr[0], prevStart);
                newEnd = Math.min(curr[1], prevEnd);
                if (!list.isEmpty()) {
                    list.set(list.size()-1, new int[]{newStart, newEnd});
                } else {
                    list.add(new int[]{newStart, newEnd});    
                }
            } else {
                newStart = curr[0];
                newEnd = curr[1];
                list.add(new int[]{newStart, newEnd});
            }
            prevStart = newStart;
            prevEnd = newEnd;
        }

        return list.size();
    }

    public static void main(String[] args) {
        
    }
}

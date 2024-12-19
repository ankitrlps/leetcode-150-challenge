import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals56 {
    
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0]-b[0]);
        
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int last = list.size()-1;
            if (i > 0 && intervals[i][0] <= list.get(last)[1]) {
                int[] temp = list.get(last);
                list.remove(last);
                list.add(new int[]{Math.min(temp[0], intervals[i][0]), Math.max(temp[1], intervals[i][1])});
            } else {
                list.add(new int[]{intervals[i][0], intervals[i][1]});
            }
        }

        int[][] res = new int[list.size()][2];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        
    }
}

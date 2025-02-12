import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval57 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Step 1: create a new List<int[]> and insert all intervals and newInterval
        List<int[]> allIntervals = new ArrayList<>();
        allIntervals.addAll(Arrays.asList(intervals));
        allIntervals.add(newInterval);

        // Step 2: Sort allIntervals list with start element in ascending order. 
        // This way it will be easy to perform merge intervals.
        allIntervals.sort((a,b) -> a[0] - b[0]);

        // Step 3: Create a new List<int[]> list that will merge the overlapping intervals
        List<int[]> processIntervals = new ArrayList<>();
        // Store prev interval in order to process the current interval if its needed to be merged 
        // or add as new interval
        int prevStart = 0;
        int prevEnd = 0;
        for (int i = 0; i < allIntervals.size(); i++) {
            int[] curr = allIntervals.get(i);
            // no need of processing/storing if the curr intervals completely overlaps previous interval
            if (prevStart < curr[0] && curr[1] < prevEnd) continue;
            int processStart = 0;
            int processEnd = 0;
            if (curr[0] <= prevEnd) {
                processStart = Math.min(prevStart, curr[0]);
                processEnd = Math.max(prevEnd, curr[1]);
                if (!processIntervals.isEmpty()) {
                    // Modify the prev interval entry with newely calculated min start element and max end element
                    processIntervals.set(processIntervals.size()-1, new int[]{processStart, processEnd});
                } else {
                    // Since processIntervals is empty, just add the newly processed interval
                    processIntervals.add(new int[]{processStart, processEnd});
                }                
            } else {
                // Since the curr interval doesn't overlap with prev interval, just add it to list
                processStart = curr[0];
                processEnd = curr[1];
                processIntervals.add(new int[]{processStart, processEnd});
            }
            prevStart = processStart;
            prevEnd = processEnd;
        }

        // Step 4: Create a new return type int[][] and dump the processIntervals list
        int[][] finalIntervals = new int[processIntervals.size()][];
        for (int i = 0; i < processIntervals.size(); i++) {
            finalIntervals[i] = processIntervals.get(i);
        }
        
        return finalIntervals;
    }
    
    public static void main(String[] args) {
        
    }
}

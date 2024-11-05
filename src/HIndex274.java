
import java.util.Arrays;

public class HIndex274 {

    public int hIndex(int[] citations) {
        int maxLen = citations.length;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= maxLen) {
                return maxLen;
            }
            maxLen--;
        }
        return 0;
    }

    public int hIndex1(int[] citations) {
        int[] paperCounts = new int[citations.length+1];
        for (int citation : citations) {
            if (citation > paperCounts.length-1) {
                paperCounts[paperCounts.length-1]++;
            } else {
                paperCounts[citation]++;
            }
        }
        int h = paperCounts.length-1;
        int papers = paperCounts[h];
        
        while (papers < h) {
            h--;
            papers += paperCounts[h];
        }

        return h;
    }
    
    public static void main(String[] args) {
        
    }
}

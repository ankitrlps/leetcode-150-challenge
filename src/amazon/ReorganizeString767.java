package amazon;

import java.util.PriorityQueue;

public class ReorganizeString767 {

    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            int index = ch - 'a';
            freq[index]++;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        for (int i = 0; i < freq.length; i++) {
            pq.offer(new int[]{freq[i], i});
        }

        StringBuilder sb = new StringBuilder();
        int[] prev = null;

        while (!pq.isEmpty() || prev != null) {
            if (prev != null && pq.isEmpty()) return "";

            int[] curr = pq.poll();
            if (curr[0] == 0) continue;
            sb.append((char) (curr[1] + 'a'));
            curr[0]--;

            if (prev != null) {
                pq.offer(prev);
                prev = null;
            }

            if (curr[0] > 0) {
                prev = curr;
            }
        }
        
        return sb.toString();
    }

    public static void main(String[] args) {
        
    }
}

import java.util.List;

public class WordBreak139 {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] cache = new boolean[s.length() + 1];
        cache[s.length()] = true;
        int len = s.length();
        
        for (int i = len-1; i >= 0; i--) {
            for (String word : wordDict) {
                if (i + word.length() <= len && word.equals(s.substring(i, i + word.length()))) {
                    cache[i] = cache[i + word.length()];
                }
                if (cache[i]) break;
            }

        }
        return cache[0];
    }

    public static void main(String[] args) {
        
    }
}

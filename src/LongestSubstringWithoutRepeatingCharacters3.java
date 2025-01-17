
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters3 {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int i = 0, j = 0;
        int len = s.length();
        Set<Character> set = new HashSet<>();

        while (j < len) {
            char ch = s.charAt(j);
            if (set.contains(ch)) {
                res = Math.max(res, j - i);
                while (set.contains(ch) && i <= j) {
                    set.remove(s.charAt(i));
                    i++;
                }
            }
            set.add(ch);
            j++;
        }
        res = Math.max(res, set.size());
        return res;
    }

    public static void main(String[] args) {

    }
}

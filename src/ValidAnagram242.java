import java.util.Arrays;

public class ValidAnagram242 {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] chars = new int[26];

        for (char c : s.toCharArray()) {
            chars[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            chars[c - 'a']--;
        }

        for (int i : chars) {
            if (i != 0) return false;
        }

        return true;
    }

    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        
        for (int i = 0; i < s.length(); i++) {
            if (s1[i] != t1[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        
    }
}

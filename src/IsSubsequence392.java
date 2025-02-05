public class IsSubsequence392 {

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        int slen = s.length();
        int j = 0;
        for (int i = 0; i < t.length(); i++) {
            if (j == slen) return true;
            if (t.charAt(i) == s.charAt(j)) {
                j++;
            }
        }
        return j == slen;
    }

    public static void main(String[] args) {
        
    }
}

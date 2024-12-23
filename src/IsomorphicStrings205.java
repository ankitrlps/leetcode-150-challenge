public class IsomorphicStrings205 {

    public boolean isIsomorphic(String s, String t) {
        int[] sch = new int[256];
        int[] tch = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (sch[c1] != 0 && sch[c1] != c2) return false;
            if (tch[c2] != 0 && tch[c2] != c1) return false;
            sch[c1] = c2;
            tch[c2] = c1;
        }
        return true;
    }

    public boolean isIsomorphic1(String s, String t) {

        char[] iso = new char[26];

        for (int i = 0; i < s.length(); i++) {
            if (iso[s.charAt(i)-'a'] == '\u0000' && iso[t.charAt(i)-'a'] == '\u0000') {
                iso[s.charAt(i)-'a'] = t.charAt(i);
                iso[t.charAt(i)-'a'] = s.charAt(i);
            } else {
                if (iso[s.charAt(i)-'a'] != t.charAt(i) || iso[t.charAt(i)-'a'] != s.charAt(i)) return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        IsomorphicStrings205 is = new IsomorphicStrings205();
        System.out.println(is.isIsomorphic("badc", "baba"));
    }
}

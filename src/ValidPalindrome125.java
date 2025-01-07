public class ValidPalindrome125 {

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            char a = s.charAt(i);
            char b = s.charAt(j);
            if (a >= 'A' && a <= 'Z') {
                a = (char) (a + 32);
            } 
            if (b >= 'A' && b <= 'Z') {
                b = (char) (b + 32);
            }
            if (!((a >= 'a' && a <= 'z') || (a >= '0' && a <= '9'))) {
                i++;
                continue;
            }
            if (!((b >= 'a' && b <= 'z') || (b >= '0' && b <= '9'))) {
                j--;
                continue;
            }
            if (a != b) return false;
            i++;
            j--;
        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        if (s.length() == 0) return true;
        int i = 0;
        int j = s.length()-1;
        char[] ch = s.toCharArray();
        while (i < j) {
            if (ch[i] != ch[j]) return false;
            i++;
            j--;
        }
        return true;
    }
    
    public static void main(String[] args) {
        
    }
}

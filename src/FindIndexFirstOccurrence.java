public class FindIndexFirstOccurrence {

    public int strStr(String haystack, String needle) {
        int len = needle.length();
        
        // check if the last char of needle is found in haystack and once found, search for substring equality (from i to backwards of len needle) 
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(len-1) && i-len+1 >= 0 && haystack.substring(i-len+1, i+1).equals(needle)) {
                return i-len+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        
    }
}

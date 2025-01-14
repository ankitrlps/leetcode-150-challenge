public class LongestCommonPrefix14 {

    public static String longestCommonPrefix(String[] strs) {
        String prefix = strs[0];

        // pick first string and check it with each of other strings that if it starts with same chars
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length()-1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(strs[0]);

        for (int i = 1; i < strs.length; i++) {
            String prev = sb.toString();
            String curr = strs[i];
            sb.setLength(0);
            int len = prev.length() < curr.length() ? prev.length() : curr.length();
            for (int j = 0; j < len; j++) {
                if (prev.charAt(j) != curr.charAt(j)) break;
                sb.append(curr.charAt(j));
            }
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println(LongestCommonPrefix14.longestCommonPrefix(new String[]{"er","flower","flight"}));
    }
}

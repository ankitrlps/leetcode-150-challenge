public class ReverseWordsString151 {

    public String reverseWords(String s) {
        String ss[] = s.trim().split(" +");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length-1; i > 0; i--) {
            sb.append(ss[i] + " ");
        }
        sb.append(ss[0]);
        return sb.toString();
    }

    public static void main(String[] args) {
        
    }
}

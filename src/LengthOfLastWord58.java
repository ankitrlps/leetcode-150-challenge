public class LengthOfLastWord58 {

    public int lengthOfLastWord(String s) {
        s = s.trim();
        String[] ss = s.split(" ");
        return ss[ss.length-1].length();
    }
    
    public static void main(String[] args) {
        
    }
}

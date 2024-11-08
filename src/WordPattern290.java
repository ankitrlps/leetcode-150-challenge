import java.util.HashMap;
import java.util.Map;

public class WordPattern290 {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();

        String[] ss = s.split(" ");
        if (ss.length != pattern.length()) return false;

        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!map.get(pattern.charAt(i)).equals(ss[i])) return false;
            } else {
                if (map.containsValue(ss[i])) return false; 
                map.put(pattern.charAt(i), ss[i]);
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        
    }
}

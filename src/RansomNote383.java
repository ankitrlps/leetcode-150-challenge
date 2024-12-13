import java.util.HashMap;
import java.util.Map;

public class RansomNote383 {

    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        int[] mag = new int[26];

        for (char ch : magazine.toCharArray()) {
            mag[ch-'a']++;
        }

        for (char ch : ransomNote.toCharArray()) {
            if (mag[ch-'a'] == 0) return false;

            mag[ch-'a']--;
        }

        return true;
    }

    public boolean canConstruct1(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (char ch : magazine.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char ch : ransomNote.toCharArray()) {
            if (!map.containsKey(ch) || map.get(ch) == 0) {
                return false;
            } else {
                map.put(ch, map.get(ch)-1);
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        
    }
}

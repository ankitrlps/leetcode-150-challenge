import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String ss = String.valueOf(ch);
            if (map.containsKey(ss)) {
                map.get(ss).add(s);
            } else {
                List<String> ll = new ArrayList<>();
                ll.add(s);
                map.put(ss, ll);
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        
    }
}

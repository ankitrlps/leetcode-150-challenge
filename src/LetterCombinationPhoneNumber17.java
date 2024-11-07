import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhoneNumber17 {

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return new ArrayList<>();
        List<String> list = new ArrayList<>();

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        dfs(0, new StringBuilder(), digits, list, map);
        return list;
    }

    void dfs(int index, StringBuilder sb, String digits, List<String> list, Map<Character, String> map) {

        if (index == digits.length()) {
            list.add(sb.toString());
            return;
        }

        char[] ch = map.get(digits.charAt(index)).toCharArray();
        for (int i = 0; i < ch.length; i++) {
            sb.append(ch[i]);
            dfs(index + 1, sb, digits, list, map);
            sb.setLength(sb.length()-1);
        }
    }
    
    public static void main(String[] args) {
        
    }
}

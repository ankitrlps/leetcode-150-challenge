
public class WordDictionary211 {

    private Trie root;

    public WordDictionary211() {
        root = new Trie();
    }

    public void addWord(String word) {
        Trie curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new Trie();
            }
            curr = curr.children[index];
        }
        curr.wordEnd = true;
    }

    public boolean search(String word) {
        Trie curr = root;
        return searchHelper(curr, word);
    }

    private boolean searchHelper(Trie tr, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '.') {
                for (Trie tr1 : tr.children) {
                    if (tr1 != null && searchHelper(tr1, word.substring(i + 1))) {
                        return true;
                    }
                }
                return false;
            }
            if (tr.children[ch - 'a'] == null) {
                return false;
            }
            tr = tr.children[ch - 'a'];
        }
        return tr != null && tr.wordEnd;
    }

    class Trie {

        Trie[] children;
        boolean wordEnd;

        public Trie() {
            this.children = new Trie[26];
            this.wordEnd = false;
        }
    }

    public static void main(String[] args) {

    }
}

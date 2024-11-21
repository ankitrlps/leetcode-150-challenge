public class ImplementTrie208 {

    TrieNode root;

    public ImplementTrie208() {
        root = new TrieNode();    
    }
    
    public void insert(String word) {
        TrieNode curr = root;        
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) {
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.wordEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return curr.wordEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (curr.children[index] == null) return false;
            curr = curr.children[index];
        }
        return true;
    }
}

class TrieNode {
    TrieNode[] children;
    boolean wordEnd;
    public TrieNode() {
        children = new TrieNode[26];
        wordEnd = false;
    }
}

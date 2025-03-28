class TrieNode {
    TrieNode[] charArray = new TrieNode[26];
    boolean isComplete;
    TrieNode() {}
}

class Trie {
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode current = root;
        for(int i = 0 ; i < word.length() ; i++) {
            char c = word.charAt(i);
            if(current.charArray[c-'a'] == null) {
                current.charArray[c-'a'] = new TrieNode();
            }
            current = current.charArray[c-'a'];
        }
        current.isComplete = true;
    }
    
    public boolean search(String word) {
        if(word == null) 
            return false;
        TrieNode current = root;
        for(int i = 0 ; i < word.length() ; i++) {
            char c = word.charAt(i);
            if(current.charArray[c-'a'] == null) 
                return false;
            current = current.charArray[c-'a'];
        }
        return current.isComplete;
    }
    
    public boolean startsWith(String prefix) {
        if(prefix == null)
            return false;
        TrieNode current = root;
        for(int i = 0 ; i < prefix.length() ; i++) {
            char c = prefix.charAt(i);
            if(current.charArray[c-'a'] == null) 
                return false;
            current = current.charArray[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
class TrieNode {
    TrieNode[] chars = new TrieNode[26];
    boolean isComplete;

    TrieNode() {
    }
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.chars[c - 'a'] == null) {
                current.chars[c - 'a'] = new TrieNode();
            }
            current = current.chars[c - 'a'];
        }
        current.isComplete = true;
    }

    public boolean search(String word) {
        return searchWord(root, word.toCharArray(), 0);
    }

    public boolean searchWord(TrieNode node, char[] charArray, int start) {
        for(int i = start ; i < charArray.length ; i++) {
            char ch = charArray[i];

            if(ch == '.') {
                for(var trie : node.chars) {
                    // recursive 
                    if(trie != null && searchWord(trie, charArray, i+1))
                        return true;
                }
                return false;
            } else {
                if(node.chars[ch-'a'] == null) 
                    return false;

                node = node.chars[ch-'a'];
            }
        }
        return node != null && node.isComplete;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
class Trie {
    boolean isWord;
    Map<Character, Trie> children;

    public Trie() {
        isWord = false;
        children = new HashMap<>();
    }
    
    public void insert(String word) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            if (!curr.children.containsKey(word.charAt(i))) {
                curr.children.put(word.charAt(i), new Trie());
            }
            curr = curr.children.get(word.charAt(i));
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, true);
    }
    
    public boolean startsWith(String prefix) {
        return searchHelper(prefix, false);
    }
    
    public boolean searchHelper(String word, boolean strict) {
        Trie curr = this;
        for (int i = 0; i < word.length(); i++) {
            if (!curr.children.containsKey(word.charAt(i))) return false;
            
            curr = curr.children.get(word.charAt(i));
        }

        return (!strict || curr.isWord);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
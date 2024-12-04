class TrieNode {
    int maxSuggestions;
    List<String> suggestions;
    Map<Character, TrieNode> children;

    TrieNode(int maxSuggestions) {
        this.maxSuggestions = maxSuggestions;
        this.suggestions = new ArrayList<>();
        this.children = new HashMap<>();
    }

    public void add(String word) {
        TrieNode curr = this;
        for (char c: word.toCharArray()) {
            if (!curr.children.containsKey(c)) curr.children.put(c, new TrieNode(this.maxSuggestions));
            curr = curr.children.get(c);

            curr.suggestions.add(word);
            Collections.sort(curr.suggestions);
            if (curr.suggestions.size() > this.maxSuggestions) {
                curr.suggestions.removeLast();
            }
        }
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        TrieNode root = new TrieNode(3);
        for (String word : products) root.add(word);

        List<List<String>> result = new ArrayList<>();
        TrieNode curr = root;
        for (char c : searchWord.toCharArray()) {
            if (curr.children.containsKey(c)) {
                curr = curr.children.get(c);
                result.add(curr.suggestions);
            } else {
                result.add(new ArrayList<>());
            }
        }
        return result;
    }
}
class Trie {
    boolean isEnd;
    Map<Character, Trie> child;

    Trie() {
        isEnd = false;
        child = new HashMap<>();
    }

    public void insert(String word) {
        Trie curr = this;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.child.containsKey(c)) {
                curr.child.put(c, new Trie());
            }
            curr = curr.child.get(c);
        }

        curr.isEnd = true;
    }

    public Trie getChild(char c) {
        return child.getOrDefault(c, null);
    }

    public boolean isWord() {
        return isEnd;
    }
}

class Solution {
    int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String word : words) {
            root.insert(word);
        }

        Set<String> visited = new HashSet<>();
        Set<String> matchingWords = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                search(board, root, visited, matchingWords, new StringBuilder(), i, j);
            }
        }

        return new ArrayList<>(matchingWords);
    }

    public void search(char[][] board, Trie root, Set<String> visited, Set<String> matchingWords, StringBuilder currWord, int x, int y) {
        if (visited.contains(node(x, y))) return;

        Trie curr = root.getChild(board[x][y]);
        if (curr == null) return;

        visited.add(node(x, y));
        currWord.append(board[x][y]);
        if (curr.isWord()) {
            matchingWords.add(currWord.toString());
        }
        
        for (int[] direction : directions) {
            int i = x + direction[0];
            int j = y + direction[1];
            if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited.contains(node(i, j))) {
                continue;
            }

            search(board, curr, visited, matchingWords, currWord, i, j);
        }

        currWord.deleteCharAt(currWord.length()-1);
        visited.remove(node(x, y));
    }

    public String node(int x, int y) {
        return x + ", " + y;
    }
}

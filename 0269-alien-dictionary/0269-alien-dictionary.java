class Solution {
    public String alienOrder(String[] words) {
        Set<Character> uniqueChars = new HashSet<>();
        for (String word: words) {
            for (int i = 0; i < word.length(); i++) {
                uniqueChars.add(word.charAt(i));
            }
        }

        Map<Character, Set<Character>> graph = new HashMap<>();
        int[] indegrees = new int[26];
        for (int i = 0; i < words.length-1; i++) {
            String word1 = words[i], word2 = words[i+1];
            for (int j = 0; j < word1.length(); j++) {
                if (j >= word2.length()) return "";

                if (word1.charAt(j) != word2.charAt(j)) {
                    graph.computeIfAbsent(word1.charAt(j), _ -> new HashSet<>()).add(word2.charAt(j));
                    indegrees[word2.charAt(j)-'a']++;
                    break;
                }
            }
        }
        

        Queue<Character> bfs = new LinkedList<>();
        for (char c : uniqueChars) {
            if (indegrees[c - 'a'] == 0) {
                bfs.add(c);
            }
        }

        StringBuilder order = new StringBuilder();
        while (!bfs.isEmpty()) {
            char parent = bfs.poll();
            order.append(parent);

            for (char child : graph.getOrDefault(parent, new HashSet<>())) {
                indegrees[child - 'a']--;
                if (indegrees[child - 'a'] == 0) {
                    bfs.add(child);
                }
            }
        }

        if (order.length() != uniqueChars.size()) return "";
        return order.toString();
    }
}
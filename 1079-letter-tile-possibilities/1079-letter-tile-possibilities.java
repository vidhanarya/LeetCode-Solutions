class Solution {
    Set<String> uniqueSequence;
    boolean[] used;

    public int numTilePossibilities(String tiles) {
        uniqueSequence = new HashSet<>();
        used = new boolean[tiles.length()];

        backtrack(tiles, new StringBuilder());
        return uniqueSequence.size() - 1;
    }

    public void backtrack(String tiles, StringBuilder curr) {
        uniqueSequence.add(curr.toString());

        for (int i = 0; i < tiles.length(); i++) {
            if (used[i]) continue;

            used[i] = true;
            curr.append(tiles.charAt(i));
            backtrack(tiles, curr);
            curr.deleteCharAt(curr.length() - 1);
            used[i] = false;
        }
    }
}
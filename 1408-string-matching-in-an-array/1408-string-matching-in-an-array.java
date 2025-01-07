class Solution {
    public List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String s = words[i];
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;

                String p = words[j];
                if (p.indexOf(s) != -1) {
                    result.add(s);
                    break;
                }
            }
        }

        return result;
    }
}
class Solution {
    char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefix = new int[words.length+1];

        for (int i = 1; i <= words.length; i++) {
            System.out.println(words[i-1] + ", " + (i-1));
            String word = words[i-1];

            prefix[i] = prefix[i-1];
            prefix[i] += (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length()-1))) ? 1 : 0;
        }

        System.out.println(Arrays.toString(prefix));
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            System.out.println(prefix[queries[i][1]+1] + ", " + prefix[queries[i][0]]);
            result[i] = prefix[queries[i][1]+1] - prefix[queries[i][0]];
        }

        return result;
    }
    
    public boolean isVowel(char c) {
        for (char v : vowels) {
            if (c == v) return true;
        }
        return false;
    }
}
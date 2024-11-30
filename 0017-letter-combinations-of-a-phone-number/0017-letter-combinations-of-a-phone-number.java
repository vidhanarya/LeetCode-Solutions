class Solution {
    Map<Character, Character[]> digitToChars = new HashMap<>();

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;

        digitToChars.put('2', new Character[]{'a', 'b', 'c'});
        digitToChars.put('3', new Character[]{'d', 'e', 'f'});
        digitToChars.put('4', new Character[]{'g', 'h', 'i'});
        digitToChars.put('5', new Character[]{'j', 'k', 'l'});
        digitToChars.put('6', new Character[]{'m', 'n', 'o'});
        digitToChars.put('7', new Character[]{'p', 'q', 'r', 's'});
        digitToChars.put('8', new Character[]{'t', 'u', 'v'});
        digitToChars.put('9', new Character[]{'w', 'x', 'y', 'z'});

        backtrack(digits, result, new StringBuilder(), 0);
        return result;
    }

    public void backtrack(String digits, List<String> result, StringBuilder sb, int i) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }

        for (char c: digitToChars.get(digits.charAt(i))) {
            sb.append(c);
            backtrack(digits, result, sb, i+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
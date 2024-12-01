class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), n, n);
        return result;
    }

    public void backtrack(List<String> result, StringBuilder sb, int o, int c) {
        if (o > c) return;
        if (o == 0 && c == 0) {
            result.add(sb.toString());
            return;
        }

        if (o > 0) {
            sb.append('(');
            backtrack(result, sb, o - 1, c);
            sb.deleteCharAt(sb.length() - 1);
        }
        
        if (c > 0) {
            sb.append(')');
            backtrack(result, sb, o, c - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
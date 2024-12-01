class Solution {
    int k = 0;
    char[] charSet;

    public String getHappyString(int n, int k) {
        this.k = k;
        this.charSet = new char[]{'a', 'b', 'c'};
        return backtrack(new StringBuilder(), n);
    }

    public String backtrack(StringBuilder sb, int n) {
        if (n == 0 && this.k == 1) return sb.toString();
        else if (n == 0) {
            this.k--;
            return "";
        } 

        String s = "";
        for (char c: this.charSet) {
            if (sb.length() > 0 && c == sb.charAt(sb.length() - 1)) continue;

            sb.append(c);
            s = backtrack(sb, n - 1);
            sb.deleteCharAt(sb.length() - 1);

            if (!s.equals("")) return s;
        }

        return s;
    }
}
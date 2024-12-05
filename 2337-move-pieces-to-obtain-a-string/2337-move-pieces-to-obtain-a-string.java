class Solution {
    public boolean canChange(String start, String target) {
        int n = start.length();
        int s = 0, t = 0;
        while (s < n || t < n) {
            while (s < n && start.charAt(s) == '_') s++;
            while (t < n && target.charAt(t) == '_') t++;
            if (s == n || t == n) return (s == t);

            if (start.charAt(s) != target.charAt(t) ||
            (start.charAt(s) == 'L' && s < t) ||
            (start.charAt(s) == 'R' && s > t)) return false;

            s++;
            t++;
        }

        return (s == t);
    }
}
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, result, new StringBuilder(), new StringBuilder(), 0, 3);
        return result;
    }

    public void backtrack(String s, List<String> result, StringBuilder ip, StringBuilder num, int i, int d) {
        if (i >= s.length() && d == 0) {
            result.add(ip.toString() + '.' + num.toString());
            return;
        }
        if (i >= s.length()) return;

        if (num.length() > 0) {
            ip.append(num.toString());
            if (d != 1) ip.append('.');
            backtrack(s, result, ip, new StringBuilder(), i, d-1);
            if (d != 1) ip.deleteCharAt(ip.length() - 1);
            ip.delete(ip.length() - num.length(), ip.length());
        }

        if (canAddToNum(s, num, i)) {
            num.append(s.charAt(i));
            backtrack(s, result, ip, num, i+1, d);
            num.deleteCharAt(num.length() - 1);
        }
    }

    public boolean canAddToNum(String s, StringBuilder num, int i) {
        if (num.length() == 0) return true;
        if (num.charAt(0) == '0') return false;

        return (Integer.parseInt(num.toString() + s.charAt(i)) <= 255);
    }
}
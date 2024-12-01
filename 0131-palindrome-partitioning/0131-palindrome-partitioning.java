class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 0, s);
        return result;
    }

    public void backtrack(List<List<String>> result, List<String> currList, int start, String s) {
        if (start >= s.length()) {
            result.add(new ArrayList<>(currList));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (!isPalindrome(s, start, end)) continue;

            currList.add(s.substring(start, end + 1));
            backtrack(result, currList, end+1, s);
            currList.removeLast();
        }
    }

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) return false;
        }
        return true;
    }
}
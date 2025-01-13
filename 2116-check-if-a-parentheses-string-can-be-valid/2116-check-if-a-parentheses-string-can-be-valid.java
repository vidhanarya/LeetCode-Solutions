class Solution {
    public boolean canBeValid(String s, String locked) {
        int diff = 0, canOpen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (diff < 0 && canOpen <= 0) {
                return false;
            } else if (diff < 0) {
                diff += 2;
                canOpen -= 1;
            }

            int score = (s.charAt(i) == ')') ? -1 : 1;
            if (locked.charAt(i) == '0' && diff > 0) {
                canOpen += 1;
                score = -1;
            } else if (locked.charAt(i) == '0' && diff == 0) {
                score = 1;
            }

            diff += score;
        }
        
        return (diff == 0);
    }
}

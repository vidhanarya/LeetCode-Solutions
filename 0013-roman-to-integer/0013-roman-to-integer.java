class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanValues = new HashMap<>();
        romanValues.put('I', 1);
        romanValues.put('V', 5);
        romanValues.put('X', 10);
        romanValues.put('L', 50);
        romanValues.put('C', 100);
        romanValues.put('D', 500);
        romanValues.put('M', 1000);

        int result = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (canSubtract(s, i)) result -= romanValues.get(s.charAt(i));
            else result += romanValues.get(s.charAt(i));
        }
        result += romanValues.get(s.charAt(s.length() - 1));

        return result;
    }

    public boolean canSubtract(String s, int i) {
        return ((s.charAt(i) == 'I' && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X'))
            || (s.charAt(i) == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C'))
            || (s.charAt(i) == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')));
    }
}
class Solution {
    public String intToRoman(int num) {
        Map<String, Integer> romanValues = new HashMap<>();
        romanValues.put("M", 1000);
        romanValues.put("CM", 900);
        romanValues.put("D", 500);
        romanValues.put("CD", 400);
        romanValues.put("C", 100);
        romanValues.put("XC", 90);
        romanValues.put("L", 50);
        romanValues.put("XL", 40);
        romanValues.put("X", 10);
        romanValues.put("IX", 9);
        romanValues.put("V", 5);
        romanValues.put("IV", 4);
        romanValues.put("I", 1);
        String[] order = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0 && i < order.length) {
            while(num < romanValues.get(order[i])) i++;
            
            sb.append(order[i]);
            num -= romanValues.get(order[i]);
        }

        return sb.toString();
    }
}
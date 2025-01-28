class Solution {
    public String largestGoodInteger(String num) {
        String goodInt = "";
        for (int i = 0; i < num.length() - 2; i++) {
            char c1 = num.charAt(i);
            char c2 = num.charAt(i+1);
            char c3 = num.charAt(i+2);
            if (c1 != c2 || c1 != c3) continue;
            if (goodInt.length() == 0 || goodInt.charAt(0) < c1) {
                goodInt = num.substring(i, i+3);
            }
        }

        return goodInt;
    }
}
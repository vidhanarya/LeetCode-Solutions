class Solution {
    public int[] minOperations(String boxes) {
        int[] prefix = new int[boxes.length()+1];
        int counter = 0;
        for (int i = 1; i <= boxes.length(); i++) {
            prefix[i] = prefix[i-1] + counter;
            if (boxes.charAt(i-1) == '1') counter++;
        }

        int[] suffix = new int[boxes.length()+1];
        counter = 0;
        for (int i = boxes.length()-1; i >= 0; i--) {
            suffix[i] = suffix[i+1] + counter;
            if (boxes.charAt(i) == '1') counter++;
        }

        int[] result = new int[boxes.length()];
        for (int i = 0; i < boxes.length(); i++) {
            result[i] = prefix[i+1] + suffix[i];
        }

        return result;
    }
}
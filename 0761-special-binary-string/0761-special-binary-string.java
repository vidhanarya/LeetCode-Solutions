class State {

}

class Solution {
    public String makeLargestSpecial(String s) {
        if (s.length() == 0) return s;

        List<String> result = new ArrayList<>();
        int balance = 0, start = 0;
        for (int i = 0; i < s.length(); i++) {
            balance += (s.charAt(i) == '1') ? 1 : -1;
            if (balance == 0) {
                result.add("1" + makeLargestSpecial(s.substring(start+1, i)) + "0");
                start = i+1;
            }
        }

        Collections.sort(result, Comparator.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for (String r : result) {
            sb.append(r);
        }
        return sb.toString();
    }
}

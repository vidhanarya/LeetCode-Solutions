class Solution {
    public String smallestNumber(String pattern) {
        boolean[] used = new boolean[10];
        for (int start = 1; start <= 9; start++) {
            used[start] = true;
            List<Integer> result = backtrack(pattern, new ArrayList<>(List.of(start)), used, 0);
            if (result != null) {
                return getNumString(result);
            }
            used[start] = false;
        }

        return "";
    }

    public List<Integer> backtrack(String p, List<Integer> num, boolean[] used, int idx) {
        if (idx == p.length()) return new ArrayList<>(num);
        
        char op = p.charAt(idx);
        int lastNum = num.get(num.size() - 1);
        if (op == 'I' && lastNum == 9) return null;
        if (op == 'D' && lastNum == 1) return null;

        for (int s = 1; s <= 9; s++) {
            if (used[s]) continue;
            if (op == 'I' && s <= lastNum) continue;
            if (op == 'D' && s >= lastNum) break;

            num.add(s);
            used[s] = true;

            List<Integer> result = backtrack(p, num, used, idx+1);
            if (result != null) {
                return result;
            }

            used[s] = false;
            num.remove(num.size() - 1);
        }

        return null;
    }

    public String getNumString(List<Integer> num) {
        StringBuilder sb = new StringBuilder();
        for (int n : num) {
            sb.append(String.valueOf(n));
        }

        return sb.toString();
    }
}
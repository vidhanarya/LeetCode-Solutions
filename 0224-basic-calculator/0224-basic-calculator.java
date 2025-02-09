class Solution {
    public int calculate(String s) {
        s = normalizeExpression(s);
        Map<Integer, Integer> expressionIndices = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            }
            if (s.charAt(i) == ')') {
                expressionIndices.put(stack.pop(), i);
            }
        }

        return evaluate(s, expressionIndices, 0, s.length()-1);
    }

    public int evaluate(String s, Map<Integer, Integer> expressionIndices, int left, int right) {
        int result = 0;

        int idx = left;
        while (idx <= right) {
            int curr = 0;
            int start = idx;
            if (s.charAt(idx) == '+' || s.charAt(idx) == '-') {
                idx++;
                continue;
            }
            if (s.charAt(idx) == '(') {
                int end = expressionIndices.get(idx);
                curr = evaluate(s, expressionIndices, start+1, end-1);
                idx = end + 1;
            } else {
                StringBuilder numberString = new StringBuilder();
                while (idx <= right && Character.isDigit(s.charAt(idx))) {
                    numberString.append(s.charAt(idx++));
                }

                curr = Integer.parseInt(numberString.toString());
            }

            if (start > left && s.charAt(start-1) == '-') result -= curr;
            else result += curr;
        }

        return result;
    }

    public String normalizeExpression(String expression) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == ' ') continue;
            sb.append(expression.charAt(i));
        }

        return sb.toString();
    }
}
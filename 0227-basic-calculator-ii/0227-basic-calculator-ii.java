class Solution {
    public int calculate(String s) {
        String[] expression = s.replace(" ", "").split("(?=[-+*/])|(?<=[-+*/])");
        Stack<String> stack = new Stack<>();
        
        for (String exp : expression) {
            if (exp.equals("+")) continue;
            
            if (stack.empty() || exp.equals("-") || exp.equals("*") || exp.equals("/")) {
                stack.push(exp);
                continue;
            }

            String lastOp = stack.pop();
            if (lastOp.equals("-")) {
                stack.push(lastOp + exp);
            } else if (lastOp.equals("*")) {
                int subResult = Integer.parseInt(stack.pop()) * Integer.parseInt(exp);
                stack.push(String.valueOf(subResult));
            } else if (lastOp.equals("/")) {
                int subResult = Integer.parseInt(stack.pop()) / Integer.parseInt(exp);
                stack.push(String.valueOf(subResult));
            } else {
                stack.push(lastOp);
                stack.push(exp);
            }
        }

        int result = 0;
        while (!stack.empty()) {
            result += Integer.parseInt(stack.pop());
        }

        return result;
    }
}
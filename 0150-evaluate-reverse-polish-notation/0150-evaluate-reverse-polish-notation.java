class Solution {
    private BiFunction<Integer, Integer, Integer> addFn = (b, a) -> a + b;
    private BiFunction<Integer, Integer, Integer> subFn = (b, a) -> a - b;
    private BiFunction<Integer, Integer, Integer> mulFn = (b, a) -> a * b;
    private BiFunction<Integer, Integer, Integer> divFn = (b, a) -> a / b;

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (isOperator(token)) {
                BiFunction<Integer, Integer, Integer> opFn = getOperator(token);
                stack.push(opFn.apply(stack.pop(), stack.pop()));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public boolean isOperator(String token) {
        return (token.equals("+") || token.equals("*") || token.equals("/") || token.equals("-"));
    }

    public BiFunction<Integer, Integer, Integer> getOperator(String token) {
        switch (token) {
            case "+":
                return addFn;
            case "-":
                return subFn;
            case "*":
                return mulFn;
            default:
                return divFn;
        }
    }
}
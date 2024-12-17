class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c: s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>();
        Stack<Character> stack = new Stack<>();
        for (char c: freq.keySet()) {
            maxHeap.add(c);
        }

        while (!maxHeap.isEmpty()) {
            stack.push(maxHeap.remove());
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.empty()) {
            char first = stack.pop();
            int count = freq.get(first);
            for (int i = 0; i < repeatLimit; i++) {
                if (count == 0) break;
                count--;
                result.append(first);
            }

            freq.put(first, count);
            if (count > 0 && stack.size() > 0) {
                char second = stack.pop();
                result.append(second);
                freq.put(second, freq.get(second) - 1);
                if (freq.get(second) > 0) stack.push(second);
                stack.push(first);
            }
        }
        return result.toString();
    }
}
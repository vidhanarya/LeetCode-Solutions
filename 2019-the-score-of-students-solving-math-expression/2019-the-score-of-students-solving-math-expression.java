class Solution {
    Map<String, Set<Integer>> memo;
    public int scoreOfStudents(String s, int[] answers) {
        memo = new HashMap<>();
        int correctAnswer = getCorrectAnswer(s, 0, s.length()-1);
        Set<Integer> allAnswers = getAllAnswers(s, 0, s.length()-1);

        int score = 0;
        for (int a: answers) {
            if (a == correctAnswer) score += 5;
            else if (allAnswers.contains(a)) score += 2;
        }
        return score;
    }

    public int getCorrectAnswer(String s, int left, int right) {
        if (left == right) return Integer.parseInt(s.substring(left, right+1));

        for (int i = left+1; i <= right; i += 2) {
            if (s.charAt(i) == '+') return getCorrectAnswer(s, left, i-1) + getCorrectAnswer(s, i+1, right);
        }

        int ans = 1;
        for (int i = left; i <= right; i += 2) {
            ans *= Integer.parseInt(s.substring(i, i+1));
        }
        return ans;
    }

    public Set<Integer> getAllAnswers(String s, int left, int right) {
        String k = key(left, right);
        if (memo.containsKey(k)) return memo.get(k);

        Set<Integer> answer = new HashSet<>();
        if (left == right) {
            answer.add(Integer.parseInt(s.substring(left, right+1)));
        } else {
            for (int i = left+1; i < right; i += 2) {
                Set<Integer> leftEvaluate = getAllAnswers(s, left, i-1);
                Set<Integer> rightEvaluate = getAllAnswers(s, i+1, right);

                for (int l: leftEvaluate) {
                    for (int r: rightEvaluate) {
                        int ans = (s.charAt(i) == '+') ? l+r : l*r;
                        if (ans > 1000) continue;
                        
                        answer.add(ans);
                    }
                }
            }
        }

        memo.put(k, answer);
        return answer;
    }

    public String key(int l, int r) {
        return l + ", " + r;
    }
}

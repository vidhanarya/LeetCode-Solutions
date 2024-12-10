class State {
    char character;
    int length;

    State(char c, int l) {
        character = c;
        length = l;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        State state = (State) obj;
        return character == state.character && Objects.equals(length, state.length);
    }

    @Override
    public int hashCode() {
        return Objects.hash(character, length);
    }
}

class Solution {
    public int maximumLength(String s) {
        Map<State, Integer> freq = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            int currLen = 0;

            for (int j = i; j < s.length(); j++) {
                if (!(currLen == 0 || s.charAt(j) == s.charAt(j-1))) break;

                currLen++;
                State state = new State(s.charAt(j), currLen);
                freq.put(state, freq.getOrDefault(state, 0) + 1);
            }
        }

        int result = -1;
        for (var entry : freq.entrySet()) {
            int length = entry.getKey().length;
            if (entry.getValue() >= 3) result = Math.max(result, length);
        }

        return result;
    }
}
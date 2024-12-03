class State {
    int idx;
    int target;

    State(int idx, int target) {
        this.idx = idx;
        this.target = target;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idx, target);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        State other = (State) obj;
        return idx == other.idx && target == other.target;
    }
}

class Solution {
    Map<State, Integer> memo;

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return dp(nums, new State(0, target));
    }

    public int dp(int[] nums, State state) {
        if (memo.containsKey(state)) return memo.get(state);
        
        int ans = 0;
        if (state.idx == nums.length - 1) {
            ans += (nums[state.idx] == state.target) ? 1 : 0;
            ans += (nums[state.idx] == -state.target) ? 1 : 0;
        } else {
            ans += dp(nums, new State(state.idx + 1, state.target - nums[state.idx]));
            ans += dp(nums, new State(state.idx + 1, state.target + nums[state.idx]));
        }

        memo.put(state, ans);
        return ans;
    }
}
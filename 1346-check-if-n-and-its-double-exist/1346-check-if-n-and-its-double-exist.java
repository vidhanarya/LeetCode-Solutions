class Solution {
    public boolean checkIfExist(int[] arr) {
        Set<Integer> visited = new HashSet<>();
        for (int n: arr) {
            if (visited.contains(2*n) || (n % 2 == 0 && visited.contains(n / 2))) return true;
            visited.add(n);
        }

        return false;
    }
}
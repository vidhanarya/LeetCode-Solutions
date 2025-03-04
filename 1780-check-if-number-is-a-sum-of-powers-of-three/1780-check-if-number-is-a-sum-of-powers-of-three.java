class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 0) n = n / 3;
            else if ((n - 1) % 3 == 0) n = (n - 1) / 3;
            else return false;
        }

        return true;
    }
}

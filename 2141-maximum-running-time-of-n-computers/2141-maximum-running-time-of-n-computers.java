class Solution {
    public long maxRunTime(int n, int[] batteries) {
        if (batteries.length < n) return 0;
        sortDescending(batteries);
        
        long left = 0, right = 100000000000001L;
        while (left < right) {
            long mid = right - (right - left) / 2;

            if (check(batteries, n, mid)) left = mid;
            else right = mid - 1;
        }

        return left;
    }

    public boolean check(int[] batteries, int computers, long maxTime) {
        long availableJuice = 0;
        for (int i = computers; i < batteries.length; i++) {
            availableJuice += batteries[i];
        }

        long time = batteries[computers - 1];
        for (int i = computers - 1; i >= 0; i--) {
            long deltaIncrease = availableJuice / (computers - i);
            long temp = (i > 0) ? Math.min(deltaIncrease, (batteries[i-1] - batteries[i])) : deltaIncrease;
            time += temp;
            availableJuice -= temp * (computers - i);
            if (availableJuice == 0) break;
        }

        return (time >= maxTime);
    }

    public void sortDescending(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }
}
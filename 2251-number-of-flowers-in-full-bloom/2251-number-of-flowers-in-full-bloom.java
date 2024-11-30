class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int[] start = new int[flowers.length];
        int[] end = new int[flowers.length];

        for (int i = 0; i < flowers.length; i++) {
            start[i] = flowers[i][0];
            end[i] = flowers[i][1] + 1;
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int[] answer = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            int l = binarySearch(end, people[i]);
            int r = binarySearch(start, people[i]);
            answer[i] = r - l;
        }

        return answer;
    }

    public int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] > target) right = mid;
            else left = mid + 1;
        }

        return left;
    }
}


// [1,6],[3,7],[9,12],[5,13]

// [1, 3, 5, 9]
// [6, 7, 12, 13]
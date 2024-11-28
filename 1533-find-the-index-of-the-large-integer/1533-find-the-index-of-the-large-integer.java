/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        int left = 0, right = reader.length() - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            int r = ((right - left + 1) % 2 == 1) ? mid - 1 : mid;
            int comparison = reader.compareSub(left, r, mid + 1, right);
            if (comparison == 0) return mid;
            else if (comparison > 0) right = r;
            else left = r + 1;
        }

        return left;
    }
}
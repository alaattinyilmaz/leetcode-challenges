// 977. Squares of a Sorted Array - https://leetcode.com/problems/squares-of-a-sorted-array/

class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int leftsq = nums[left]*nums[left];
            int rightsq = nums[right]*nums[right];
            if (leftsq > rightsq) {
                res[i] = leftsq;
                left++;
            }
            else {
                res[i] = rightsq;
                right--;
            }
        }
        return res;
    }
}